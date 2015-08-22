package components.terrains;

import components.AMapConstants;
import components.interfaces.IMap;
import components.Node;

/**
 * @author Navaneeth Sen
 * @since 2015/08/21
 */

public class ForestNode extends Node
{
    /**
     * Create a new node
     *
     * @param x The x coordinate of the node
     * @param y The y coordinate of the node
     */
    public ForestNode(int x, int y, IMap map, float weight)
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
        return "Forest";
    }

    @Override
    public char getNodeValue()
    {
        return AMapConstants.FOREST_CHAR;
    }

    @Override
    public String toString()
    {
        return "ForestNode{" + getHeuristicCost() + "," + getMovementCostFromStart() + "}";
    }
}
