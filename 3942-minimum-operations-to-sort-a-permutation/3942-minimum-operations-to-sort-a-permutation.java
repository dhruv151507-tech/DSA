class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        boolean issort = true;
        int ans=Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                issort = false;
                break;
            }
        }
        if (issort)
            return 0;

        int zero = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }
        for (int dir : new int[] { 1, -1 }) {
            boolean valid = true;
            for (int i = 1; i < n; i++) {
                int nxt = (zero + i * dir + n) % n;
                int prev = (zero + (i - 1) * dir + n) % n;
                if (nums[nxt] < nums[prev]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                if (dir == 1) {
                    ans = Math.min(ans, zero);
                    ans = Math.min(ans, n - zero + 2);
                } else {
                    ans = Math.min(ans, zero + 2);
                    ans = Math.min(ans, n - zero);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 :ans;
    }
}