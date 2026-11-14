class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
       int ans=Integer.MAX_VALUE;
       for(int right=l;right<=r;right++){
        int sum =0;
        for(int left=0;left<right;left++){
            sum +=nums.get(left);
        }
        if(sum>0){
            ans=Math.min(ans,sum);
        }
        // slide  for all possible length from l to r
        for(int k=right;k<nums.size();k++){
            sum +=nums.get(k) - nums.get(k-right);
             if(sum>0){
            ans=Math.min(ans,sum);
        }
        }
       } 
       return ans==Integer.MAX_VALUE?-1:ans;
    }
}