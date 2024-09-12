// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Kevin O'Neill (ckoneill04)
package towerofhanoi;
import java.util.EmptyStackException;
import stack.StackInterface;
/**
 *  LinkedStack class.
 * 
 * @author Kevin O'Neill (ckoneill04)
 * @version 2023.10.16
 * @param <T> Object T.
 */
public class LinkedStack<T>
    implements StackInterface<T>
{
    //~ Fields ................................................................
    private int size;
    private Node topNode;
    //~ Constructors ..........................................................
    /**
     * LinkedStack constructor.
     */
    public LinkedStack()
    {
        topNode = null;
        size = 0;
    }
    //~Public  Methods ........................................................
    /**
     * Size method.
     * @return size of stack.
     */
    public int size()
    {
        return size;
    }
    /**
     * isEmpty method.
     * @return true or false.
     */
    public boolean isEmpty()
    {
        return topNode == null;
    }
    /**
     * Clear method.
     */
    public void clear()
    {
        topNode = null;
        size = 0;
    }
    /**
    * toString method.
    * @return toString.
    */
    public String toString()
    {
        if (isEmpty()) 
        {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");
        Node current = topNode;

        while (current != null) 
        {
            result.append(current.getData());

            if (current.getNextNode() != null) 
            {
                result.append(", ");
            }

            current = current.getNextNode();
        }

        result.append("]");

        return result.toString();
    }
    /**
     * Push method.
     * @param top of stack.
     */
    public void push(T top)
    {
        Node n = new Node(top, topNode);
        topNode = n;
        size++;
    }
    /**
     * Peek method.
     * @return view top of stack.
     */
    public T peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }
    /**
     * Pop method.
     * @return top of stack.
     */
    public T pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        T data = topNode.getData();
        topNode = topNode.getNextNode();
        size--;
        return data;
    }
    /**
     *  Node class.
     * 
     * @author Kevin O'Neill (ckoneill04)
     * @version 2023.10.16
     */
    private class Node
    {
        private T data;
        private Node next;
        
        /**
         * Node constructor.
         * @param obj object entry.
         * @param n node entry.
         */
        public Node(T obj, Node n)
        {
            this(obj);
            this.setNextNode(n);
        }
        /**
         * Node constructor.
         * @param d data object.
         */
        public Node(T d)
        {
            data = d;
        }
        /**
         * setNextNode method.
         * @param n node.
         */
        public void setNextNode(Node n)
        {
            next = n;
        }
        /**
         * getNextNode method.
         * @return next node.
         */
        public Node getNextNode()
        {
            return next;
        }
        /**
         * getData method.
         * @return data.
         */
        public T getData()
        {
            return data;
        }
    }
}
