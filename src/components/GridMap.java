package components;

import components.interfaces.INode;
import components.terrains.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author Navaneeth Sen
 * @since 2015/08/21
 */

public class GridMap extends AMap
{
    /**
     * Constructor to create a tile Map representation
     *
     * @param map_file
     */
    public GridMap(String map_file)
    {
        try
        {
            // Read the map and populate the dimensions
            populateMapDimensions(map_file);

            // Construct a char[][] of the the text map
            char[][] map = construct2DCharMapFromText(map_file);

            // print the original map representation
            printMap(map);

            // Construct the logical representation of the char [][] into an an ArrayList of ArrayList of Nodes
            constructNodeMap(map);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Constructs a Node representation map from the 2D char array
     *
     * @param char_map
     */
    private void constructNodeMap(char[][] char_map)
    {
        Node node;

        // Initialize the Node map
        map = new ArrayList<ArrayList<INode>>();

        for (int x = 0; x < mapHeight; x++)
        {
            // Construct a row
            map.add(new ArrayList<INode>());
            for (int y = 0; y < mapWidth; y++)
            {
                switch (char_map[x][y])
                {
                    case START_POINT_CHAR:
                        node = new StartNode(x, y, this, DEFAULT_WEIGHT);
                        startNode = node;
                        break;
                    case END_POINT_CHAR:
                        node = new EndNode(x, y, this, DEFAULT_WEIGHT);
                        endNode = node;
                        break;
                    case FLATLAND_CHAR:
                        node = new FlatlandNode(x, y, this, FLATLAND_WEIGHT);
                        break;
                    case FOREST_CHAR:
                        node = new ForestNode(x, y, this, FOREST_WEIGHT);
                        break;
                    case MOUNTAIN_CHAR:
                        node = new MountainNode(x, y, this, MOUNTAIN_WEIGHT);
                        break;
                    case WATER_CHAR:
                        node = new WaterNode(x, y, this, INFINITE_WEIGHT);
                        break;
                    default:
                        System.out.println("Don't know what this symbol is - " + char_map[x][y]);
                        node = null;
                        break;
                }
                // Add it to the Row
                map.get(x).add(node);
            }
        }
    }

    /**
     * Finds the dimensions of the text map
     * Read the number of lines as - height
     * Read the number of chars in line as - width
     *
     * @param file_name map file
     */
    private void populateMapDimensions(String file_name) throws Exception
    {
        int height = 1;
        int width = 1;

        BufferedReader reader = getBufferedReader(file_name);
        boolean widthCalculated = false;
        while (reader.readLine() != null)
        {
            if (!widthCalculated)
            {
                char[] charsInOneLine = reader.readLine().toCharArray();
                width = charsInOneLine.length;
                widthCalculated = true;
            }
            height++;
        }

        reader.close();

        // Initialize the mapWidth and mapHeight
        mapWidth = width;
        mapHeight = height;
    }

    /**
     * @param map_file
     * @return char[][] - 2d array of teh text file characters
     * @throws Exception
     */
    private char[][] construct2DCharMapFromText(String map_file) throws Exception
    {
        char[][] map = new char[mapWidth][mapHeight];

        BufferedReader br = getBufferedReader(map_file);

        for (int i = 0; i < mapHeight; i++)
        {
            String line = br.readLine();
            for (int j = 0; j < mapWidth; j++)
            {
                map[i][j] = line.charAt(j);
            }
        }
        br.close();

        return map;
    }

    /**
     * @param map_file
     * @return a reader to the given file
     * @throws FileNotFoundException
     */
    private BufferedReader getBufferedReader(String map_file) throws FileNotFoundException
    {
        return new BufferedReader(new FileReader(map_file));
    }

    /**
     * Prints the 2D char map for debug purposes
     *
     * @param map
     */
    private void printMap(char[][] map)
    {
        System.out.println("mapWidth [" + mapWidth + "] mapHeight [" + mapHeight + "]");
        for (int i = 0; i < mapHeight; i++)
        {
            for (int j = 0; j < mapWidth; j++)
            {
                System.out.print(map[i][j]);
            }
            System.out.print("\n");
        }
    }
}
