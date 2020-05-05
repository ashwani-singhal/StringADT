// PROGRAM TO PRINT THE DIAGONALS OF A 2 DIMENSIONAL MATRIX

import java.util.Scanner;

public class matrixDiagonal
{

    private static void printMatrixDiagonal(int[][] matrix)
    {
        int r,c;
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        for (int i = 0; i <rowCount ; i++)
        {
            for (r=i, c=0; r >=0 && c<colCount; r--,c++)
            {
                System.out.print(matrix[r][c]+" ");
            }
            System.out.println();
        }

        for (int i = 1; i <colCount ; i++)
        {
            for (r=rowCount-1, c=i; r >=0 && c<colCount; r--,c++)
            {
                System.out.print(matrix[r][c]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int row = scan.nextInt();
        System.out.println("Enter number of columns");
        int col = scan.nextInt();
        int matrix[][] = new int[row][col];
        System.out.println("Enter the elements");
        for (int i = 0; i <row ; i++)
        {
            for (int j = 0; j <col ; j++)
            {
                matrix[i][j] = scan.nextInt();
            }
        }

        printMatrixDiagonal(matrix);
    }
}
