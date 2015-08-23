package components.interfaces;

import java.util.ArrayList;

/**
 * @author Navaneeth Sen
 * @since 2015/08/22
 */

public interface IMap
{
    void printMap(ArrayList<ArrayList<INode>> map);

    int getMapWidth();

    int getMapHeight();

    ArrayList<ArrayList<INode>> getMap();

    INode getNodeAtPosition(int x, int y);

    float getDistanceBetween(INode node1, INode node2);

    INode getStartNode();

    INode getEndNode();
}
