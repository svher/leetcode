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
            if (right < left) {
                return;
            }
            if (start == left && end == right) {
                tree[node] = Math.max(tree[node], value);
                return;
            }
            int mid = (start + end) >> 1;
            update(node * 2, start, mid, left, Math.min(mid, right), value);
            update(node * 2 + 1, mid + 1, end, Math.max(left, mid + 1), right, value);
        }

        int query(int node, int start, int end, int index) {
            if (start == end) {
                return tree[node];
            }
            int mid = (start + end) >> 1;
            int res = index <= mid ? query(node * 2, start, mid, index) : query(node * 2 + 1, mid + 1, end, index);
            // 由于存在 Lazy Propagation，需要有一个 Max 操作
            // 因为 tree[node] 表示存在一个更新 [start, end] 区间上最大值的操作
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
