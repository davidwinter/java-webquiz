import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;

import java.util.Vector;

import models.*;

public class MarkController extends HttpServlet
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
        // get player object
        // will be null if one does not exist
        HttpSession session = request.getSession();
        Player player = (Player) session.getAttribute("player");
        
        // if player object exists in session
        // required so that it can get questions/answers
        if (player != null)
        {
            // get the Quiz from the session
            Quiz quiz = player.getQuiz();

            // the number of answers correctly answered
            int correctAnswers = 0;

            // for each question in the quiz
            for (Question question : quiz.getQuestions())
            {
                // get the selected answer for the question
                // if one wasn't selected, selectedAnswer == null
                String selectedAnswer =
                    request.getParameter(Integer.toString(question.getId()));

                // check if an answer was given
                if (selectedAnswer != null)
                {
                    // convert selected answer to an int (for the id)
                    int selectedAnswerId = Integer.parseInt(selectedAnswer);
                    
                    // for each possible answer of the question
                    for (Answer answer : question.getAnswers())
                    {
                        // if the id is that of the one selected
                        if (answer.getId() == selectedAnswerId)
                        {
                            // check if correct or not
                            if (answer.isCorrect())
                            {
                                // if so, 1 correct answer added to total
                                correctAnswers++;
                            }
                        }
                    }
                }            
            }
            
            // number of questions in quiz
            int numberOfQuestions = quiz.getQuestions().size();
            
            // work out score %
            double score = 
                ((double) correctAnswers / (double) numberOfQuestions) * 100;

            // set mark/score for player
            player.setMark((int) score);

            ///////////////////////////
            
            // vector to store the high scores
            // will use player objects for names and marks
            Vector<Player> highScores = new Vector<Player>();

            /**
             * Connect to MySQL
             */
            try
            {
                mysql = DriverManager.getConnection("jdbc:mysql://rhino.cscs.wmin.ac.uk/"
                    + "w0413500?user=w0413500&password=06071985");

                // get session object of scoreAdded
                Boolean scoreAdded = (Boolean) session.getAttribute("scoreAdded");
                
                // if score for this session has previously been added,
                // it will return true.
                // otherwise, it'll be null
                // meaning the score hasn't been added to MySQL for the 
                // current player
                if (scoreAdded == null || scoreAdded == false)
                {
                    query = mysql.createStatement();

                    String insertScoreQuery = "INSERT INTO highscores VALUES (NULL, '"
                        + player.getName() + "', '"
                        + player.getMark() + "')";

                    // insert score into MySQL
                    query.executeUpdate(insertScoreQuery);
                    
                    // score added to MySQL TRUE
                    scoreAdded = true;
                    // set to session so that app is aware score already added
                    session.setAttribute("scoreAdded", scoreAdded);
                }

                query = mysql.createStatement();

                // now retrieve 10 most high scores
                ResultSet scoreRows = 
                    query.executeQuery("SELECT * FROM highscores ORDER BY "
                                        + "highscore DESC LIMIT 0, 10");

                // for all the scores returned
                while (scoreRows.next())
                {
                    // create a new player object
                    Player highScorePlayer = 
                        new Player(scoreRows.getString("playername"));
                    highScorePlayer.setMark(scoreRows.getInt("highscore"));

                    // add player to vector
                    highScores.add(highScorePlayer);
                }
                
                session.setAttribute("highScorePlayers", highScores);

                query.close();
            }
            catch (SQLException exc)
            {
                System.out.println("SQLException: " + exc);
            }

            // forward onto results page
            RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher("/result.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            // if no player session object found, restart quiz
            RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
        
    }
    
    // if someone attempts to access page directly, return to start
    public void doGet(HttpServletRequest request, 
        HttpServletResponse response) throws IOException, ServletException
    {
        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}