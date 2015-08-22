package components.interfaces;

import components.Node;

import java.util.ArrayList;

/**
 * @author Navaneeth Sen
 * @since 2015/08/22
 */

public interface IMap
{
    void printMap(ArrayList<ArrayList<Node>> map);

    int getMapWidth();

    int getMapHeight();

    ArrayList<ArrayList<Node>> getMap();

    Node getNodeAtPosition(int x, int y);

    float getDistanceBetween(Node node1, Node node2);

    INode getStartNode();

    INode getEndNode();
}
