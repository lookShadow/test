package com.cn.ouyjs.test;

import java.util.*;

/**
 * @author ouyjs
 * @date 2019/6/20 16:34
 */
public class StringJoinTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        System.out.println(String.join("a","b"));
        System.out.println(String.join("a",list));

    }
    public native boolean isInterrupted(boolean var1);
/*    public static String join(CharSequence var0, CharSequence... var1) {
        Objects.requireNonNull(var0);
        Objects.requireNonNull(var1);
        StringJoiner var2 = new StringJoiner(var0);
        CharSequence[] var3 = var1;
        int var4 = var1.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            CharSequence var6 = var3[var5];
            var2.add(var6);
        }

        return var2.toString();
    }*/


    public static String join(CharSequence var0, CharSequence... var1) {
        Objects.requireNonNull(var0);
        Objects.requireNonNull(var1);
        StringJoiner var2 = new StringJoiner(var0);
        CharSequence[] var3 = var1;
        int var4 = var1.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            CharSequence var6 = var3[var5];
            var2.add(var6);
        }

        return var2.toString();
    }

    public static String join(CharSequence var0, Iterable<? extends CharSequence> var1) {
        Objects.requireNonNull(var0);
        Objects.requireNonNull(var1);
        StringJoiner var2 = new StringJoiner(var0);
        Iterator var3 = var1.iterator();

        while(var3.hasNext()) {
            CharSequence var4 = (CharSequence)var3.next();
            var2.add(var4);
        }

        return var2.toString();
    }
}
