import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mention the Board Dimension: ");
        int n = sc.nextInt();
        TickTackToe tickTackToe = new TickTackToe(n);
        int counter = 0;
        char player = 'x';

        System.out.println("Choose Game Mode:");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs Computer");
        int mode = sc.nextInt();

        while(counter != n*n){
            int row, col;

            if (mode == 2 && player == 'o') {
                // Computer's turn
                int[] move = tickTackToe.getComputerMove(n);
                row = move[0];
                col = move[1];
                System.out.println("Computer chooses: " + row + " " + col);
            } else {
                System.out.print("Choose row and column you want to mark player " + player + ": ");
                row = sc.nextInt();
                col = sc.nextInt();
            }

            if(tickTackToe.isValidMove(row,col,n)){
                tickTackToe.makeMove(row,col,player);
                tickTackToe.printBoard();
                if(tickTackToe.hasMatchWon(player,row,col)){
                    System.out.println("player " + player +" has won the game");
                    break;
                }
                else{
                    counter++;
                    player = (player == 'x') ? 'o' : 'x';
                }
            }
            else System.out.println("Invalid Option");
        }

        if(counter == n*n) System.out.println("The Game is Draw");
    }
}
