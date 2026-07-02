class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] nge = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            boolean found = false;
                nge[i] = -1;
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]<nums[j]){
                    nge[i] = nums[j];
                    found = true;
                    break;
                }
            }
            if(!found){

            for(int j=0; j<i; j++){
                if(nums[i]<nums[j]){
                    nge[i] = nums[j];
                    break;
                }
            }
            }
        }
        return nge;
    }
}