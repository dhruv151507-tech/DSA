class Solution {
public:
    long long minSumSquareDiff(vector<int>& nums1, vector<int>& nums2, int k1, int k2) {
        int n = nums1.size();
        long long k = (long long)k1 + k2;

        vector<long long> diff(n);
        long long total = 0;
        long long mx = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = abs(nums1[i] - nums2[i]);
            total += diff[i];
            mx = max(mx, diff[i]);
        }

        if (total <= k) return 0;

        long long low = 0, high = mx;
        long long target = mx;

        while (low <= high) {
            long long mid = low + (high - low) / 2;
            long long needed = 0;

            for (long long d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                target = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        long long remaining = k;
        for (int i = 0; i < n; i++) {
            if (diff[i] > target) {
                remaining -= (diff[i] - target);
                diff[i] = target;
            }
        }

        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] == target && diff[i] > 0) {
                diff[i]--;
                remaining--;
            }
        }

        long long ans = 0;
        for (long long d : diff) {
            ans += d * d;
        }

        return ans;
    }
};