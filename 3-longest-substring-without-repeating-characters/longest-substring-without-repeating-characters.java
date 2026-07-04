class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0;
        int n = s.length();
        int[] last = new int[256];
        Arrays.fill(last, -1);
        int left=0;
        for(int right=0; right<n; right++){
            char ch= s.charAt(right);
            if(last[ch]>=left){
                left = last[ch] +1;
            }
            last[ch] =right;
            maxlen = Math.max(maxlen, right-left+1);
        }
    return maxlen;
    }
}