package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Board board = new Board();
        String winner = null;

        for (int a = 0; a < 9; a++) {
            board.board[a] = String.valueOf(a + 1);
        }

        System.out.println("Tic Tac Toe Game!");
        board.printBoard();

        System.out.println(
                "X starts! Enter a position number to place X:");

        while (winner == null) {
            int input;

            try {
                input = in.nextInt();
                if (!(input > 0 && input <= 9)) {
                    System.out.println("kör igen");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(
                        "kör igen:\"");
                continue;
            }


            if (board.board[input - 1].equals(
                    String.valueOf(input))) {
                board.board[input - 1] = board.turn;

                if (board.turn.equals("X")) {
                    board.turn = "O";
                }
                else {
                    board.turn = "X";
                }

                board.printBoard();
                winner = board.Winner();
            }
            else {
                System.out.println(
                        "Position already taken! enter a new number:");
            }
        }


        if (winner.equalsIgnoreCase("draw")) {
            System.out.println(
                    "It's a draw!");
        }


        else {
            System.out.println(
                    "Congrats! " + winner
                            );
        }
    }
}