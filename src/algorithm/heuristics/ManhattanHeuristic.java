package algorithm.heuristics;

import components.interfaces.INode;

/**
 * @author Navaneeth Sen
 * @since 2015/08/20
 */

public class ManhattanHeuristic implements IHeuristic
{
    public ManhattanHeuristic()
    {
        System.out.println("Using ManhattanHeuristic ...");
    }

    @Override
    public float getHeuristicCost(int srcX, int srcY, INode destinationINode)
    {
        int dx = destinationINode.getX() - srcX;
        int dy = destinationINode.getY() - srcY;

        return Math.abs(dx) + Math.abs(dy);
    }
}
