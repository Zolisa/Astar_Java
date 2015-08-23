package components;

import components.interfaces.IMap;
import components.interfaces.INode;

import java.util.ArrayList;

/**
 * @author Navaneeth Sen
 * @since 2015/08/22
 */

public class AMap extends AMapConstants implements IMap
{

    // The translated map, which is an ArrayList of ArrayList of Nodes
    protected ArrayList<ArrayList<INode>> map;

    // map width - number of tiles across the x axis
    protected int mapWidth;

    // map width - number of tiles across the y axis
    protected int mapHeight;

    //just a pointer to the start Location for the outside world
    protected INode startNode = null;

    //just a pointer to the end Location for the outside world
    protected INode endNode = null;

    /**
     * returns the width of the map
     *
     * @return map width
     */
    @Override
    public int getMapWidth()
    {
        return mapWidth;
    }

    /**
     * Returns the height of the map
     *
     * @return map height
     */
    @Override
    public int getMapHeight()
    {
        return mapHeight;
    }

    /**
     * Returns the Node Map
     *
     * @return Node map
     */
    @Override
    public ArrayList<ArrayList<INode>> getMap()
    {
        return map;
    }

    /**
     * Get the node at position x, y in the Node map
     *
     * @param x
     * @param y
     * @return
     */
    @Override
    public INode getNodeAtPosition(int x, int y)
    {
        return map.get(x).get(y);
    }

    /**
     * Gets the distance between two nodes
     *
     * @param node_1
     * @param node_2
     * @return
     */
    @Override
    public float getDistanceBetween(INode node_1, INode node_2)
    {
        // if the nodes are located towards the vertical or horizontal to each other, return 0
        // this is returning zero as the weight of the node will be used for calculating the cost
        if (node_1.getX() == node_2.getX() || node_1.getY() == node_2.getY())
        {
            return 0;
        }
        // if they are diagonal to each other return diagonal distance: sqrt(1^2+1^2) - Pythagoras Theorem
        // why this is returning 0.4 is this is the difference in moving diagonally, the other cost will be calculated from the weights
        else
        {
            return (float) 0.4;
        }
    }

    /**
     * gets teh Start Node
     *
     * @return startNode
     */
    @Override
    public INode getStartNode()
    {
        return startNode;
    }

    /**
     * Gets teh End Node
     *
     * @return endNode
     */
    @Override
    public INode getEndNode()
    {
        return endNode;
    }

    /**
     * Prints the Node map in a 2d representation
     *
     * @param map
     */
    @Override
    public void printMap(ArrayList<ArrayList<INode>> map)
    {
        for (int i = 0; i < mapHeight; i++)
        {
            for (int j = 0; j < mapWidth; j++)
            {
                System.out.print((map.get(i).get(j)).getNodeValue());
            }
            System.out.print("\n");
        }
    }

}
