package components;

/**
 * @author Navaneeth Sen
 * @since 2015/08/22
 */

/**
 * This class should be configured via a config or properties file
 */
public class AMapConstants
{
    // The Map Legend
    public static final char START_POINT_CHAR = '@';
    public static final char END_POINT_CHAR = 'X';
    public static final char FLATLAND_CHAR = '.';
    public static final char FOREST_CHAR = '*';
    public static final char MOUNTAIN_CHAR = '^';
    public static final char WATER_CHAR = '~';

    public static final String PATH_CHAR = "#";


    // Node Weights for the below map
    public static final float DEFAULT_WEIGHT = 1;
    public static final float INFINITE_WEIGHT = -1; // means a block
    public static final float FLATLAND_WEIGHT = 1;
    public static final float FOREST_WEIGHT = 2;
    public static final float MOUNTAIN_WEIGHT = 3;
}
