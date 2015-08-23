package algorithm;

import algorithm.heuristics.IHeuristic;
import components.Path;
import components.SortedList;
import components.interfaces.IMap;
import components.interfaces.INode;
import components.terrains.EndNode;
import components.terrains.StartNode;

import java.util.ArrayList;

/**
 * @author Navaneeth Sen
 * @since 2015/08/21
 */

public class A_Star
{
    // Map which is being searched
    private IMap map;

    // Heuristic Method to apply
    private IHeuristic heuristic;

    // list of nodes that has been visited
    private ArrayList<INode> closedList;

    // List of nodes which will be considered while searching
    // This list will be always in a sorted form
    private SortedList openList;

    // The shortest path claculated
    private Path shortestPath = null;

    // If we can move diagonally
    private boolean allowDiagonalMovement;

    /**
     * Constructor which will set the different params and does the path finding
     *
     * @param map
     * @param heuristic
     * @param allowDiagonalMovement
     */
    public A_Star(IMap map, IHeuristic heuristic, boolean allowDiagonalMovement)
    {
        this.map = map;
        this.heuristic = heuristic;

        // containing nodes on the map which may be a next step in the path
        openList = new SortedList();

        // containing nodes that have already been searched
        closedList = new ArrayList<INode>();

        // Allows the mover to jump diagonally if true
        this.allowDiagonalMovement = allowDiagonalMovement;

        // find the shortest path
        findShortestPath();
    }

    /**
     * Finds the shortest path between the Start and End Point if possible
     */
    private void findShortestPath()
    {
        StartNode startNode = (StartNode) map.getStartNode();
        EndNode endNode = (EndNode) map.getEndNode();

        if (startNode != null && endNode != null)
        {
            // reset the lists for starting a new search
            closedList.clear();
            openList.clear();

            // Add the startNode to the openList
            openList.add(startNode);

            // while we haven't reached the end node
            while (openList.size() != 0)
            {
                // Get the first node from the not-searched list(It will be sorted based on the lowest cost)
                INode current = openList.first();

                // Is our current node the end node, then DONE!
                if (current.getX() == map.getEndNode().getX() && current.getY() == map.getEndNode().getY())
                {
                    // if Yes, Construct the Path
                    shortestPath = constructPath(current);
                    return;
                }

                // move current Node to the already searched list
                openList.remove(current);
                closedList.add(current);

                // get all the valid neighbours to the current node
                ArrayList<INode> neighbourList = current.getNeighbourList(allowDiagonalMovement);

                // See if we can get the best neighbour to jump to
                for (int i = 0; i < neighbourList.size(); i++)
                {
                    INode neighbour = neighbourList.get(i);

                    // a boolean to check if teh neighbour is good for a jump
                    boolean isGoodNeighbour;

                    // We have seen this node before and it was rejected, please ignore
                    if (closedList.contains(neighbour))
                    {
                        continue;
                    }

                    // continue if the neighbour is not walkable
                    if (neighbour.isWalkable())
                    {
                        // how far is this neighbour from the current node - theoretical g-score
                        // current Nodes MovementCostFromStart + distance between the nodes + weight of the neighbour node
                        // The g-score is the shortest distance from startNode to currentNode.
                        float neighbourMovementCostFromStart = (current.getMovementCostFromStart() + map.getDistanceBetween(current, neighbour) + neighbour.getWeight());

                        // neighbour with the lower movement cost from start than cif we move from current to that node
                        if (openList.contains(neighbour))
                        {
                            isGoodNeighbour = neighbourMovementCostFromStart < current.getMovementCostFromStart();
                        }
                        // add neighbour to the open list if it is not there
                        else
                        {
                            openList.add(neighbour);

                            // most of the walkable neighbours, closer to teh startNode is good for a jump
                            isGoodNeighbour = true;
                        }

                        // set neighbors parameters if it a good neighbour
                        if (isGoodNeighbour)
                        {
                            neighbour.setParent(current);
                            neighbour.setMovementCostFromStart(neighbourMovementCostFromStart);
                            float heuristicCost = heuristic.getHeuristicCost(neighbour.getX(), neighbour.getY(), endNode);
                            neighbour.setHeuristicCost(heuristicCost);
                        }
                    }// NWalkable Neighbour
                } //END of Neighbour list
                // Sort the List on the basis of f-score
                openList.sort();
            }// END of Searching through the Nodes
        }// StartNode and EndNode not NULL
    }

    /**
     * @param node target node - can be end node or something close to it.
     * @return
     */
    private Path constructPath(INode node)
    {
        Path path = new Path();

        // target node - Can be end point or something close to it
        INode target = node;

        // the start node for this search
        INode source = map.getStartNode();

        // check if we have reached one end of the path
        while (target != source)
        {
            // add touch-points to the path
            path.prependTouchPoint(target.getX(), target.getY());

            // move one step up in the hierarchy
            target = target.getParent();
        }
        // Add teh start node at the end of the path drawing
        path.prependTouchPoint(map.getStartNode().getX(), map.getStartNode().getY());

        // return the calculated path
        return path;
    }

    /**
     * @return the shortest path calculated
     */
    public Path getShortestPath()
    {
        return shortestPath;
    }
}
