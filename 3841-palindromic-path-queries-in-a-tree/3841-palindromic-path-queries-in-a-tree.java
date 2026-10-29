import java.util.*;

class Solution {
private List<Integer>[] adj;
private int[] parent, depth, tin, tout, size;
private int[][] up;
private int LOG;
private Fenwick bit;

public List<Boolean> palindromePath(int n, int[][] edges, String s,String[] queries) {

    adj = new ArrayList[n];

    for (int i = 0; i < n; i++) {
        adj[i] = new ArrayList<>();
    }

    for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];

        adj[u].add(v);
        adj[v].add(u);
    }

    parent = new int[n];
    depth = new int[n];
    tin = new int[n];
    tout = new int[n];
    size = new int[n];

    Arrays.fill(parent, -1);
    Arrays.fill(size, 1);

    int[] order = new int[n];
    int[] stack = new int[n];

    int top = 0;
    int timer = 0;

    stack[top++] = 0;
    parent[0] = 0;

    while (top > 0) {
        int u = stack[--top];

        tin[u] = timer;
        order[timer++] = u;

        for (int v : adj[u]) {
            if (parent[v] == -1) {
                parent[v] = u;
                depth[v] = depth[u] + 1;
                stack[top++] = v;
            }
        }
    }

    for (int i = n - 1; i > 0; i--) {
        int u = order[i];
        size[parent[u]] += size[u];
    }


    for (int i = 0; i < n; i++) {
        tout[i] = tin[i] + size[i] - 1;
    }


    LOG = 1;

    while ((1L << LOG) <= n) {
        LOG++;
    }

    up = new int[LOG][n];

    for (int i = 0; i < n; i++) {
        up[0][i] = parent[i];
    }

    for (int k = 1; k < LOG; k++) {
        for (int i = 0; i < n; i++) {
            up[k][i] = up[k - 1][up[k - 1][i]];
        }
    }

    bit = new Fenwick(n);

    char[] chars = s.toCharArray();


    for (int i = 0; i < n; i++) {
        int mask = 1 << (chars[i] - 'a');

        rangeXor(tin[i], tout[i], mask);
    }

    List<Boolean> answer = new ArrayList<>();

    for (String query : queries) {
        String[] parts = query.split("\\s+");

        if (parts[0].equals("update")) {
            int u = Integer.parseInt(parts[1]);
            char c = parts[2].charAt(0);

            int oldMask = 1 << (chars[u] - 'a');
            int newMask = 1 << (c - 'a');

            int delta = oldMask ^ newMask;

            rangeXor(tin[u], tout[u], delta);

            chars[u] = c;

        } else {
            int u = Integer.parseInt(parts[1]);
            int v = Integer.parseInt(parts[2]);

            int lca = findLCA(u, v);

            int maskU = bit.query(tin[u] + 1);
            int maskV = bit.query(tin[v] + 1);

            int lcaMask = 1 << (chars[lca] - 'a');

            int pathMask = maskU ^ maskV ^ lcaMask;

            answer.add((pathMask & (pathMask - 1)) == 0);
        }
    }

    return answer;
}

private void rangeXor(int left, int right, int value) {
    bit.update(left + 1, value);
    bit.update(right + 2, value);
}

private int findLCA(int u, int v) {

    if (depth[u] < depth[v]) {
        int temp = u;
        u = v;
        v = temp;
    }

    int diff = depth[u] - depth[v];

    for (int k = 0; k < LOG; k++) {
        if (((diff >> k) & 1) != 0) {
            u = up[k][u];
        }
    }

    if (u == v) {
        return u;
    }

    for (int k = LOG - 1; k >= 0; k--) {
        if (up[k][u] != up[k][v]) {
            u = up[k][u];
            v = up[k][v];
        }
    }

    return parent[u];
}

private static class Fenwick {
    private final int[] tree;
    private final int n;

    Fenwick(int n) {
        this.n = n + 1;
        tree = new int[n + 2];
    }

    void update(int index, int value) {
        for (int i = index; i <= n; i += i & -i) {
            tree[i] ^= value;
        }
    }

    int query(int index) {
        int result = 0;

        for (int i = index; i > 0; i -= i & -i) {
            result ^= tree[i];
        }

        return result;
    }
}


}
