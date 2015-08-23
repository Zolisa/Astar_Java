package app;

import algorithm.A_Star;
import algorithm.heuristics.IHeuristic;
import algorithm.heuristics.ManhattanHeuristic;
import components.AMapConstants;
import components.GridMap;
import components.Path;
import components.TouchPoint;
import components.interfaces.IMap;
import components.interfaces.INode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Navaneeth Sen
 * @since 2015/08/22
 */

public class PathTracer
{
    public static final String FILE_NAME = "src/maps/map_50x50.txt";

    public static void main(String[] args)
    {

        System.out.println("\nGenerating Map from file " + FILE_NAME + "... ");
        IMap map = new GridMap(FILE_NAME);

        System.out.println("\nSetting Up the Heuristic Approach ...");

        IHeuristic heuristic = new ManhattanHeuristic();
//        IHeuristic heuristic = new EuclideanHeuristic();
//        IHeuristic heuristic = new DiagonalHeuristics();

        System.out.println("\nExecuting A* on the map ...");
        long start = System.currentTimeMillis();
        A_Star aStar = new A_Star(map, heuristic, true);
        long end = System.currentTimeMillis();

        System.out.println("\nCalculating the Shortest Path ...");
        Path shortestPath = aStar.getShortestPath();

        // A hashset to
        HashSet<String> set = new HashSet<String>();

        if (shortestPath != null)
        {
            long duration = end - start;
            System.out.println("\nFound the Shortest Path in " + duration + " ms");
            int length = shortestPath.getLength();
            System.out.println("\nPrinting the TouchPoints ...");
            for (int i = 0; i < length; i++)
            {
                TouchPoint touchPoint = shortestPath.getTouchPoint(i);
                String e = touchPoint.getX() + "," + touchPoint.getY();
                set.add(e);
                System.out.println("{" + (map.getNodeAtPosition(touchPoint.getX(), touchPoint.getY())).getNodeName() + "}" + (map.getNodeAtPosition(touchPoint.getX(), touchPoint.getY()).getMovementCostFromStart()));
            }

            System.out.println("\nEmbedding the Calculated Path in the Map ...");
            printMap(map.getMap(), map.getMapHeight(), map.getMapWidth(), set);
        }
        else
        {
            System.out.println("\nSorry!! No Path to Plot !!!");
        }
    }

    /**
     * Will repaint the graph with the calculated path
     *
     * @param map_nodes
     * @param mapHeight
     * @param mapWidth
     * @param set       to paint the touchpoints with a different character
     */
    public static void printMap(ArrayList<ArrayList<INode>> map_nodes, int mapHeight, int mapWidth, HashSet<String> set)
    {
        for (int i = 0; i < mapHeight; i++)
        {
            for (int j = 0; j < mapWidth; j++)
            {
                String e = i + "," + j;
                if (set.contains(e))
                {
                    System.out.print(AMapConstants.PATH_CHAR);
                }
                else
                {
                    System.out.print((map_nodes.get(i).get(j)).getNodeValue());
                }
            }
            System.out.print("\n");
        }
    }
}
