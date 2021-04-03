/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Random;
public class Board 
{
    private int[][] board = new int[3][3];
    
    public void displayBoard()
    {
        System.out.println(" |0|1|2|");
        System.out.println(printBoardRow(0));
        System.out.println(printBoardRow(1));
        System.out.println(printBoardRow(2));       
    }
    
    public int[][] getBoard()
    {
        return board;
    }
    
    public boolean makePlay(int row, int col, String piece)
    {
        if(board[row][col] == 0) 
        {
            if (piece.equals("X")) board[row][col] = 1;
            if (piece.equals("O")) board[row][col] = 2;
            return true;
        }
        
        return false;
    }
    
    public boolean makePlayComputer(String piece)
    {
        int row = new Random().nextInt(3);
        int col = new Random().nextInt(3);
        boolean playMade = false;
        while (!playMade && !fullBoard()) 
        {
            if(board[row][col] == 0)
            {
                playMade = true;
                if (piece.equals("X")) board[row][col] = 1;
                if (piece.equals("O")) board[row][col] = 2;
            }
            else 
            {
                row = new Random().nextInt(3);
                col = new Random().nextInt(3);
            }
        }
        return playMade;
    }
    
    public boolean fullBoard()
    {
        for(int row=0; row<board.length; row++)
        {
            for(int col=0; col<board[0].length; col++)
            {
                if(board[row][col] == 0) return false;
            }
        }
        return true;
    }
    
    private String printBoardRow(int row)
    {
        String output = row + "|";
        for (int i=0; i<board[0].length; i++)
        {
            if(board[row][i] == 0) output += " ";
            if(board[row][i] == 1) output += "X";
            if(board[row][i] == 2) output += "O";
            output += "|";
        }
        
        return output;
    }
    
    public enum Status 
    {
        PLAYING, XWIN, OWIN;
    }
    public Status findWinner()
    {
        for (int i = 0; i < 8; i++)
        {
            String win = null;
            
            switch(i)
            {
                case 0 -> win = board[0][0] + " " + board[0][1] + " " + board[0][2];//across(top)
                case 1 -> win = board[1][0] + " " + board[1][1] + " " + board[1][2];//across(middle)
                case 2 -> win = board[2][0] + " " + board[2][1] + " " + board[2][2];//across(bottom)
                case 3 -> win = board[0][0] + " " + board[1][0] + " " + board[2][0];//down(left)
                case 4 -> win = board[0][1] + " " + board[1][1] + " " + board[2][1];//down(middle)
                case 5 -> win = board[0][2] + " " + board[1][2] + " " + board[2][2];//down(right)
                case 6 -> win = board[0][0] + " " + board[1][1] + " " + board[2][2];//diagonal
                case 7 -> win = board[0][2] + " " + board[1][1] + " " + board[2][0];//diagonal     
            }
            if ("1 1 1".equals(win))
            {
                return Status.XWIN;
            }
            if ("2 2 2".equals(win))
            {
                return Status.OWIN;
            }
        }
        return Status.PLAYING;
    }

}
