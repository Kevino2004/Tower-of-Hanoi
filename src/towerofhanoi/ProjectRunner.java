// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Kevin O'Neill (ckoneill04)
package towerofhanoi;
/**
 *  Project Runner class.
 * 
 * @author Kevin O'Neill (ckoneill04)
 * @version 2023.10.16
 */
public class ProjectRunner
{
    //~ Fields ................................................................

    //~ Constructors ..........................................................
    /**
     * Project Runner constructor.
     */
    public ProjectRunner()
    {
        //Not needed.
    }
    //~Public  Methods ........................................................
    /**
     * Main method.
     * @param args 
     */
    public static void main(String[] args)
    {
        int disks = 6;
        
        if (args.length == 1)
        {
            disks = Integer.parseInt(args[0]);
        }
        
        HanoiSolver hs = new HanoiSolver(disks);
        PuzzleWindow pw = new PuzzleWindow(hs);
    }
}
