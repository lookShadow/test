package utils;

import com.google.common.base.Splitter;

/**
 * @author ouyjs
 * @date 2019/7/18 16:55
 */
public class Text {
    private static final String b = new String("aa");
    public static void main(String[] args) {
        System.out.println(Splitter.on(",").splitToList("qw,eqwe"));
        String a = new String("bb");
            StringBuilder str  = new StringBuilder();
        for (int i = 0; i <999999999; i++) {
            str =str.append("i");
        }
    }
}
