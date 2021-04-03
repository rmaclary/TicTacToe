
package tictactoe;

import java.util.Scanner;
public class TicTacToe {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        Board board = new Board(); //create new empty board
        board.displayBoard(); //show empty board
        System.out.println("Make your first move. Enter column: ");
        int col = Integer.parseInt(input.nextLine());
        System.out.println("Now enter row: ");
        int row = Integer.parseInt(input.nextLine());
        board.makePlay(row, col, "X"); //user plays using "X"
        boolean gameOver = false;
        
        while(!board.fullBoard() && !gameOver) //play continues while no winner and board isn't full
        {
            board.makePlayComputer("O"); //computer plays with "O"
            if (!board.findWinner().equals(board.findWinner().PLAYING)) //check for winner
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
            board.makePlay(row, col, "X"); //user plays with "X"
            if (!board.findWinner().equals(board.findWinner().PLAYING)) //check for winner
            {
                gameOver = true;
            }
            board.displayBoard();
  
        }
        
        if (board.findWinner().equals(board.findWinner().OWIN)) //computer wins
        {
            System.out.println("Computer wins!");
        }
        else
        {
            if (board.findWinner().equals(board.findWinner().XWIN)) //user wins
            {
                System.out.println("Congratulations, you win!");
            }
            else //no one wins
            {
                System.out.println("It's a tie!");
            }
        }
        
  
    }
    
}
