// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

class number-of-connected-components-in-an-undirected-graph {
    //Tc-> ElogV, sc-> V
    public int countComponents(int n, int[][] edges) {
        int[] sets = new int[n];
        for(int i=0; i<n; i++) sets[i]=i;
        
        for(int[] edge : edges){
            int u = find(edge[0], sets);
            int v = find(edge[1], sets);
            if(u!=v) n--;
            sets[u] = v;
        }
        return n;
    }
    private int find(int v, int[] sets){
        return sets[v]==v ? v : find(sets[sets[v]], sets);
    }
}
