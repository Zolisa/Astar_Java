/*
 * Copyright (c) Multichoice Technical Operations. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Multichoice Technical Operations. ("Confidential Information"). You
 * shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you
 * entered into with Multichoice Technical Operations.
 *
 * MULTICHOICE MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE
 * SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. MULTICHOICE
 * SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT
 * OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

package components;

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
    private ArrayList<Node> list = new ArrayList<Node>();

    /**
     * Retrieve the first element from the list
     *
     * @return The first element from the list
     */
    public Node first()
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
    public void add(Node o)
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
    public void remove(Node o)
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
    public boolean contains(Node o)
    {
        return list.contains(o);
    }

    @Override
    public String toString()
    {
        return list.toString();
    }
}

