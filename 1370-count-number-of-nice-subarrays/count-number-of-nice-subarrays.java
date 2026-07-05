class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return noOfSubarraysLessThanEqualTo(nums, k)- noOfSubarraysLessThanEqualTo(nums, k-1);
    }

    public static int noOfSubarraysLessThanEqualTo(int[] nums, int k){
        int n = nums.length;
        int l=0, r=0, count=0, sum=0;
        while(r<n){
            sum += (nums[r]%2);
            while(sum>k){
                sum = sum - (nums[l]%2);
                l++;
            }
            count += (r-l+1);
            r++;
        }
        return count;
    }
}