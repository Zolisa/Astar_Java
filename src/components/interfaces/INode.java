package components.interfaces;

/**
 * @author Navaneeth Sen
 * @since 2015/08/21
 */

import java.util.ArrayList;

/**
 * The interface which exposes the features available with a Node
 */
public interface INode extends Comparable<INode>
{
    float getHeuristicCost();

    void setHeuristicCost(float heuristicCost);

    float getMovementCostFromStart();

    void setMovementCostFromStart(float movementCost);

    void setParent(INode parent);

    int getX();

    int getY();

    boolean isWalkable();

    String getNodeName();

    char getNodeValue();

    INode getParent();

    float getWeight();

    void setWeight(float weight);

    ArrayList<INode> getNeighbourList(boolean allowDiagonalMovement);

}
