// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Kevin O'Neill (ckoneill04)
package towerofhanoi;
import java.util.Observable;

/**
 *  Hanoi Solver class.
 * 
 * @author Kevin O'Neill (ckoneill04)
 * @version 2023.10.16
 */
@SuppressWarnings("deprecation")
public class HanoiSolver
    extends Observable
{
    //~ Fields ................................................................
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;
    //~ Constructors ..........................................................
    /**
     * Constructor
     * @param numD number of disks
     */
    public HanoiSolver(int numD)
    {
        numDisks = numD;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }
    //~Public  Methods ........................................................
    /**
     * Disks method.
     * @return number of disks
     */
    public int disks()
    {
        return numDisks;
    }
    /**
     * Get Tower method.
     * @param pos position
     * @return left, middle, right
     */
    public Tower getTower(Position pos)
    {
        switch (pos) 
        {
            case LEFT:
                return left;
            case MIDDLE:
                return middle;
            case RIGHT:
                return right;
            default:
                return middle;
        }
    }
    /**
     * To string method.
     * @return toString()
     */
    public String toString()
    {
        String leftStr = left.toString();
        String middleStr = middle.toString();
        String rightStr = right.toString();
        
        return leftStr + middleStr + rightStr;
    }
    /**
     * Move method
     * @param source
     * @param destination
     */
    private void move(Tower source, Tower destination)
    {
        destination.push(source.pop());
        setChanged();
        notifyObservers(destination.position());
    }
    /**
     * Solve towers method.
     * @param curDisks current disks
     * @param start left tower
     * @param temp middle tower
     * @param end right tower
     */
    private void solveTowers(int curDisks, Tower start, Tower temp, Tower end)
    {
        if (curDisks == 1)
        {
            move(start, end);
        }
        else
        {
            solveTowers(curDisks - 1, start, end, temp);
            move(start, end);
            solveTowers(curDisks - 1, temp, start, end);
        }
    }
    /**
     * Solve method.
     */
    public void solve()
    {
        solveTowers(numDisks, left, middle, right);
    }
}
