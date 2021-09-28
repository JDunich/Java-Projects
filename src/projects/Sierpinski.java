package projects;

import projects.inputOutput.StdDraw;

/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author:  jack dunich
 *
 *************************************************************************/

public class Sierpinski {

    /**
     * Height of an equilateral triangle whose sides are of the specified length.
     *
     * @param length length of the given edge
     */
    public static double height(double length) {

        return (Math.sqrt(3)* length/2);

    }

    /**
     * Draws a filled equilateral triangle whose bottom vertex is (x, y)
     * of the specified side length.
     *
     * @param x first vertex
     * @param y second vertex
     * @param length length of side
     */
    public static void filledTriangle(double x, double y, double length) {

        double[] arrx = new double[3];
        double[] arry = new double[3];

        for(int i = 0; i < 3; i++){
            if(i == 0){
                arrx[i] = x;
                arry[i] = y;
            }
            if(i == 1){
                arrx[i] = x + (length/2.0);
                arry[i] = y + (height(length));
            }
            if(i == 2){
                arrx[i] = x - (length/2.0);
                arry[i] = y + (height(length));
            }

        }

        StdDraw.filledPolygon(arrx, arry);

    }

    /**
     * Draws a Sierpinski triangle of order n, such that the largest filled
     * triangle has bottom vertex (x, y) and sides of the specified length.
     *
     * @param n order of triangles
     * @param x first vertex
     * @param y second vertex
     * @param length length of side
     */
    public static void sierpinski(int n, double x, double y, double length) {
        double xi = x;
        double yi= y;


        if (n > 0){
            filledTriangle(x, y, length);


            sierpinski(n-1,x, y + height(length), length/2);



            sierpinski(n-1,x - length/2.0, y, length/2);



            sierpinski(n-1,x + length/2.0, y, length/2);
        }


    }

    /**
     * Takes an integer command-line argument n;
     * draws the outline of an equilateral triangle (pointed upwards) of length 1;
     * whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and
     * draws a Sierpinski triangle of order n that fits snugly inside the outline.
     *
     * @param args command line argument
     */
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        double length = 1;
        double h = height(length);
        StdDraw.polygon(new double[] { 0, length / 2, length }, new double[] { 0, h, 0 });

        sierpinski(n, length/2, 0, length/2);



    }
}
