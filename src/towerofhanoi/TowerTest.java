// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Kevin O'Neill (ckoneill04)
package towerofhanoi;
/**
 *  Tower test class.
 * 
 * @author Kevin O'Neill (ckoneill04)
 * @version 2023.10.16
 */
public class TowerTest
    extends student.TestCase
{
    //~ Fields ................................................................
    private Tower tower;
    private Disk d2;
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    /**
     * Set up method.
     */
    public void setUp()
    {
        tower = new Tower(Position.LEFT);
        Disk d1 = new Disk(3);
        tower.push(d1);
        d2 = new Disk(5);
    }
    /**
     * Test position.
     */
    public void testPosition()
    {
        assertEquals(Position.LEFT, tower.position());
    }
    /**
     * Test push.
     */
    public void testPush()
    {
        IllegalArgumentException exception1 = null;
        try 
        {
            tower.push(null);
        }
        catch (IllegalArgumentException e1)
        {
            exception1 = e1;
        }
        assertNotNull(exception1);
        
        IllegalStateException exception2 = null;
        try 
        {
            tower.push(d2);
        }
        catch (IllegalStateException e2)
        {
            exception2 = e2;
        }
        assertNotNull(exception2);
        
        assertEquals(1, tower.size());
        
    }
}
