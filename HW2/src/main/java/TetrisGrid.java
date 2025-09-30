//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

import java.util.Scanner;

public class TetrisGrid {
    private boolean[][] grid;

    /**
     * Constructs a new instance with the given grid.
     */
    public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
    }


    /**
     * Does row-clearing on the grid (see handout).
     */
    public void clearRows() {
        int fellrow = -1;
        for (int i = grid.length - 1; i >= 0; i--) {
            boolean full = true;
            for (int j = 0; j < grid[i].length; j++) {
                if (!grid[i][j]) {
                    full = false;
                    break;
                }
            }

            if (full) {
                if (fellrow == -1) {
                    fellrow = i;
                }
            } else if (fellrow != -1) {
                for (int k = 0; k < grid[i].length; k++) {
                    grid[fellrow][k] = grid[i][k];
                    grid[i][k] = false;
                }
                fellrow--;
            }
        }

        while (fellrow >= 0) {
            for (int k = 0; k < grid[0].length; k++) {
                grid[fellrow][k] = false;
            }
            fellrow--;
        }
    }


    /**
     * Returns the internal 2d grid array.
     */
    boolean[][] getGrid() {
        return this.grid;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        boolean[][] grid = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextBoolean();
            }
        }
        TetrisGrid tg = new TetrisGrid(grid);
        tg.clearRows();
        boolean[][] res = tg.getGrid();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
