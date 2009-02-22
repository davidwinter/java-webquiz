package models;

/**
 * Class to represent a quiz player.
 *
 * @author David Winter
 */
public class Player
{
    /**
     * String representation of the players name.
     */
    private String name;
    
    private Quiz quiz;
    
    private int mark = 0;
    
    public Player()
    {
        this("");
    }
    
    /** 
     * Conversion constructor that creates a new player based on a name.
     *
     * @param   name    The players name.
     */
    public Player(String name)
    {        
        if (name == "")
        {
            setName("Anonymous");
        }
        else
        {
            setName(name);
        }
    }
    
    /**
     * Mutator method that sets the players name.
     *
     * @param   name    The players name.
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Accessor method that returns the players name.
     *
     * @return The players name.
     */
    public String getName()
    {
        return name;
    }
    
    public void setQuiz(Quiz quiz)
    {
        this.quiz = quiz;
    }
    
    public Quiz getQuiz()
    {
        return quiz;
    }
    
    public String toString()
    {
        return getName();
    }
    
    public void setMark(int mark)
    {
        this.mark = mark;
    }
    
    public int getMark()
    {
        return mark;
    }
}