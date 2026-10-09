public class NQueen {

    static int N = 4;
    static int[] board = new int[N + 1];

    static boolean isSafe(int row, int col) {

        for (int i = 1; i < row; i++) {

            // Check same column
            if (board[i] == col) {
                return false;
            }

            // Check same diagonal
            if (Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }

        return true;
    }


    static void nQueen(int row) {

        // All queens have been placed
        if (row > N) {
            printBoard();
            return;
        }

        // Try every column
        for (int col = 1; col <= N; col++) {

            if (isSafe(row, col)) {

                // Place queen
                board[row] = col;

                // Solve the next row
                nQueen(row + 1);

                // Backtrack: remove queen
                board[row] = 0;
            }
        }
    }


    static void printBoard() {

        for (int i = 1; i <= N; i++) {

            for (int j = 1; j <= N; j++) {

                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }

            System.out.println();
        }

        System.out.println();
    }


    public static void main(String[] args) {
        nQueen(1);
    }
}