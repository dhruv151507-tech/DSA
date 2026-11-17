class NumMatrix {
 private int [][] ans;
    public NumMatrix(int[][] matrix) {
       ans=new int[matrix.length+1][matrix[0].length+1];
        int sum=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
               
                ans[i+1][j+1]=ans[i][j+1]+ans[i+1][j]+matrix[i][j]-ans[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res=0;
        return res = ans[row2+1][col2+1]-ans[row2+1][col1]-ans[row1][col2+1]+ans[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */