package algorithm.heuristics;

import components.interfaces.INode;

/**
 * @author Navaneeth Sen
 * @since 2015/08/20
 */

/**
 * If the units can move at any angle (instead of grid directions)
 */
public class EuclideanHeuristic implements IHeuristic
{
    public EuclideanHeuristic()
    {
        System.out.println("Using EuclideanHeuristic ...");
    }

    @Override
    public float getHeuristicCost(int srcX, int srcY, INode destinationINode)
    {
        int dx = destinationINode.getX() - srcX;
        int dy = destinationINode.getY() - srcY;

        return (float) (Math.sqrt((dx * dx) + (dy * dy)));
    }
}
