class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        // Count frequency
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }
        // Max heap: highest frequency first
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> freq[b] - freq[a]
        );
        // Add characters that exist
        for (char ch = 0; ch < 128; ch++) {
            if (freq[ch] > 0) {
                pq.offer(ch);
            }
        }
        // Build answer
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            char ch = pq.poll();
            for (int i = 0; i < freq[ch]; i++) {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}