package models;

import java.util.Vector;

/**
 * Class to represent a Question that can contain multiple answers.
 * Also contains a unique Question ID.
 *
 * @author David Winter
 */
public class Question
{
    /**
     * String representation of the question being asked.
     */
    private String question;
    
    /**
     * Vector that can contain multiple answers for the question. Some
     * being correct or incorrect.
     */
    private Vector<Answer> answers;
    
    /**
     * Unique question ID (relating the database entry?)
     */
    private int id;
    
    public Question()
    {
        answers = new Vector<Answer>();
    }
    
    /**
     * Conversion constructor that creates a new question using a String as
     * the question string.
     *
     * @param   question    The question being asked.
     */
    public Question(String question)
    {
        this();
        setQuestion(question);
    }
    
    /**
     * Mutator method that sets the Question string.
     *
     * @param   question    The question string.
     */
    public void setQuestion(String question)
    {
        this.question = question;
    }
    
    /**
     * Accessor method that returns the value of the question string.
     *
     * @return The question string.
     */
    public String getQuestion()
    {
        return question;
    }
    
    /**
     * Add an <code>Answer</code> to the <code>Question</code>. This add an
     * answer object to a Vector.
     *
     * @param   answer  An <code>Answer</code> for the question.
     */
    public void addAnswer(Answer answer)
    {
        answers.add(answer);
    }
    
    /**
     * Accessor method to return the vector containing (possibly) multiple
     * answers.
     *
     * @return The vector containing multiple answers.
     */
    public Vector<Answer> getAnswers()
    {
        return answers;
    }
    
    public void setAnswers(Vector<Answer> answers)
    {
        this.answers = answers;
    }
    
    /**
     * Mutator method that sets the Question ID.
     *
     * @param   questionId  The unique question ID.
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Accessor method for the question ID.
     *
     * @return The question ID value.
     */
    public int getId()
    {
        return id;
    }
    
    public String toString()
    {
        return getQuestion() + getAnswers();
    }
}