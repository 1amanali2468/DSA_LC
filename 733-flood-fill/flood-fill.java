class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int m = image.length;
        int n = image[0].length;

        int original = image[sr][sc];

        // Already has the target color
        if (original == color) {
            return image;
        }

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{sr, sc});
        image[sr][sc] = color;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!q.isEmpty()) {

            int[] cell = q.poll();

            for (int[] dir : directions) {

                int row = cell[0] + dir[0];
                int col = cell[1] + dir[1];

                if (row >= 0 && row < m &&
                    col >= 0 && col < n &&
                    image[row][col] == original) {

                    image[row][col] = color;
                    q.add(new int[]{row, col});
                }
            }
        }

        return image;
    }
}