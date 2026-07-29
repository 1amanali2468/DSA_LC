class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length, sum;
        int[] left = new int[n];
        int curr=1, right=1;
        left[0] = 1;
        for(int i=1; i<n; i++){
            if(ratings[i]>ratings[i-1]){
                left[i] = left[i-1] +1;
            }
            else{
                left[i] = 1;
            }
        }
        sum = Math.max(1, left[n-1]);
        for(int i=n-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                curr = right+1;
                right = curr;
            }
            else{
                curr =1;
                right=1;
            }
            sum = sum + Math.max(left[i], curr);
        }
        return sum;
    }
}