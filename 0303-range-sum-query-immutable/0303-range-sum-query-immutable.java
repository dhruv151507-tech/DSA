class NumArray {
    private int[] prefSum;
    public NumArray(int[] nums) {
        prefSum=new int[nums.length + 1];
        for(int i=0;i<nums.length;i++){
            prefSum[i+1]=nums[i]+prefSum[i];
        }

    }
    
    public int sumRange(int left, int right) {
      return prefSum[right+1]-prefSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */