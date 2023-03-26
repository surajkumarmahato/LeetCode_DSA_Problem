/*
Longest Cycle in a Graph
You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.

The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from node i to node edges[i].
If there is no outgoing edge from node i, then edges[i] == -1.

Return the length of the longest cycle in the graph. If no cycle exists, return -1.

A cycle is a path that starts and ends at the same node.
*/
class Solution 
{
    public int longestCycle(int[] edges) 
    {
    int res = -1;
    boolean[] vis = new boolean[edges.length]; // global visisted
    for(int i=0; i<edges.length; i++)
    {
        if(vis[i]) continue;
        HashMap<Integer, Integer> x = new HashMap<>();  // local visited
        for (int idx=i, dist=0; idx!=-1; idx=edges[idx])
        {
            if(x.containsKey(idx))
            {
                res = Math.max(res, dist-x.get(idx));
                break;
            }
            if(vis[idx]) break;
            vis[idx] = true;
            x.put(idx, dist++);
        } 
    }
    return res;
    }
}