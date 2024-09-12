// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Kevin O'Neill (ckoneill04)
package towerofhanoi;
/**
 *  Disk test class.
 * 
 * @author Kevin O'Neill (ckoneill04)
 * @version 2023.10.16
 */
public class DiskTest
    extends student.TestCase
{
    //~ Fields ................................................................
    private Disk d1;
    private Disk d2;
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    /**
     * Set up method.
     */
    public void setUp()
    {
        d1 = new Disk(3);
        d2 = new Disk(5);
    }
    /**
     * Test compareTo method.
     */
    public void testCompareTo() 
    {
        assertTrue(d1.compareTo(d2) < 0);
        assertTrue(d2.compareTo(d1) > 0);
        assertEquals(0, d1.compareTo(d1));
    }
    /**
     * Test toString method.
     */
    public void testToString() 
    {
        assertEquals("3", d1.toString());
        assertEquals("5", d2.toString());
    }
    /**
     * Test equals method.
     */
    public void testEquals() 
    {
        Disk d3 = new Disk(3);
        Disk nullDisk = null;
        Object nonDiskObject = new Object();

        assertTrue(d1.equals(d3));
        assertFalse(d1.equals(d2));
        assertFalse(d1.equals(nullDisk));
        assertFalse(d1.equals(nonDiskObject));
    }
}
