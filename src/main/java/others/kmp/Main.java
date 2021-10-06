package others.kmp;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        KMP kmp = new KMP("ABCDABD");
        List<Integer> ans = kmp.search("ABC ABCDAB ABCDABCDABDE");
        System.out.println(ans);
    }
}
