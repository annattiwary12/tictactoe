import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        // Initialize the board with empty spaces
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameover = false;
        Scanner scanner = new Scanner(System.in);
        int moves = 0; // Track the number of moves for draw condition

        while (!gameover && moves < 9) {
            printBoard(board);
            System.out.println("Player " + player + ", enter your move (row and column):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            System.out.println();

            // Validate input
            if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                System.out.println("Invalid move. Row and column must be between 0 and 2.");
                continue;
            }

            if (board[row][col] == ' ') {
                board[row][col] = player; // Place the element
                moves++;
                gameover = haveWon(board, player);

                if (gameover) {
                    printBoard(board);
                    System.out.println("Player " + player + " has won!");
                } else if (moves == 9) {
                    printBoard(board);
                    System.out.println("It's a draw!");
                } else {
                    // Switch player
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Cell is already occupied.");
            }
        }
    }

    public static boolean haveWon(char[][] board, char player) {
        // Check rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        // Check columns
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]);
                if (col < board[row].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < board.length - 1) {
                System.out.println("---------");
            }
        }
    }
}
