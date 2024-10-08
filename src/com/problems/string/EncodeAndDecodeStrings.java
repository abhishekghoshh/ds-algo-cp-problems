package com.problems.string;

import java.util.List;

/*
 * Problem link :
 * https://leetcode.com/problems/encode-and-decode-strings/description/
 * https://www.lintcode.com/problem/659/
 * https://neetcode.io/problems/string-encode-and-decode
 *
 * Solution link :
 * https://www.youtube.com/watch?v=B1k_sxOSgv8
 *
 * https://medium.com/@miniChang8/leetcode-encode-and-decode-strings-4dde7e0efa1c
 *
 */
public class EncodeAndDecodeStrings {
    public static void main(String[] args) {
        type1();
    }


    private static void type1() {
        List<String> strs = List.of("neet", "code", "love", "you");
        String encodedString = encode(strs);
        System.out.println(encodedString);
        List<String> decodedString = decode(encodedString);
        System.out.println(decodedString);
    }

    private static final String LS = ">>&&<<";

    public static String encode(List<String> strs) {
        if (strs.isEmpty()) return null;
        StringBuilder sb = new StringBuilder();
        int n = strs.size();
        for (int i = 0; i < n; i++) {
            sb.append(strs.get(i));
            if (i != n - 1) sb.append(LS);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        if (null == str) return List.of();
        return List.of(str.split(LS));
    }
}
