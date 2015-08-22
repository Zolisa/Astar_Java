package components;

/**
 * @author Navaneeth Sen
 * @since 2015/08/21
 */

/**
 * Just a wrapper class to hold the touch point co-ordinates which forms a path
 */
public class TouchPoint
{

    protected int x;
    protected int y;

    public TouchPoint(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public int hashCode()
    {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public boolean equals(Object other)
    {
        if (other instanceof TouchPoint)
        {
            TouchPoint o = (TouchPoint) other;
            return (o.x == x) && (o.y == y);
        }

        return false;
    }

}
