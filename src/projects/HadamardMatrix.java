package projects;

/*************************************************************************
 *  Compilation:  javac HadamardMatrix.java
 *  Execution:    java HadamardMatrix 2
 *
 *  @author: jack dunich
 *
 * The program HadamardMatrix prints H(n)
 *
 *  % java HadamardMatrix 2
 *  T T
 *  T F
 *
 *************************************************************************/

public class HadamardMatrix {

    /**
     * reads n and returns n x n Hadamard Matrix
     *
     * @param args n argument
     */
    public static void main(String [] args) {

        int n = Integer.parseInt(args[0]);
        boolean[][] hadMatrix = new boolean[n][n];

        hadMatrix[0][0] = true;
        for(int k = 1; k < n; k += k){
            for (int i = 0; i < k; i++){
                for(int j = 0; j < k; j++){
                    hadMatrix[i][j+k] = hadMatrix[i][j];
                    hadMatrix[i+k][j] = hadMatrix[i][j];
                    hadMatrix[i+k][j+k] = !hadMatrix[i][j];
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (hadMatrix[i][j])
                    System.out.print("T ");
                else
                    System.out.print("F ");

            }
            System.out.println( );
        }

    }
}