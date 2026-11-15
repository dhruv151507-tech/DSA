class Solution {
    public int minStartValue(int[] nums) {
     int sum=0;
     int val=0;
        for (int num : nums) {
            sum +=num;
            val=Math.min(val,sum);
        }
        return 1 - val;
    }
}