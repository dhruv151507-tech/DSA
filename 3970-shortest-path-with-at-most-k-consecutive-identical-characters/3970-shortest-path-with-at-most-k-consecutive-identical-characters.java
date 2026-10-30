class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        int[][] dist = new int[n][k + 1];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int weight = curr[0];
            int node = curr[1];
            int count = curr[2];

            if (weight > dist[node][count]) {
                continue;
            }

            if (node == n - 1) {
                return weight;
            }

            for (int[] next : graph[node]) {

                int nextNode = next[0];
                int nextWeight = next[1];

                int nextCount = labels.charAt(node) == labels.charAt(nextNode)
                    ? count + 1 : 1;

                if (nextCount > k) {
                    continue;
                }

                int newWeight = weight + nextWeight;

                if (newWeight < dist[nextNode][nextCount]) {

                    dist[nextNode][nextCount] = newWeight;

                    pq.offer(new int[]{
                        newWeight,
                        nextNode,
                        nextCount
                    });
                }
            }
        }

        return -1;
    }
}