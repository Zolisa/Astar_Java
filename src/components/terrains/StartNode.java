package components.terrains;

import components.AMapConstants;
import components.interfaces.IMap;

/**
 * @author Navaneeth Sen
 * @since 2015/08/21
 */

public class StartNode extends FlatlandNode
{
    /**
     * Create a new node
     *
     * @param x The x coordinate of the node
     * @param y The y coordinate of the node
     */
    public StartNode(int x, int y, IMap map, float weight)
    {
        super(x, y, map, weight);
    }

    @Override
    public String getNodeName()
    {
        return "Start";
    }

    @Override
    public char getNodeValue()
    {
        return AMapConstants.START_POINT_CHAR;
    }

    @Override
    public float getHeuristicCost()
    {
        return heuristicCost;
    }

    @Override
    public float getMovementCostFromStart()
    {
        return movementCost;
    }

    @Override
    public String toString()
    {
        return "StartNode{" + getHeuristicCost() + "," + getMovementCostFromStart() + "}";
    }
}
