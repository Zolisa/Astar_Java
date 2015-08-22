package algorithm.heuristics;

import components.interfaces.INode;

/**
 * @author Navaneeth Sen
 * @since 2015/08/20
 */

/**
 * Use the distance heuristic that matches the allowed movement:
 * On a square grid that allows 4 directions of movement, use Manhattan distance (L1).
 * On a square grid that allows 8 directions of movement, use Diagonal distance (L?).
 * On a square grid that allows any direction of movement, you might or might not want Euclidean distance (L2).
 *  If A* is finding paths on the grid but you are allowing movement not on the grid,
 *  you may want to consider other representations of the map.
 */
public interface IHeuristic
{
    float getHeuristicCost(int srcX, int srcY, INode destinationINode);
}
