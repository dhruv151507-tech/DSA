class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
        }
        long presum=0;
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            presum +=nums[i];
            if(presum>=sum-presum) count++;
        }
        return count;
    }
}