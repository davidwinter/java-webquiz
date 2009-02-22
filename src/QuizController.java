import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;

import models.*;

public class QuizController extends HttpServlet
{
    private Connection mysql;
    private Statement query;
    
    /**
     * Load MySQL
     */
    public void init() throws ServletException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch (Exception exc)
        {
            System.out.println(exc.toString());
        }
    }
    
    public void doPost(HttpServletRequest request, 
        HttpServletResponse response) throws IOException, ServletException
    {                
        /**
         * Connect to MySQL
         */
        try
        {
            mysql = DriverManager.getConnection("jdbc:mysql://rhino.cscs.wmin.ac.uk/"
                + "w0413500?user=w0413500&password=06071985");
                
            query = mysql.createStatement();
        }
        catch (SQLException exc)
        {
            System.out.println("SQLException: " + exc);
        }
        
        // Create a new Player with the name entered.
        Player player = new Player(request.getParameter("name"));
        
        // Set the Quiz of the player to that created
        player.setQuiz(createQuiz());
        
        // Set player object to session
        HttpSession session = request.getSession();
        session.setAttribute("player", player);
        // so that if new quiz is started, the new players score will be added
        session.setAttribute("scoreAdded", null);
        
        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher("/questions.jsp");
        dispatcher.forward(request, response);
    }
    
    /**
     * If someone tries to access this page directly, then send them back 
     * to the start of Quiz.
     */
    public void doGet(HttpServletRequest request, 
        HttpServletResponse response) throws IOException, ServletException
    {
        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
    
    /**
     * Get's the questions and answers from the Database and constructs a
     * Quiz object containing them.
     *
     * @return The quiz containing the questions and answers from MySQL.
     */
    private Quiz createQuiz()
    {
        Quiz playerQuiz = new Quiz();
        
        try
        {
            ResultSet questionRows = 
                query.executeQuery("SELECT * FROM questions");
            
            // for each question in MySQL
            while (questionRows.next())
            {
                // create object representing Question
                Question quizQuestion = 
                    new Question(questionRows.getString("question")); 
                quizQuestion.setId(questionRows.getInt("id"));
                
                // add Question to Quiz
                playerQuiz.addQuestion(quizQuestion);
            }
            
            query.close();
            
            // for each question in the Quiz object
            for (Question question : playerQuiz.getQuestions())
            {
                String getAnswersQuery = "SELECT * FROM answers WHERE "
                    + "question_id = '" + question.getId() + "'";
                
                // get the answers to the question based on Question ID
                query = mysql.createStatement();
                ResultSet answerRows = 
                    query.executeQuery(getAnswersQuery);
                
                
                // for each answer for the question
                while (answerRows.next())
                {
                    // create Answer object
                    Answer questionAnswer = 
                        new Answer(answerRows.getString("answer"),
                                    answerRows.getBoolean("correct"),
                                    answerRows.getInt("id"));
                    
                    // Add Answer object to Question
                    question.addAnswer(questionAnswer);
                }
            }
            
            query.close();
        }
        catch (SQLException exc)
        {
            System.out.println("SQLException: " + exc);
        }
        
        playerQuiz.shuffle();
        
        return playerQuiz;
    }
}