package find_median_from_data_stream;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder_1 implements MedianFinder {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    boolean even = true;

    @Override
    public void addNum(int num) {
        if (even) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        even = !even;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public double findMedian() {
        if (even) {
            return (maxHeap.peek() + minHeap.peek()) / 2f;
        } else {
            return minHeap.peek();
        }
    }
}
