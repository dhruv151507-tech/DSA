class NumArray {
    private int[] prefSum;
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums=nums;
        prefSum=new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
            prefSum[i]=sum;
        }

    }
    
    public int sumRange(int left, int right) {
      return prefSum[right]-prefSum[left]+nums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */