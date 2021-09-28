package the_skyline_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution_2 implements Solution {

    class SegmentTree {
        int[] tree;

        public SegmentTree(int size) {
            tree = new int[4 * size];
        }

        void update(int node, int start, int end, int left, int right, int value) {
            if (right < left || right < start || left > end) {
                return;
            }
            if (start == left && end == right) {
                tree[node] = Math.max(tree[node], value);
                return;
            }
            int mid = (start + end) >> 1;
            update(node * 2, start, mid, left, Math.min(mid, right), value);
            // 注意这里要更新的区间是 mid 和 left 的最大值
            update(node * 2 + 1, mid + 1, end, Math.max(left, mid + 1), right, value);
        }

        int query(int node, int start, int end, int index) {
            if (start == end) {
                return tree[node];
            }
            int mid = (start + end) >> 1;
            // 递归要传孩子的 index
            int res = index <= mid ? query(node * 2, start, mid, index) : query(node * 2 + 1, mid + 1, end, index);
            return Math.max(res, tree[node]);
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        Set<Integer> ts = new TreeSet<>();
        for (int[] building : buildings) {
            ts.add(building[0]);
            ts.add(building[1]);
        }
        Map<Integer, Integer> map = new HashMap<>(), rMap = new HashMap<>();
        int ix = 0;
        for (Integer t : ts) {
            map.put(t, ix);
            rMap.put(ix++, t);
        }
        ix--;
        SegmentTree segmentTree = new SegmentTree(ix);
        for (int[] building : buildings) {
            segmentTree.update(1, 0, ix, map.get(building[0]), map.get(building[1]) - 1, building[2]);
        }
        int preHeight = 0, height;
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i <= ix; ++i) {
            height = segmentTree.query(1, 0, ix, i);
            if (preHeight == height) continue;
            ret.add(Arrays.asList(rMap.get(i), height));
            preHeight = height;
        }
        return ret;
    }
}
