class Solution {
static final int MOD = 1_000_000_007;
    List<List<Long>> pt = new ArrayList<>();

    public int numOfWays(int[] nums) {
        int n = nums.length;

        for(int i=0;i<n;i++){
            List<Long> row=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==i || j==0) row.add(1L);
                else{
                    Long value = (pt.get(i-1).get(j-1) + pt.get(i-1).get(j))%MOD;
                    row.add(value);
                }
            }
             pt.add(row);
        }


        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        return (int) ((solve(list) - 1 + MOD) % MOD);

    }

    private long solve(List<Integer> nums) {
        int n = nums.size();
        if (n < 3)
            return 1;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int root = nums.get(0);
        for (int i = 1; i < n; i++) {
            if (nums.get(i) < root)
                left.add(nums.get(i));
            else
                right.add(nums.get(i));
        }
        long x = solve(left);
        long y = solve(right);
        long z = pt.get(n - 1).get(left.size());
        return (((x * y) % MOD) * z) % MOD;
    }

}