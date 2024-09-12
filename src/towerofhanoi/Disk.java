// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Kevin O'Neill (ckoneill04)
package towerofhanoi;
import cs2.Shape;
import student.TestableRandom;
import java.awt.Color;
/**
 *  Disk class.
 * 
 * @author Kevin O'Neill (ckoneill04)
 * @version 2023.10.16
 */
public class Disk
    extends Shape
{
    //~ Fields ................................................................

    //~ Constructors ..........................................................
    /**
     * Disk Constructor
     * @param width integer for width of disk.
     */
    public Disk(int width)
    {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom r = new TestableRandom();
        int red = r.nextInt(256);
        int green = r.nextInt(256); 
        int blue = r.nextInt(256); 
        Color col = new Color(red, green, blue);
        setBackgroundColor(col);
    }
    //~Public  Methods ........................................................
    /**
     * compareTo method.
     * @param otherDisk input.
     * @return width - width.
     */
    public int compareTo(Disk otherDisk)
    {
        if (otherDisk == null)
        {
            throw new IllegalArgumentException();
        }
        return this.getWidth() - otherDisk.getWidth();
    }
    /**
     * To string method.
     * @return string
     */
    public String toString()
    {
        return Integer.toString(getWidth());
    }
    /**
     * equals method.
     * @param obj object input.
     * @return true or false
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        Disk otherDisk = (Disk) obj;
        return this.getWidth() == otherDisk.getWidth();
    }
}
