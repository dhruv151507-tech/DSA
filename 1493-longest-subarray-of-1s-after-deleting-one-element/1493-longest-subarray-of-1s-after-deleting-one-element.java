class Solution {
    public int longestSubarray(int[] nums) {
        int j=0;
        int len=0;
        int delete=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)delete++;
            while(delete>1){
                if(nums[j]==0) delete--;
                j++;
            }
            len=Math.max(len,i-j);
        }
        return len;
    }
}