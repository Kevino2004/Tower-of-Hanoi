// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Kevin O'Neill (ckoneill04)
package towerofhanoi;
/**
 *  Tower class.
 * 
 * @author Kevin O'Neill (ckoneill04)
 * @version 2023.10.16
 */
public class Tower
    extends LinkedStack<Disk>
{
    //~ Fields ................................................................
    private Position position;
    //~ Constructors ..........................................................
    /**
     * Tower constructor.
     * @param pos position
     */
    public Tower(Position pos)
    {
        super();
        position = pos;
    }
    //~Public  Methods ........................................................
    /**
     * Position method.
     * @return position
     */
    public Position position()
    {
        return position;
    }
    /**
     * Push method.
     * @param disk disk
     */
    @Override
    public void push(Disk disk)
    {
        if (disk == null) 
        {
            throw new IllegalArgumentException("Cannot push a null disk.");
        }

        if (isEmpty() || disk.compareTo(peek()) < 0) 
        {
            super.push(disk);
        } 
        else 
        {
            throw new IllegalStateException("Invalid push");
        }
    }
}
