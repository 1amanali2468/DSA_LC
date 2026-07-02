import java.util.*;
class Solution {
    public static int[] prefixMax(int[] height){
        int[] prefix = new int[height.length];
        prefix[0] = height[0];
        for(int i=1; i<prefix.length; i++){
            prefix[i] = Math.max(prefix[i-1], height[i]);
        }
        return prefix;
    }
    public static int[] suffixMax(int[] height){
        int n = height.length;
        int[] suffix = new int[n];
        suffix[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            suffix[i] = Math.max(suffix[i+1], height[i]);
        }
        return suffix;
    }
    public int trap(int[] height) {
        int n = height.length;
        int total =0;
        int[] prefixMax = prefixMax(height);
        int[] suffixMax = suffixMax(height);
        for(int i=0; i<n; i++){
            int leftmax = prefixMax[i];
            int rightmax  = suffixMax[i];
            if(height[i]<leftmax && height[i]<rightmax){
                total += Math.min(leftmax, rightmax) - height[i];
            }
        }
        return total;
    }
}