// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Kevin O'Neill (ckoneill04)
package towerofhanoi;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
/**
 *  Puzzle Window class.
 * 
 * @author Kevin O'Neill (ckoneill04)
 * @version 2023.10.16
 */
@SuppressWarnings("deprecation")
public class PuzzleWindow 
    implements Observer 
{

    private HanoiSolver game;
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;
    /**
     * A factor in which the width of the disks are multiplied by
     */
    public static final int WIDTH_FACTOR = 15;
    /**
     * The vertical gap between each disk on the tower
     */
    public static final int DISK_GAP = 0;
    /**
     * The height of each disk on the tower
     */
    public static final int DISK_HEIGHT = 15;


    /**
     * Creates a new PuzzleWindow view for a given HanoiSolver game
     *
     * @param g the game to create a view for
     */
    public PuzzleWindow(HanoiSolver g) 
    {
        this.game = g;
        game.addObserver(this);
        
        window = new Window();
        window.setSize(800, 800);
        window.setTitle("Tower of Hanoi");
        
        int poleHeight = 400;
        int poleY = (window.getGraphPanelHeight() / 2) - (poleHeight / 2);
        left = new Shape((200 - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        middle = new Shape(((window.getGraphPanelWidth() / 2) - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        right = new Shape(((window.getGraphPanelWidth() - 200) - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        
        for (int width = (game.disks() + 1) * WIDTH_FACTOR;
            width > WIDTH_FACTOR; width -= WIDTH_FACTOR) 
        {
            Disk d = new Disk(width);
            game.getTower(Position.LEFT).push(d);
            window.addShape(d);
            moveDisk(Position.LEFT);
        }
        
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        
        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.NORTH);
        solve.onClick(this, "clickedSolve");
    }

    private void moveDisk(Position position) 
    {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole;
        
        switch (position) 
        {
            case LEFT:
                currentPole = left;
                break;
            case MIDDLE:
                currentPole = middle;
                break;
            case RIGHT:
                currentPole = right;
                break;
            default:
                currentPole = middle;
        }
        
        int x = currentPole.getX() + (currentPole.getWidth()
            - currentDisk.getWidth()) / 2;
        int numDisksBelow = game.getTower(position).size() - 1;
        int y = currentPole.getY() + currentPole.getHeight()- (numDisksBelow 
            * (currentDisk.getHeight() + DISK_GAP) + DISK_HEIGHT);

        currentDisk.moveTo(x, y);
    }

    /**
     * Updates the view whenever a disk is moved in the back-end
     *
     * @param o   The observable that triggered the update
     * @param arg arguments sent by the game; should be a position
     */
    @Override
    public void update(Observable o, Object arg) 
    {
        if (arg.getClass() == Position.class) 
        {
            Position position = (Position)arg;
            moveDisk(position);
            sleep();
        }
    }

    /**
     * Runs when the Solve button is clicked, tells the puzzle to start solving
     *
     * @param button the button that was clicked
     */
    public void clickedSolve(Button button) 
    {
        button.disable();
        new Thread() 
        {
            public void run() 
            {
                game.solve();
            }
        }
        .start();
    }

    private void sleep() 
    {
        try 
        {
            Thread.sleep(500);
        }
        catch (Exception e) 
        {
            //
        }
    }
}
