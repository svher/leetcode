package others.lca_using_rmq;

import java.util.Vector;

// JAVA code to find LCA of given
// two nodes in a tree
@SuppressWarnings("unchecked")
public class Main {
    static int maxn = 100005;

    static int left(int i) {
        return (2 * i + 1);
    }

    static int right(int i) {
        return 2 * i + 2;
    }

    // the graph
    static Vector<Integer>[] g = new Vector[maxn];

    // level of each node
    static int[] level = new int[maxn];
    static Vector<Integer> e = new Vector<>();
    static Vector<Integer> l = new Vector<>();
    static int[] h = new int[maxn];

    // the segment tree
    static int[] st = new int[4 * maxn];

    // adding edges to the graph(tree)
    static void add_edge(int u, int v) {
        g[u].add(v);
        g[v].add(u);
    }

    // assigning level to nodes
    static void leveling(int src) {
        for (int i = 0; i < (g[src].size()); i++) {
            int des = g[src].get(i);
            if (level[des] == 0) {
                level[des] = level[src] + 1;
                leveling(des);
            }
        }
    }

    static boolean[] visited = new boolean[maxn];

    // storing the dfs traversal
    // in the array e
    static void dfs(int src) {
        e.add(src);
        visited[src] = true;
        for (int i = 0; i < (g[src]).size(); i++) {
            int des = g[src].get(i);
            if (!visited[des]) {
                dfs(des);
            }
        }
    }

    // making the array l
    static void setting_l(int n) {
        for (Integer integer : e) {
            l.add(level[integer]);
        }
    }

    // making the array h
    static void setting_h(int n) {
        for (int i = 0; i <= n; i++)
            h[i] = -1;
        for (int i = 0; i < e.size(); i++) {

            // if is already stored
            if (h[e.get(i)] == -1)
                h[e.get(i)] = i;
        }
    }

    // Range minimum query to return the index
    // of minimum in the subarray L[qs:qe]
    static int RMQ(int ss, int se, int qs, int qe, int i) {
        if (ss > se)
            return -1;

        // out of range
        if (se < qs || qe < ss)
            return -1;

        // in the range
        if (qs == ss && se == qe)
            return st[i];

        int mid = (ss + se) / 2;
        int st = RMQ(ss, mid, qs, Math.min(qe, mid), left(i));
        int en = RMQ(mid + 1, se, Math.max(qs, mid + 1), qe, right(i));

        if (st != -1 && en != -1) {
            if (l.get(st) < l.get(en))
                return st;
            return en;
        } else if (st != -1)
            return st;
        else if (en != -1)
            return en;
        return 0;
    }

    // constructs the segment tree
    static void SegmentTreeConstruction(int ss,
                                        int se, int i) {
        if (ss > se)
            return;
        if (ss == se) // leaf
        {
            st[i] = ss;
            return;
        }
        int mid = (ss + se) / 2;

        SegmentTreeConstruction(ss, mid, left(i));
        SegmentTreeConstruction(mid + 1, se, right(i));
        if (l.get(st[left(i)]) < l.get(st[right(i)]))
            st[i] = st[left(i)];
        else
            st[i] = st[right(i)];
    }

    // Function to get LCA
    static int LCA(int x, int y) {
        if (h[x] > h[y]) {
            int t = x;
            x = y;
            y = t;
        }
        return e.get(RMQ(0, l.size() - 1, h[x], h[y], 0));
    }

    // Driver code
    public static void main(String[] args) {

        // n=number of nodes in the tree
        // q=number of queries to answer
        int n = 15, q = 5;
        for (int i = 0; i < g.length; i++) {
            g[i] = new Vector<>();
        }
        add_edge(1, 2);
        add_edge(1, 3);
        add_edge(1, 4);
        add_edge(3, 5);
        add_edge(4, 6);
        add_edge(5, 7);
        add_edge(5, 8);
        add_edge(5, 9);
        add_edge(7, 10);
        add_edge(7, 11);
        add_edge(7, 12);
        add_edge(9, 13);
        add_edge(9, 14);
        add_edge(12, 15);
        level[1] = 1;
        leveling(1);
        dfs(1);
        setting_l(n);
        setting_h(n);
        SegmentTreeConstruction(0, l.size() - 1, 0);
        System.out.print(LCA(2, 12) + "\n");
        System.out.print(LCA(11, 14) + "\n");
        System.out.print(LCA(10, 12) + "\n");
    }
}

// This code is contributed by Rajput-Ji
