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

/**
 * @author Navaneeth Sen
 * @since 2015/08/20
 */

import java.util.ArrayList;

/**
 * A path determined by an algorithm. It contains the touchPoints from start to end nodes
 */
public class Path
{
    /**
     * The list of touchPoints for this path
     */
    private ArrayList<TouchPoint> touchPoints = new ArrayList<TouchPoint>();

    public Path()
    {
    }

    /**
     * Get Length of teh path
     * @return
     */
    public int getLength()
    {
        return touchPoints.size();
    }

    /**
     * Get the touchPoint at a particular Index
     * @param index
     * @return
     */
    public TouchPoint getTouchPoint(int index)
    {
        return touchPoints.get(index);
    }

    public int getX(int index)
    {
        return getTouchPoint(index).x;
    }

    public int getY(int index)
    {
        return getTouchPoint(index).y;
    }

    /**
     * Append Touch points to the list
     * @param x
     * @param y
     */
    public void appendTouchPoint(int x, int y)
    {
        touchPoints.add(new TouchPoint(x, y));
    }

    /**
     * Prepend touch points to the List
     * @param x
     * @param y
     */
    public void prependTouchPoint(int x, int y)
    {
        touchPoints.add(0, new TouchPoint(x, y));
    }

    public boolean contains(int x, int y)
    {
        return touchPoints.contains(new TouchPoint(x, y));
    }
}
