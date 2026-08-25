class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        // Reverse graph
        ArrayList<Integer>[] rev = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            rev[i] = new ArrayList<>();
        }

        // outdegree of every node
        int[] outdegree = new int[n];

        for (int i = 0; i < n; i++) {

            outdegree[i] = graph[i].length;

            for (int neighbor : graph[i]) {
                rev[neighbor].add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Terminal nodes have outdegree 0
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {

            int node = q.poll();

            ans.add(node);

            // Check nodes pointing to current node
            for (int prev : rev[node]) {

                outdegree[prev]--;

                if (outdegree[prev] == 0) {
                    q.add(prev);
                }
            }
        }

        // Required answer is sorted
        Collections.sort(ans);

        return ans;
    }
}