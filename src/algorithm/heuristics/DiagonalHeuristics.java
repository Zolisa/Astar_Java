package algorithm.heuristics;

import components.interfaces.INode;

/**
 * @author Navaneeth Sen
 * @since 2015/08/22
 */

/**
 * If the map allows diagonal movements.
 */
public class DiagonalHeuristics implements IHeuristic
{
    public DiagonalHeuristics()
    {
        System.out.println("Using DiagonalHeuristics ...");
    }

    @Override
    public float getHeuristicCost(int srcX, int srcY, INode destinationINode)
    {

        // When D = 1 and D2 = 1, this is called the Chebyshev distance.
        // When D = 1 and D2 = sqrt(2), this is called the Octile distance.
        double D = 1;
        double D2 = Math.sqrt(2);

        double d1 = Math.abs(destinationINode.getX() - srcX);
        double d2 = Math.abs(destinationINode.getY() - srcY);

        return (float) ((D * (d1 + d2)) + ((D2 - (2 * D)) * Math.min(d1, d2)));
    }
}
