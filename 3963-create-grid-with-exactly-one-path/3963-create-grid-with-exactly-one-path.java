class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        for(int i=0;i<m;i++){
            ans[i]="#".repeat(n);
        }
        ans[0]=".".repeat(n);
        for(int i=0;i<m;i++){
            ans[i]=ans[i].substring(0,n-1) + ".";
        }
        return ans;
    }
}