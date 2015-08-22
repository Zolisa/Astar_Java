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

package components.terrains;

import components.AMapConstants;
import components.interfaces.IMap;
import components.Node;

/**
 * @author Navaneeth Sen
 * @since 2015/08/21
 */

public class FlatlandNode extends Node
{
    /**
     * Create a new node
     *
     * @param x The x coordinate of the node
     * @param y The y coordinate of the node
     */
    public FlatlandNode(int x, int y, IMap map, float weight)
    {
        super(x, y, map, weight);
    }

    @Override
    public float getWeight()
    {
        return super.getWeight();
    }

    @Override
    public void setWeight(float weight)
    {
        super.setWeight(weight);
    }

    @Override
    public boolean isWalkable()
    {
        return true;
    }

    @Override
    public String getNodeName()
    {
        return "Flatland";
    }

    @Override
    public char getNodeValue()
    {
        return AMapConstants.FLATLAND_CHAR;
    }

    @Override
    public String toString()
    {
        return "FlatlandNode{" + getHeuristicCost() + "," + getMovementCostFromStart() + "}";
    }
}
