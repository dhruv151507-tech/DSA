class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer,Integer>mp=new HashMap<>();
      for(int i=0;i<nums.length;i++){
        int tofind=target-nums[i];
        if(mp.containsKey(tofind)) return new int[] {i,mp.get(tofind)};
        else mp.put(nums[i],i);
      }  
      return new int[] {};
    }
}