//WHEN WE ARE USING FIRST ROW FOR FILLING OF CHESS BOARD

import java.util.Scanner;

public class NQueen_Row {

    private void printBoard(int chessBoard[][] , int N){
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <N ; j++) {
                System.out.print(chessBoard[i][j]+" ");
            }
            System.out.println();
        }
    }

    private boolean isSafe(int chessBoard[][] , int row , int col){
        int i , j;
        int N = chessBoard.length;

        // to check left of box in same row
        for (i = 0;  i<row ; i++) {
            if(chessBoard[i][col] == 1){
                return false;
            }
        }

        // to check diagonally above on left side of box
        for (i = row , j = col; i >= 0 && j >= 0; i-- , j--) {
            if(chessBoard[i][j] == 1){
                return false;
            }
        }

        // to check left of box diagonally down
        for (i = row , j = col; i >= 0 && j < N ; i-- , j++) {
            if (chessBoard[i][j] == 1){
                return false;
            }
        }

        return true;
    }

    private boolean solveNQProblem(int chessBoard[][] , int row){

        int N = chessBoard.length;

        if(row >= N) {
            return true;
        }

        for (int i = 0; i < N ; i++) {

            if(isSafe(chessBoard,row,i)){
                chessBoard[row][i] = 1;

                if(solveNQProblem(chessBoard,row+1) == true){
                    return true;
                }

                chessBoard[row][i] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        NQueen_Row obj = new NQueen_Row();
        try{
            System.out.println("enter the dimension of chess board  minimum 4");
            int N = scan.nextInt();
            // Chess board of N*N with default value 0
            int chessBoard[][] = new int[N][N];
            obj.solveNQProblem(chessBoard,0);
            obj.printBoard(chessBoard,N);

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
