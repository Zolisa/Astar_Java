package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Navaneeth Sen
 * @since 2015/08/21
 */

public class FileReadTest
{

    public static final String FILE_NAME = "C:\\Users\\Navaneeth Sen\\git\\Astar_Assignment\\src\\maps\\map_50x50.txt";
    static int width = 0;
    static int height = 0;

    public static void main(String[] args)
    {
        int[] wh = getMapDimensions(FILE_NAME);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("FileReadTest.main" + " :: " + "width = [" + wh[0] + "]");
        System.out.println("FileReadTest.main" + " :: " + "height = [" + wh[1] + "]");
        System.out.println("-----------------------------------------------------------------------");

        width = wh[0];
        height = wh[1];

        try
        {
            char[][] map = getMap(FILE_NAME);
            printMap(map);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static int[] getMapDimensions(String file_name)
    {

        BufferedReader reader = null;
        int height = 1;
        int width = 1;

        int dimensions[] = new int[2];

        try
        {
            reader = getBufferedReader(file_name);
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
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        dimensions[0] = width;
        dimensions[1] = height;

        return dimensions;
    }

    public static char[][] getMap(String map_file) throws IOException
    {
        char[][] map = new char[width][height];

        BufferedReader br = getBufferedReader(map_file);

        for (int i = 0; i < height; i++)
        {
            String line = br.readLine();
            for (int j = 0; j < width; j++)
            {
                map[i][j] = line.charAt(j);
            }
        }
        br.close();

        return map;
    }

    private static BufferedReader getBufferedReader(String map_file) throws FileNotFoundException
    {
        return new BufferedReader(new FileReader(map_file));
    }

    public static void printMap(char[][] map)
    {
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                System.out.print(map[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }
}
