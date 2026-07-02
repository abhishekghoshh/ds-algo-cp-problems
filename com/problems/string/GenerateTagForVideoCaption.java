package com.problems.string;
/*
 * Problem link :
 * https://leetcode.com/contest/weekly-contest-454/problems/generate-tag-for-video-caption/
 * https://leetcode.com/problems/generate-tag-for-video-caption/description/
 *
 * Solution link :
 *
 *
 */

// Tags : Array, String
public class GenerateTagForVideoCaption {
    public static void main(String[] args) {
        type1();
        type2();
    }

    private static void type2() {
    }

    private static void type1() {
        String caption = "   ";
        String ans = generateTag1(caption);
        System.out.println(ans);
    }

    public static String generateTag1(String caption) {
        StringBuilder sb = new StringBuilder();
        char[] arr = caption.toCharArray();
        int n = arr.length;
        sb.append('#');
        int startIndex = 0;
        while (startIndex < n && arr[startIndex] == ' ') {
            startIndex++;
        }
        if (startIndex < n)
            sb.append(Character.toLowerCase(arr[startIndex++]));
        boolean start = false;
        for (int i = startIndex; i < n; i++) {
            char ch = arr[i];
            if (ch == ' ') {
                start = true;
                continue;
            }
            if (start) {
                sb.append(Character.toUpperCase(ch));
                start = false;
            } else {
                sb.append(Character.toLowerCase(ch));
            }
            if (sb.length() == 100) break;
        }
        return sb.toString();
    }
}