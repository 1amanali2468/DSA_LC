class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        // Start or destination is blocked
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0, 1});
        grid[0][0] = 1; // mark visited

        int[][] dir = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];
            int dist = curr[2];

            // Reached destination
            if (row == n - 1 && col == n - 1) {
                return dist;
            }

            for (int[] d : dir) {

                int nr = row + d[0];
                int nc = col + d[1];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == 0) {

                    grid[nr][nc] = 1; // visited
                    q.add(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return -1;
    }
}