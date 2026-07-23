# GenerateTagForVideoCaption

**Topic:** `string` | **File:** `com/problems/string/GenerateTagForVideoCaption.java`

**Tags:** Array, String

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach

```java
private static void type2() {
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
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
```
