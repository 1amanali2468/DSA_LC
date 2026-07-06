class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m = s.length;
        int n = g.length;
        int l=0, r=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(l<m && r<n){
            if(g[r]<=s[l]) r++;
            l++;
        }
        return r;
    }
}