class Solution {
    public int maxSubArray(int[] nums) {

        int sum=nums[0];
        int currsum=0;
        for(int i=0;i<nums.length;i++){
            currsum +=nums[i];
            sum=Math.max(sum,currsum);
            if (currsum < 0) {
                currsum = 0;
            }
        }
        return sum;
    }
}