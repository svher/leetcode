package trapping_rain_water;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        int vol = solution.trap(new int[] {2, 1, 3});
        System.out.println(vol);
        vol = solution.trap(new int[] {4, 2, 0, 3, 2, 5});
        System.out.println(vol);
        vol = solution.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(vol);
    }
}
