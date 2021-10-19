package course_schedule_ii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution_1 implements Solution {

    @Override
    @SuppressWarnings("unchecked")
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            g[prerequisite[0]].add(prerequisite[1]);
        }
        int[] inDegrees = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            inDegrees[i] = g[i].size();
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int top = queue.poll();
            ans.add(top);
            for (int i = 0; i < numCourses; i++) {
                if (g[i].remove(Integer.valueOf(top))) {
                    if (--inDegrees[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return ans.size() == numCourses ?
                ans.stream().mapToInt(x -> x).toArray() : new int[0];
    }
}
