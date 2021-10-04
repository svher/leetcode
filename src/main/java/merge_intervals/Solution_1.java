package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution_1 implements Solution {

    @Override
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return null;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        List<int[]> res = new ArrayList<>();
        int[] pending = intervals[0];
        res.add(pending);
        for (int[] interval : intervals) {
            if (interval[0] > pending[1]) {
                pending = interval;
                res.add(pending);
            } else {
                pending[1] = Math.max(interval[1], pending[1]);
            }
        }
        return res.toArray(new int[0][]);
    }
}
