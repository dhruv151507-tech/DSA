
class Solution {
    static const int MOD = 1e9 + 7;
    
    struct Node {
        long long sum_sq;
        long long sum_d;
        long long lazy;
    };
    
    vector<Node> tree;
    
    void push(int node, int l, int r) {
        if (tree[node].lazy != 0) {
            int mid = (l + r) / 2;
            apply(2 * node, l, mid, tree[node].lazy);
            apply(2 * node + 1, mid + 1, r, tree[node].lazy);
            tree[node].lazy = 0;
        }
    }
    
    void apply(int node, int l, int r, long long val) {
        long long len = (r - l + 1);
        // (d + val)^2 = d^2 + 2*d*val + val^2 * len
        tree[node].sum_sq = (tree[node].sum_sq + 2 * val * tree[node].sum_d + val * val % MOD * len) % MOD;
        tree[node].sum_d = (tree[node].sum_d + val * len) % MOD;
        tree[node].lazy = (tree[node].lazy + val) % MOD;
    }
    
    void update(int node, int l, int r, int ql, int qr, long long val) {
        if (ql > r || qr < l) return;
        if (ql <= l && r <= qr) {
            apply(node, l, r, val);
            return;
        }
        push(node, l, r);
        int mid = (l + r) / 2;
        update(2 * node, l, mid, ql, qr, val);
        update(2 * node + 1, mid + 1, r, ql, qr, val);
        tree[node].sum_sq = (tree[2 * node].sum_sq + tree[2 * node + 1].sum_sq) % MOD;
        tree[node].sum_d = (tree[2 * node].sum_d + tree[2 * node + 1].sum_d) % MOD;
    }

public:
    int sumCounts(vector<int>& nums) {
        int n = nums.size();
        tree.assign(4 * n + 1, {0, 0, 0});
        
        vector<int> last_occurrence(100005, -1);
        long long total_sum = 0;
        long long current_sum_sq = 0;
        
        for (int j = 0; j < n; ++j) {
            int prev = last_occurrence[nums[j]];
            // Range update from prev + 1 to j
            update(1, 0, n - 1, prev + 1, j, 1);
            last_occurrence[nums[j]] = j;
            
            total_sum = (total_sum + tree[1].sum_sq) % MOD;
        }
        
        return total_sum;
    }
};