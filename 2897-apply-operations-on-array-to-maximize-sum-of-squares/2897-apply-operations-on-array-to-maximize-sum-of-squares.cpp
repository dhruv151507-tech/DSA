class Solution {
public:
int maxSum(vector<int>& nums, int k) {
const long long MOD = 1'000'000'007;
    vector<int> cnt(31, 0);
    for (int num : nums) {
        for (int i = 0; i < 31; i++) {
            if ((num >> i) & 1) {
                cnt[i]++;
            }
        }}

    long long ans = 0;

    for (int j = 0; j < k; j++) {
        long long x = 0;

        for (int i = 0; i < 31; i++) {
            if (cnt[i] > 0) {
                x |= (1LL << i);
                cnt[i]--;
            }  }
        ans = (ans + x * x) % MOD;
    }
    return ans;
}


};
