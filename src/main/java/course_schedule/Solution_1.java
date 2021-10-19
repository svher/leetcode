package course_schedule;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution_1 implements Solution {

    @Override
    @SuppressWarnings("unchecked")
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            g[prerequisite[0]].add(prerequisite[1]);
        }
        int[] inDegrees = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        int n = numCourses;
        for (int i = 0; i < numCourses; i++) {
            inDegrees[i] = g[i].size();
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int top = queue.poll();
            n--;
            for (int i = 0; i < numCourses; i++) {
                if (g[i].remove(Integer.valueOf(top))) {
                    if (--inDegrees[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return n == 0;
    }
}
