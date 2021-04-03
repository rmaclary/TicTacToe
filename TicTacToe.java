
package tictactoe;

import java.util.Scanner;
public class TicTacToe {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        Board board = new Board();
        board.displayBoard();
        System.out.println("Make your first move. Enter column: ");
        int col = Integer.parseInt(input.nextLine());
        System.out.println("Now enter row: ");
        int row = Integer.parseInt(input.nextLine());
        board.makePlay(row, col, "X");
        boolean gameOver = false;
        
        while(!board.fullBoard() && !gameOver)
        {
            board.makePlayComputer("O");
            if (!board.findWinner().equals(board.findWinner().PLAYING))
            {
                gameOver = true;
                board.displayBoard();
                break;
            }
            board.displayBoard();
            System.out.println("Enter your next move. Enter column: ");
            col = Integer.parseInt(input.nextLine());
            System.out.println("Now enter row: ");
            row = Integer.parseInt(input.nextLine());
            board.makePlay(row, col, "X");
            if (!board.findWinner().equals(board.findWinner().PLAYING))
            {
                gameOver = true;
            }
            board.displayBoard();
  
        }
        
        if (board.findWinner().equals(board.findWinner().OWIN))
        {
            System.out.println("Computer wins!");
        }
        else
        {
            if (board.findWinner().equals(board.findWinner().XWIN))
            {
                System.out.println("Congratulations, you win!");
            }
            else 
            {
                System.out.println("It's a tie!");
            }
        }
        
  
    }
    
}
