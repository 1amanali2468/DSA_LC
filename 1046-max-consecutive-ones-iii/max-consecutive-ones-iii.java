class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxlen=0;
        int left=0, right=0;
        int zeros = 0;
        while(right<n){
            if(nums[right]==0) zeros++;
            while(zeros>k){
                if(nums[left]==0) zeros--;
                left++;
            }
            if(zeros<=k){
                maxlen = Math.max(maxlen, right-left+1);
            }
            right++;
        }
        return maxlen;
    }
}