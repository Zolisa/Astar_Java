package components;

import components.interfaces.IMap;
import components.interfaces.INode;

import java.util.ArrayList;

/**
 * @author Navaneeth Sen
 * @since 2015/08/20
 */

public abstract class Node implements INode
{
    /**
     * The x coordinate of the node
     */
    protected int x;
    /**
     * The y coordinate of the node
     */
    protected int y;

    /**
     * The path movementCost for this node
     */
    protected float movementCost = 0;
    /**
     * The parent of this node, how we reached it in the search
     */
    protected INode parent;

    /**
     * The heuristic cost of this node
     */
    protected float heuristicCost = 0;

    protected IMap map;

    protected float weight;

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
    public void setHeuristicCost(float heuristicCost)
    {
        this.heuristicCost = heuristicCost;
    }

    @Override
    public void setMovementCostFromStart(float movementCost)
    {
        this.movementCost = movementCost;
    }

    /**
     * Create a new node
     *
     * @param x The x coordinate of the node
     * @param y The y coordinate of the node
     */
    public Node(int x, int y, IMap map, float weight)
    {
        this.x = x;
        this.y = y;
        this.map = map;
        this.weight = weight;
    }

    public INode getParent()
    {
        return parent;
    }

    /**
     * Set the parent of this node
     *
     * @param parent The parent node which lead us to this node
     * @return The depth we have no reached in searching
     */
    @Override
    public void setParent(INode parent)
    {
        this.parent = parent;
    }

    /**
     * The X co-ordinate of Node
     *
     * @return x
     */
    @Override
    public int getX()
    {
        return x;
    }

    /**
     * The Y co-ordinate of Node
     *
     * @return y
     */
    @Override
    public int getY()
    {
        return y;
    }

    /**
     * Returns the list of Neighbour nodes of this node
     *
     * @param allowDiagonalMovement - Will include the diagonal elements
     * @return list of neighbour Nodes
     * <p/>
     * Node Neighbours
     * ________________
     * |    |    |    |
     * | NW | N  | NE |
     * ----------------
     * |    |    |    |
     * | W  | *  | E  |
     * ----------------
     * |    |    |    |
     * | SW | S  | SE |
     * ----------------
     */
    public ArrayList<INode> getNeighbourList(boolean allowDiagonalMovement)
    {
        ArrayList<INode> neighborList = new ArrayList<INode>();

        // North
        if (!(y == 0))
        {
            neighborList.add(map.getNodeAtPosition(x, (y - 1)));
        }

        // East
        if (!(x == (map.getMapWidth() - 1)))
        {
            neighborList.add(map.getNodeAtPosition(x + 1, y));
        }

        // South
        if (!(y == (map.getMapHeight() - 1)))
        {
            neighborList.add(map.getNodeAtPosition(x, y + 1));
        }

        // West
        if (!(x == 0))
        {
            neighborList.add(map.getNodeAtPosition(x - 1, y));
        }


        if (allowDiagonalMovement)
        {
            // North East
            if (!(y == 0) && !(x == (map.getMapWidth() - 1)))
            {
                neighborList.add(map.getNodeAtPosition(x + 1, y - 1));
            }

            // South East
            if (!(x == (map.getMapWidth() - 1)) && !(y == (map.getMapHeight() - 1)))
            {
                neighborList.add(map.getNodeAtPosition(x + 1, y + 1));
            }

            // South West
            if (!(x == 0) && !(y == (map.getMapHeight() - 1)))
            {
                neighborList.add(map.getNodeAtPosition(x - 1, y + 1));
            }

            // North West
            if (!(x == 0) && !(y == 0))
            {
                neighborList.add(map.getNodeAtPosition(x - 1, y - 1));
            }
        }

        return neighborList;
    }

    /**
     * Get the weight of the node
     *
     * @return weight
     */
    public float getWeight()
    {
        return weight;
    }

    /**
     * Sets the weight of the Node
     *
     * @param weight
     */
    public void setWeight(float weight)
    {
        this.weight = weight;
    }

    /**
     * Compares the object based on the fCost.
     * Helps in keeping teh Sorted List sorted
     */
    public int compareTo(INode other)
    {
        INode o = other;

        float fCost = getHeuristicCost() + getMovementCostFromStart();
        float ofCost = o.getHeuristicCost() + o.getMovementCostFromStart();

        if (fCost < ofCost)
        {
            return -1;
        }
        else if (fCost > ofCost)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
