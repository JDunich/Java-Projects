package projects;

import projects.inputOutput.Picture;
import projects.inputOutput.StdIn;
import projects.inputOutput.StdOut;

import java.awt.Color;

/*************************************************************************
 * The Charge.java class uses the Std Library in order to map out the electric
 * potentials in different areas around a charged particle.
 *
 * @author:  jack dunich
 *
 *************************************************************************/

public class Charge
{

    /**
     * @global variable rx
     * @global variable ry
     */
    private final double rx, ry;
    /**
     * @global q
     */
    private final double q;

    /**
     * charge constructor
     *
     * @param x0 x coordinate
     * @param y0 y coordinate
     * @param q0 charge
     */
    public Charge(double x0, double y0, double q0)
    {
        rx = x0;
        ry = y0;
        q = q0;
    }

    /**
     * find the potential of at the charge at given x and y value and returns the double potential
     *
     * @param x coordinate
     * @param y coordinate
     * @return double of the potential in the 2d space at the coordinates given
     */
    public double potentialAt(double x, double y)
    {
        double k = 8.99e09;
        double dx = x - rx;
        double dy = y - ry;
        return k * q / Math.sqrt(dx*dx + dy*dy);
    }

    /**
     * Makes a string of the charge at a coordinate point
     *
     * @return string of potential at point
     */
    @Override
    public String toString()
    {
        return q + " at " + "(" + rx + "," + ry + ")";
    }

    /**
     * Reads from command line one number at a time
     * Returns a list of charges
     *
     * @return list of charges
     */
    public static Charge[] readCharges()
    {
        int N = StdIn.readInt();
        Charge[] a = new Charge[N];
        for(int i = 0; i < N; i++)
        {
            double x0 = StdIn.readDouble();
            double y0 = StdIn.readDouble();
            double q0 = StdIn.readDouble();
            a[i] = new Charge (x0, y0, q0);
        }
        return a;
    }

    /**
     * color using greyscale to map potential in 2d plane
     *
     * @param V potential at
     * @return color in greyscale
     */
    public static Color toColor(double V)
    {
        V = 128 + V / 2.0e10;
        int t = 0;
        if (V > 255) t = 255;
        else if (V >= 0) t = (int) V;
        return new Color(t, t, t);
    }

    /**
     * main method for executing code
     * displays image of 2d potential map
     *
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        Charge[] a = readCharges();
        int SIZE = 800;
        Picture pic = new Picture(SIZE,SIZE);
        for(int col = 0; col < SIZE; col ++)
            for(int row = 0; row < SIZE; row++)
            {
                double V = 0.0;
                for(int k = 0; k < a.length; k++)
                {
                    double x = 1.0 * col / SIZE;
                    double y = 1.0 * row / SIZE;
                    V += a[k].potentialAt(x, y);
                }
                pic.set(col, SIZE-1-row, toColor(V));
            }
        pic.show();
    }
}
