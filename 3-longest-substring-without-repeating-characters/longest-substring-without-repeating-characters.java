class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            int[] freq = new int[256];
            for(int j=i; j<n; j++){
                char ch = s.charAt(j);
                if(freq[ch]==1) break;
                freq[ch]=1;
                int len = j-i+1;
                maxlen = Math.max(len, maxlen);
            }
        }
        return maxlen;
    }
}