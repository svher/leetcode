package find_median_from_data_stream;

public class Main {

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder_1();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }
}
