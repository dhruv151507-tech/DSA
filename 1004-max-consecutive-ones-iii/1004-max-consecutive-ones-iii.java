class Solution {
    public int longestOnes(int[] nums, int k) {
      int len1=0;
        int flip=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)flip++;
                while(flip>k){
                   if (nums[j] == 0) {
                    flip--;
                   }
                    j++;
                }
                len1=Math.max(len1,i-j+1);
        }  
        return len1;
    }
}