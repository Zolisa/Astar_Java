package components.terrains;

import components.AMapConstants;
import components.Node;
import components.interfaces.IMap;

/**
 * @author Navaneeth Sen
 * @since 2015/08/21
 */

public class MountainNode extends Node
{
    /**
     * Create a new node
     *
     * @param x The x coordinate of the node
     * @param y The y coordinate of the node
     */
    public MountainNode(int x, int y, IMap map, float weight)
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
        return "Mountain";
    }

    @Override
    public char getNodeValue()
    {
        return AMapConstants.MOUNTAIN_CHAR;
    }

    @Override
    public String toString()
    {
        return "MountainNode{" + getHeuristicCost() + "," + getMovementCostFromStart() + "}";
    }
}
