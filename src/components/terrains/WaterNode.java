package components.terrains;

import components.AMapConstants;
import components.interfaces.IMap;
import components.Node;

/**
 * @author Navaneeth Sen
 * @since 2015/08/20
 */

public class WaterNode extends Node
{
    /**
     * Create a new water node
     *
     * @param x The x coordinate of the node
     * @param y The y coordinate of the node
     */
    public WaterNode(int x, int y, IMap map, float weight)
    {
        super(x, y, map, weight);
    }


    @Override
    public boolean isWalkable()
    {
        return false;
    }

    @Override
    public String getNodeName()
    {
        return "Water";
    }

    @Override
    public char getNodeValue()
    {
        return AMapConstants.WATER_CHAR;
    }

    @Override
    public String toString()
    {
        return "WaterNode{" + getHeuristicCost() + "," + getMovementCostFromStart() + "}";
    }
}
