class Solution {
    public int search(int[] a, int x) {
        int low = 0, high = a.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(a[mid] == x) return mid;

            // LEFT HALF SORTED
            if(a[low] <= a[mid]){
                if(a[low] <= x && x < a[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // RIGHT HALF SORTED
            else{
                if(a[mid] < x && x <= a[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
