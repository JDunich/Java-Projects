package projects;

import projects.inputOutput.StdDraw;

/*************************************************************************
 *  Data type for turtle graphics using standard draw.
 *
 *  @author:  jack dunich
 *
 *************************************************************************/

public class Turtle
{
    /**
     * turtle at x
     * turtle at y
     */
    private double x, y;
    /**
     * turtle angle
     */
    private double angle;

    /**
     * constructor for turtle
     *
     * @param x0 starting position x
     * @param y0 starting position y
     * @param a0 angle a
     */
    public Turtle(double x0, double y0, double a0)
    {
        x = x0;
        y = y0;
        angle = a0;
    }

    /**
     * turn left
     *
     * @param delta angle
     */
    public void turnLeft(double delta)
    {
        angle += delta;
    }

    /**
     * move forward
     *
     * @param d steps
     */
    public void goForward(double d)
    {
        double oldx = x;
        double oldy = y;
        x += d * Math.cos(Math.toRadians(angle));
        y += d * Math.sin(Math.toRadians(angle));
        StdDraw.line(oldx, oldy, x, y);
    }

    /**
     * reads command line inputs
     * displays turtle
     *
     * @param args
     */
    public static void main(String[] args)
    {
        StdDraw.setScale(-5.0, +5.0);
        Turtle turtle = new Turtle(0.0, 0.0, 0.0);
        int n = Integer.parseInt(args[0]);
        double decay = Double.parseDouble(args[1]);
        double angle = 360.0/n;
        double step = Math.sin(Math.toRadians(angle/2.0));
        for(int i = 0; i < n * 10; i++)
        {
            step /= decay;
            turtle.goForward(step);
            turtle.turnLeft(angle);
        }
    }
}