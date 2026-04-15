import java.util.ArrayList;
import java.util.Random;

public class SudokoGenerator {
    public static void main(String[] args) {
        int[][] board = createSodokuBoard();
        printBoard(board);
    }

    public static int[][] createSodokuBoard() {
        int[][] board = new int[9][9];

        ArrayList<Integer> shuffled = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            shuffled.add(i);
        }

        Random rand = new Random();
        for (int i = 0; i < shuffled.size(); i++) {
            int randomIndex = rand.nextInt(shuffled.size());

            int temp = shuffled.get(i);
            shuffled.set(i, shuffled.get(randomIndex));
            shuffled.set(randomIndex, temp);
        }

        for (int col = 0; col < 9; col++) {
            board[0][col] = shuffled.get(col);
        }
        
        for (int row = 1; row < 9; row++) {
            int[] newRow = new int[9];
            for (int i = 0; i < 9; i++) {
                newRow[i] = board[row - 1][i];
            }

            newRow = shiftUntilValid(board, newRow, row);

            for (int col = 0; col < 9; col++) {
                board[row][col] = newRow[col];
            }
        }

        return board;
    }

    public static int[] shiftUntilValid(int[][] board, int[] rowData, int row) {

        while (isValid(board, rowData, row) == false) {
            rowData = shiftRightByOne(rowData);
        }

        return rowData;
    }
    public static int[] shiftRightByOne(int[] row) {

        int[] newRow = new int[9];

        newRow[0] = row[8];

        for (int i = 0; i < 8; i++) {
            newRow[i + 1] = row[i];
        }

        return newRow;
    }

    public static boolean isValid(int[][] board, int[] rowData, int row) {

        for (int col = 0; col < 9; col++) {
            for (int r = 0; r < row; r++) {
                if (board[r][col] == rowData[col]) {
                    return false;
                }
            }
        }

        int startRow;
        if (row < 3) {
            startRow = 0;
        } else if (row < 6) {
            startRow = 3;
        } else {
            startRow = 6;
        }

        for (int col = 0; col < 9; col++) {

            int startCol;
            if (col < 3) {
                startCol = 0;
            } else if (col < 6) {
                startCol = 3;
            } else {
                startCol = 6;
            }

            for (int r = startRow; r < row; r++) {
                for (int c = startCol; c < startCol + 3; c++) {
                    if (board[r][c] == rowData[col]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void printBoard(int[][] board) {
        System.out.println("Solved Sodoku Board:");

        for (int row = 0; row < 9; row++) {

            if (row == 3 || row == 6) {
                System.out.println("----------------");
            }

            for (int col = 0; col < 9; col++) {

                if (col == 3 || col == 6) {
                    System.out.print(" | ");
                }

                System.out.print(board[row][col]);
            }

            System.out.println();
        }
    }
}