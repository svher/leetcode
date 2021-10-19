package course_schedule_iii;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(course -> course[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int total = 0;
        for (int[] course : courses) {
            total += course[0];
            pq.add(course[0]);

            if (total > course[1]) {
                total -= pq.poll();
            }
        }
        return pq.size();
    }
}
