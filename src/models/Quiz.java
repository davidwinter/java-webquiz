package models;

import java.util.Vector;
import java.util.Collections;

/**
 * Class that represents a quiz - containing Questions.
 *
 * @author David Winter
 */
public class Quiz
{
    /**
     * String representation of the quiz title.
     */
    private String title;
    
    /**
     * Vector containing multiple questions for the quiz.
     */
    private Vector<Question> questions;
    
    public Quiz()
    {
        questions = new Vector<Question>();
    }
    
    /**
     * Conversion constructor that creates a new quiz based on a title.
     *
     * @param   title   The quizes title.
     */
    public Quiz(String title)
    {
        this();
        setTitle(title);
    }
    
    /**
     * Mutator method that sets the quizes title.
     *
     * @param   title   The quizes title.
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * Accessor method that returns the quizes title.
     *
     * @return The quizes title.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Adds a <code>Question</code> object to the Quiz.
     *
     * @param   question    A question to be added to the quiz.
     */
    public void addQuestion(Question question)
    {
        questions.add(question);
    }
    
    /**
     * Returns all of the questions in the quiz inside of a vector.
     *
     * @return The questions from the quiz, contained in a vector.
     */
    public Vector<Question> getQuestions()
    {
        return questions;
    }
    
    public void shuffle()
    {
        Collections.shuffle(questions);
        
        for (Question question : questions)
        {
            Vector<Answer> answers = question.getAnswers();
            Collections.shuffle(answers);
            //question.setAnswers(answers);
        }
    }
    
    
}