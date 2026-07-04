class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxlen=0;
        for(int i=0; i<n; i++){
            int zeros = 0;
            for(int j=i; j<n; j++){
                if(nums[j]==0) zeros++;
                if(zeros<=k){
                    int len = j-i+1;
                    maxlen = Math.max(len, maxlen);
                }else{
                    break;
                }
            }
        }
        return maxlen;
    }
}