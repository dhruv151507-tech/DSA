class Solution {

     int MOD=1_000_000_007;
     int m;
     int n;
     int left=0;
     int up=1;
     long[][][] memo;
    public int uniquePaths(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        memo= new long[m][n][2];
        for (long[][] row2 : memo) {
            for (long[] row1 : row2) {
                Arrays.fill(row1, -1);
            }
        }
      return (int)solve(grid,0,0,left); 
}
       private long solve(int[][] grid,int row,int col,int camefrom){
        if(row>=m || col>=n) return 0;
        if(row==m-1 && col==n-1) return 1;

        if(memo[row][col][camefrom]!=-1) return memo[row][col][camefrom];

        if(grid[row][col]==1){
            if(camefrom==left){
                return memo[row][col][camefrom]=solve(grid,row+1,col,up);
            }
            else{
                    return memo[row][col][camefrom]=solve(grid,row,col+1,left);
            }
        }

        long totalpath=0;
        totalpath=(totalpath + solve(grid,row,col+1,left))%MOD;
        totalpath=(totalpath + solve(grid,row+1,col,up))%MOD;
    return memo[row][col][camefrom]=totalpath;

       
    }
}