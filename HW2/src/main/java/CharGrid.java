// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

import org.w3c.dom.ls.LSInput;

import java.util.Scanner;

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     */
    public int charArea(char ch) {
        int maxcol = -1;
        int maxrow = -1;
        int mincol = 10000000;
        int minrow = 10000000;
        boolean check = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ch) {
                    if (i < minrow) minrow = i;
                    if (j < mincol) mincol = j;
                    if (i > maxrow) maxrow = i;
                    if (j > maxcol) maxcol = j;
                }
            }
        }
        if (maxcol == -1 && maxrow == -1) return 0;
        else return (maxrow - minrow + 1) * (maxcol - mincol + 1);
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     */
    public int countPlus() {
        int d = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char cur = grid[i][j];
                int left = j - 1;
                int right = j + 1;
                int upper = i - 1;
                int lower = i + 1;
                if(left < 0 || right >= grid[i].length || upper < 0 || lower >= grid.length) continue;
                if (cur == grid[i][left] && cur == grid[i][right] && cur == grid[upper][j] && cur == grid[lower][j]) {
                    d++;
                    continue;
                }
                System.out.println(d);
            }
        }
        return d;
    }

    public static void main(String[] args) {
        int m, n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        CharGrid cg = new CharGrid(grid);

        char ch = sc.next().charAt(0);
        System.out.println(cg.charArea(ch));
        System.out.println(cg.countPlus());
    }
}