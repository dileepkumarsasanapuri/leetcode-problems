class Solution {
    class Pair {
        int f, s;
        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }
    class Tuple {
        int stops, node, cost;
        Tuple(int stops, int node, int cost) {
            this.stops = stops;
            this.node = node;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));

        // Track best cost per (node, stops) to avoid revisits
        int[][] costWithStops = new int[n][k + 2];
        for (int[] row : costWithStops) Arrays.fill(row, Integer.MAX_VALUE);
        costWithStops[src][0] = 0;

        while (!q.isEmpty()) {
            Tuple tp = q.poll();
            int stops = tp.stops;
            int node = tp.node;
            int cost = tp.cost;

            if (stops > k) continue;

            for (Pair neighbor : adj.get(node)) {
                int nextNode = neighbor.f;
                int nextCost = neighbor.s;
                if (cost + nextCost < costWithStops[nextNode][stops + 1]) {
                    costWithStops[nextNode][stops + 1] = cost + nextCost;
                    q.add(new Tuple(stops + 1, nextNode, cost + nextCost));
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= k + 1; i++) {
            minCost = Math.min(minCost, costWithStops[dst][i]);
        }
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}
