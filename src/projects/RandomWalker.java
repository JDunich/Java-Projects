package projects;

/*************************************************************************
 *  Compilation:  javac RandomWalker.java
 *  Execution:    java RandomWalker 10
 *
 *  @author: jack dunich
 *
 * The program RandomWalker that takes an int command-line argument n
 * and simulates the motion of a random walk for n steps. Print the
 * location at each step (including the starting point), treating the
 * starting point as the origin (0, 0). Also, print the square of the
 * final Euclidean distance from the origin.
 *
 *  % java RandomWalker 10
 * (0,0)
 * (-1,0)
 * (-1,-1)
 * (-1,-2)
 * (-1,-3)
 * (-1,-4)
 * (-1,-5)
 * (0,-5)
 * (-1,-5)
 * (-2,-5)
 * (-2,-4)
 * Squared distance = 20.0
 *
 *************************************************************************/

public class RandomWalker {

    /**
     * takes in a command line argument and moves based on input
     *
     * @param args user input
     */
    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]);

        if(a < 0){
            System.out.print("Enter Valid Imput");
        }else{

            int[][] arr = new int[a][2];
            int x;
            int y;
            int cx = 0;
            int cy = 0;

            arr[0][0] = 0;
            arr[0][1] = 0;
            System.out.print("(" + arr[0][0] + "," + arr[0][1] + ")");
            System.out.println( );

            for(int i = 1; i < a; i++){
                if (Math.random() < 0.5){
                    if (Math.random() < 0.5){
                        x = 1;
                    }else{
                        x = -1;
                    }
                    y = 0;
                }else{
                    if (Math.random() < 0.5){
                        y = 1;
                        x = 0;
                    }else{
                        y = -1;
                        x = 0;
                    }
                }

                cx = cx + x;
                cy = cy + y;
                arr[i][0] = cx;
                arr[i][1] = cy;

                System.out.print("(" + arr[i][0] + "," + arr[i][1] + ")");
                System.out.println( );
            }


            double x2 = arr[a-1][0];
            double y2 = arr[a-1][1];

            double xs = Math.pow(x2,2);
            double ys = Math.pow(y2,2);

            double dist = xs + ys;

            System.out.print("Squared Distance = " + dist);
        }
    }
}
