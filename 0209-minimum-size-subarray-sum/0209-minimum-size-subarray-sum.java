class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int currsum=0;
        int len=Integer.MAX_VALUE;
        int j=0;
        for(int i=0;i<nums.length;i++){
           currsum +=nums[i];
            while(currsum>=target){
                len=Math.min(len,i-j+1);
                currsum -=nums[j];
                 j++;
            }
        }
       
        return len==Integer.MAX_VALUE?0:len;
    }
}