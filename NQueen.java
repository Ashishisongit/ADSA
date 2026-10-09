import java.util.Scanner;

public class NQueen {

static int N;
static int[] board;

static boolean isSafe(int row, int col) {

    for (int i = 1; i <= row - 1; i++) {    
        if (board[i] == col) {
            return false;
        }
        if (Math.abs(board[i] - col) == Math.abs(i - row)) {
            return false;
        }
    }
    return true;
}


static void nQueen(int row) {

    
    if (row > N) {
        printBoard();
        return;
    }    
    for (int col = 1; col <= N; col++) {
        if (isSafe(row, col)) {
            board[row] = col;
            nQueen(row + 1);
            board[row] = 0;
        }
    }
}


static void printBoard() {

    for (int row = 1; row <= N; row++) {

        for (int col = 1; col <= N; col++) {

            if (board[row] == col) {
                System.out.print(" Q ");
            } else {
                System.out.print(" . ");
            }
        }

        System.out.println();
    }

    System.out.println();
}

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the value of N (for N*N Board): ");
    N = sc.nextInt();
    board = new int[N + 1];
    System.out.println("\nSolutions for " + N + "-Queen problem:\n");
    nQueen(1);
    sc.close();
}
}
