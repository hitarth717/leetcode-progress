class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] totaldist = new int[cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                totaldist[col] = reachcell(grid, totaldist, row, col);
            }
        }

        return totaldist[cols - 1];
    }

    private int reachcell(int[][] grid, int[] totaldist, int row, int col) {
        int currentcost = grid[row][col];

        if (row == 0 && col == 0) {
            return currentcost;
        }
        if (row == 0) {
            return totaldist[col - 1] + currentcost;
        }
        if (col == 0) {
            return totaldist[col] + currentcost;
        }

        int top = totaldist[col];
        int side = totaldist[col - 1];
        int mincost = Math.min(top, side);

        return mincost + currentcost;
    }
}