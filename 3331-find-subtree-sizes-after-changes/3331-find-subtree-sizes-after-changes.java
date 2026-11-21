class Solution {
    private List<Integer>[] origTree;
    private List<Integer>[] newTree;
    private int[] parent;
    private String s;
    private int[] answer;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.parent = parent;
        this.s = s;
        this.answer = new int[n];

        origTree = new ArrayList[n];
        newTree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            origTree[i] = new ArrayList<>();
            newTree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            origTree[parent[i]].add(i);
        }

        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        buildNewTree(0, lastSeen);

        computeSizes(0);

        return answer;
    }

    private void buildNewTree(int u, int[] lastSeen) {
        int charIdx = s.charAt(u) - 'a';
        int prevAncestor = lastSeen[charIdx];

        if (u != 0) {
            int finalParent = (prevAncestor != -1) ? prevAncestor : parent[u];
            newTree[finalParent].add(u);
        }

        lastSeen[charIdx] = u;
        for (int v : origTree[u]) {
            buildNewTree(v, lastSeen);
        }
        lastSeen[charIdx] = prevAncestor;
    }

    private int computeSizes(int u) {
        int size = 1;
        for (int v : newTree[u]) {
            size += computeSizes(v);
        }
        answer[u] = size;
        return size;
    }
}