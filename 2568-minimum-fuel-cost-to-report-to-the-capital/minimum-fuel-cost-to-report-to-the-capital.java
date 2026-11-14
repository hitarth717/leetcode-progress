import java.util.*;

class Solution {
    long fuel = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for (int[] r : roads) {
            graph[r[0]].add(r[1]);
            graph[r[1]].add(r[0]);
        }
        
        dfs(0, -1, graph, seats);
        return fuel;
    }

    private long dfs(int node, int parent, List<Integer>[] graph, int seats) {
        long count = 1;
        
        for (int child : graph[node]) {
            if (child != parent) {
                count += dfs(child, node, graph, seats);
            }
        }
        
        if (node != 0) {
            fuel += (count + seats - 1) / seats;
        }
        
        return count;
    }
}