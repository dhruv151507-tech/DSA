class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        long currsum=0;
        long maxsum=0;
        int duplicates=0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])==2) duplicates++;
            currsum +=nums[i];
            if(i>=k){
                int out= nums[i-k];
                if(map.get(out)==2) duplicates--;
                map.put(out, map.get(out)-1);
                if(map.get(out)==0) map.remove(out);
                currsum -=out;
            }
            
            if(i>=k-1 && duplicates==0){
                maxsum=Math.max(maxsum,currsum);
            }
        }
        return maxsum;
    }
}