class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxlen=0;
        int left=0, right=0;
        int zeros = 0;
        while(right<n){
            if(nums[right]==0) zeros++;
            if(zeros>k){
                if(nums[left]==0) zeros--;
                left++;
            }
            if(zeros<=k) maxlen=Math.max(right-left+1, maxlen);
            right++;
        }
        return maxlen;
    }
}