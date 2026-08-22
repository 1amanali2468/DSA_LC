class Solution {
    public int numEnclaves(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        // Add boundary land cells
        for (int i = 0; i < m; i++) {

            if (grid[i][0] == 1) {
                grid[i][0] = 0;
                q.add(new int[]{i, 0});
            }

            if (grid[i][n - 1] == 1) {
                grid[i][n - 1] = 0;
                q.add(new int[]{i, n - 1});
            }
        }

        for (int j = 0; j < n; j++) {

            if (grid[0][j] == 1) {
                grid[0][j] = 0;
                q.add(new int[]{0, j});
            }

            if (grid[m - 1][j] == 1) {
                grid[m - 1][j] = 0;
                q.add(new int[]{m - 1, j});
            }
        }

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // BFS from boundary land
        while (!q.isEmpty()) {

            int[] cell = q.poll();

            int row = cell[0];
            int col = cell[1];

            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m &&
                    newCol >= 0 && newCol < n &&
                    grid[newRow][newCol] == 1) {

                    grid[newRow][newCol] = 0;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }

        // Count remaining land cells
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}