// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Kevin O'Neill (ckoneill04)
package towerofhanoi;
/**
 *  Linked Stack test class.
 * 
 * @author Kevin O'Neill (ckoneill04)
 * @version 2023.10.16
 */
public class HanoiSolverTest
    extends student.TestCase
{
    //~ Fields ................................................................
    private HanoiSolver hs;
    private Disk d1;
    private Disk d2;
    private Disk d3;
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    /**
     * Set up method.
     */
    public void setUp()
    {
        hs = new HanoiSolver(3);
        d1 = new Disk(5);
        d2 = new Disk(7);
        d3 = new Disk(9);
    }
    /**
     * Test disks.
     */
    public void testDisks() 
    {
        assertEquals(3, hs.disks());
    }
    /**
     * Test get tower.
     */
    public void testGetTower() 
    {
        assertEquals(Position.LEFT, hs.getTower(Position.LEFT).position());
        assertEquals(Position.MIDDLE, hs.getTower(Position.MIDDLE).position());
        assertEquals(Position.RIGHT, hs.getTower(Position.RIGHT).position());
    }
    /**
     * Test toString.
     */
    public void testToString()
    {
        assertEquals("[][][]", hs.toString());
        hs.getTower(Position.LEFT).push(d1);
        hs.getTower(Position.RIGHT).push(d1);
        assertEquals("[5][][5]", hs.toString());
    }
    /**
     * Test solve.
     */
    public void testSolve()
    {
        hs.getTower(Position.LEFT).push(d3);
        hs.getTower(Position.LEFT).push(d2);
        hs.getTower(Position.LEFT).push(d1);
        assertEquals("[5, 7, 9][][]", hs.toString());
        hs.solve();
        assertEquals("[][][5, 7, 9]", hs.toString());
    }
}
