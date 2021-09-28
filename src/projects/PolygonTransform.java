package projects;

import projects.inputOutput.StdDraw;

/*************************************************************************
 *  mutates a polygon based on user input
 *  Compilation:  javac PolygonTransform.java
 *  Execution:    java PolygonTransform
 *
 *  @author: jack dunich
 *
 *************************************************************************/

public class PolygonTransform {

    /**
     * takes in an array and makes a copy
     *
     * @param array to copy
     * @return copy of array
     */
    public static double[] copy(double[] array) {
        double[] copy = new double[array.length];

        for(int i = 0; i < array.length; i++)
            copy[i] = array[i];
        return copy;
    }

    /**
     * Scales the given polygon by the factor alpha.
     *
     * @param x coordinate
     * @param y coordinate
     * @param alpha angle
     */
    public static void scale(double[] x, double[] y, double alpha) {
        for (int i = 0; i < x.length; i++){
            x[i] = x[i]*alpha;
        }
        for (int i = 0; i < y.length; i++){
            y[i] = y[i]*alpha;
        }
    }

    /**
     * Translates the given polygon by (dx, dy).
     *
     * @param x coordinate
     * @param y coordinate
     * @param dx new coordinate
     * @param dy new coordinate
     */
    public static void translate(double[] x, double[] y, double dx, double dy) {
        for (int i = 0; i < x.length; i++){
            x[i] = x[i]+dx;
        }
        for (int i = 0; i < y.length; i++){
            y[i] = y[i]+dy;
        }
    }

    /**
     * Rotates the given polygon theta degrees counterclockwise, about the origin.
     *
     * @param x coordinate
     * @param y coordinate
     * @param theta angle
     */
    public static void rotate(double[] x, double[] y, double theta) {
        double[] copyx = copy(x);
        theta = (theta*Math.PI)/180;

        for (int i = 0; i < x.length; i++){
            x[i] = x[i]*Math.cos(theta) - y[i]*Math.sin(theta);
        }
        for (int i = 0; i < y.length; i++){
            y[i] = y[i]*Math.cos(theta) + copyx[i]*Math.sin(theta);
        }
    }

    /**
     * Tests each of the API methods by directly calling them.
     *
     * @param args
     */
    public static void main(String[] args) {
        StdDraw.setScale(-5.0, +5.0);
        double[] x = { 0, 1, 1, 0 };
        double[] y = { 0, 0, 2, 1 };
        double theta = 45.0;
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.polygon(x, y);
        rotate(x, y, theta);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.polygon(x, y);
    }
}

