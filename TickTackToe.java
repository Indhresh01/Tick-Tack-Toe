import java.util.ArrayList;
import java.util.Random;

public class TickTackToe {
    char[][] board;


    public TickTackToe(int n){
        board = new char[n][n];
        initalizeBoard(n);
    }

    private void initalizeBoard(int n) {
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard(){
        int n = board.length;

        System.out.println("---------------");
        for(int i=0; i<n; i++){
            System.out.print(" | ");

            for(int j=0; j<n; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("---------------");
        }

    }

    public void makeMove(int row,int col,char player){
        board[row][col] = player;
    }

    public int[] getComputerMove(int n) {
        ArrayList<int[]> availableMoves = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == ' ') {
                    availableMoves.add(new int[]{i, j});
                }
            }
        }

        if (availableMoves.size() == 0) return new int[]{-1, -1}; // No moves

        Random rand = new Random();
        return availableMoves.get(rand.nextInt(availableMoves.size()));
    }

    public boolean isValidMove(int row,int col, int n){
        return  ((board[row][col] == ' ') && (row >= 0) && (row < n) && (col >= 0 )&& (col < n));
    }

    public boolean hasMatchWon(char player,int row,int col){
        int n = board.length;
        boolean isRowWon = true;
        for(int i=0; i<n; i++){
            if(board[row][i] != player){
                isRowWon = false;
                break;
            }
        }

        boolean isColWon = true;
        for(int i=0; i<n; i++){
            if(board[i][col] != player){
                isColWon = false;
                break;
            }
        }

        boolean isDiagonalWon = (row == col) && checkDiagonalWon(board,player,n);
        boolean isAntiDiagonalWon = (row + col == n-1) && checkAntiDiagonalWon(board,player,n);

        return isDiagonalWon || isColWon || isRowWon || isAntiDiagonalWon;
    }

    private boolean checkAntiDiagonalWon(char[][] board, char player, int n) {
        boolean isAntiDiagonalWon = true;

        for(int i=0; i<n; i++){
            if(board[i][n-1-i] != player){
                isAntiDiagonalWon = false;
                break;
            }
        }

        return isAntiDiagonalWon;

    }

    private boolean checkDiagonalWon(char[][] board, char player, int n) {
        boolean isDiagonalWon = true;
        for(int i=0; i<n; i++){
            if(board[i][i] != player){
                isDiagonalWon = false;
                break;
            }
        }

        return isDiagonalWon;
    }
}
