class Solution {
    public int findMiddleIndex(int[] nums) {
         int sum=0;
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
        }
        int prefSum=0;
        for(int i=0;i<nums.length;i++){
             if(sum-prefSum-nums[i]==prefSum) {
                 return i;
                }
            prefSum +=nums[i];
           
        }
        return -1;
    }
}