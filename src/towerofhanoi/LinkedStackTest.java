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
public class LinkedStackTest
    extends student.TestCase
{
    //~ Fields ................................................................
    private LinkedStack<String> stack;
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    /**
     * Set up method.
     */
    public void setUp() {
        stack = new LinkedStack<>();
    }
    /**
     * Test empty stack method.
     */
    public void testEmptyStack() 
    {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }
    /**
     * Test push and pop method.
     */
    public void testPushAndPop() 
    {
        stack.push("1");
        stack.push("2");
        stack.push("3");

        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());
        assertEquals("3", stack.pop());
        assertEquals("2", stack.pop());
        assertEquals("1", stack.pop());
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }
    /**
     * Test peek method.
     */
    public void testPeek() 
    {
        stack.push("10");
        stack.push("20");

        assertEquals("20", stack.peek());
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
    }
    /**
     * Test clear method.
     */
    public void testClear() 
    {
        stack.push("5");
        stack.push("7");

        assertFalse(stack.isEmpty());

        stack.clear();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }
    /**
     * Test toString method.
     */
    public void testToString() 
    {
        stack.push("1");
        stack.push("2");
        stack.push("3");

        assertEquals("[3, 2, 1]", stack.toString());
    }
}
