package components;

import components.interfaces.INode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Navaneeth Sen
 * @since 2015/08/20
 */

public class SortedList
{
    /**
     * The list of elements
     */
    private ArrayList<INode> list = new ArrayList<INode>();

    /**
     * Retrieve the first element from the list
     *
     * @return The first element from the list
     */
    public INode first()
    {
        return list.get(0);
    }

    /**
     * Empty the list
     */
    public void clear()
    {
        list.clear();
    }

    /**
     * Add an element to the list
     *
     * @param o The element to add
     */
    public void add(INode o)
    {
        list.add(o);
    }

    /**
     * Will sort the elements in the list
     */
    public void sort()
    {
        Collections.sort(list);
    }

    /**
     * Remove an element from the list
     *
     * @param o The element to remove
     */
    public void remove(INode o)
    {
        list.remove(o);
    }

    /**
     * Get the number of elements in the list
     *
     * @return The number of element in the list
     */
    public int size()
    {
        return list.size();
    }

    /**
     * Check if an element is in the list
     *
     * @param o The element to search for
     * @return True if the element is in the list
     */
    public boolean contains(INode o)
    {
        return list.contains(o);
    }

    @Override
    public String toString()
    {
        return list.toString();
    }
}

