package the_skyline_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class Solution_1 implements Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        int N = 1;
        while (N < n) {
            N <<= 1;
        }
        int[][] buildingHeights = new int[n * 2][];
        for (int i = 0; i < n; ++i) {
            buildingHeights[i * 2] = new int[] {i, buildings[i][0], buildings[i][2]};
            buildingHeights[i * 2 + 1] = new int[] {i, buildings[i][1], 0};
        }
        int[] tree = new int[N * 2 - 1];
        // 按坐标排序
        Arrays.sort(buildingHeights, Comparator.comparingInt(h -> h[1]));
        List<List<Integer>> results = new ArrayList<>();
        for (int[] buildingHeight : buildingHeights) {
            int index = buildingHeight[0];
            int cord = buildingHeight[1];
            int height = buildingHeight[2];

            int maxHeight = update(tree, N, 0, index, height);
            results.add(Arrays.asList(cord, maxHeight));
            while (results.size() > 1) {
                List<Integer> result = results.get(results.size() - 1);
                List<Integer> result2 = results.get(results.size() - 2);
                if (!Objects.equals(result.get(0), result2.get(0)) && !Objects.equals(result.get(1), result2.get(1))) {
                    break;
                }
                if (Objects.equals(result.get(0), result2.get(0))) {
                    result2.set(1, maxHeight);
                }
                results.remove(results.size() - 1);
            }
        }
        return results;
    }

    int update(int[] tree, int N, int node, int leaf, int value) {
        if (node > N - 2) { // is leaf node? non-leaf node N-1;; leaf node N;; beginning with 0;;
            return tree[node] = value;
        }

        if ((leaf & 1) == 0) { // go left
            return tree[node] = Math.max(update(tree, N, node * 2 + 1, leaf >> 1, value), tree[node * 2 + 2]);
        } else {
            return tree[node] = Math.max(tree[node * 2 + 1], update(tree, N, node * 2 + 2, leaf >> 1, value));
        }
    }
}