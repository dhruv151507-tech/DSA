class Solution {
    public int subarraySum(int[] nums, int k) {
       Map<Integer,Integer> mp= new HashMap<>();
       int count=0;
       int sum=0;
       mp.put(0, 1);
       for(int i=0;i<nums.length;i++){
        sum +=nums[i];
        // if(sum==k) count++;
            if(mp.containsKey(sum-k)) count+= mp.get(sum-k);
          mp.put(sum,mp.getOrDefault(sum, 0) + 1);
       } 
       return count;
    }
}