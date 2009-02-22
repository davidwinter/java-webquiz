package models;

/**
 * A class to represent an answer to a question. It contains a string
 * representing the answer text as well as a boolean value declaring whether
 * the answer is true or false - correct or incorrect, respectively.
 *
 * @author David Winter
 */
public class Answer
{
    /**
     * The string representation of the answer.
     */
    private String answer;
    
    /**
     * Boolean value on whether the answer is correct or not.
     */
    private boolean correct;
    
    /**
     * The unique answer ID (used for the database?)
     */
    private int id;
    
    /**
     * Conversion constructor that creates an Answer using a answer, whether
     * it is correct or not, and a unique ID number for the answer.
     *
     * @param   answer      The String representation of the answer.
     * @param   correct     Boolean value whether the answer is correct 
     *                      or not.
     * @param   answerId    Unique code for answer.
     */
    public Answer(String answer, boolean correct, int id)
    {
        setAnswer(answer);
        setCorrect(correct);
        setId(id);
    }
    
    /**
     * Mutator method to set answer value.
     * 
     * @param   answer  The string value for the answer.
     */
    public void setAnswer(String answer)
    {
        this.answer = answer;
    }
    
    /**
     * Accessor method to return answer.
     *
     * @return The string representation of the answer.
     */
    public String getAnswer()
    {
        return answer;
    }
    
    /**
     * Mutator method to set the value of correct.
     *
     * @param   correct The boolean value on whether the answer is correct
     *                  or not.
     */
    public void setCorrect(boolean correct)
    {
        this.correct = correct;
    }
    
    /**
     * Accessor method for the answers boolean value.
     *
     * @return Whether the answer is correct or not.
     */
    public boolean isCorrect()
    {
        return correct;
    }
    
    /**
     * Mutator method to set the answer ID.
     *
     * @param   answerId  The unique code for the answer.
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Accessor method to get the answer ID.
     *
     * @return The answers unique ID.
     */
    public int getId()
    {
        return id;
    }
    
    public String toString()
    {
        return getAnswer();
    }
}