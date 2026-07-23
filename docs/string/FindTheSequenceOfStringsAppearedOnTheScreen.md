# FindTheSequenceOfStringsAppearedOnTheScreen

**Topic:** `string` | **File:** `com/problems/string/FindTheSequenceOfStringsAppearedOnTheScreen.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/find-the-sequence-of-strings-appeared-on-the-screen/description/)

## Approaches

Implementation:

### Implementation

Optimized approach

```java
private static void type1() {
        String target = "abc";
        List<String> ans = stringSequence1(target);
        System.out.println(ans);
    }
    public static List<String> stringSequence1(String target) {
        List<String> answer = new ArrayList<>();
        StringBuilder bucket = new StringBuilder();
        for (char ch : target.toCharArray()) {
            // we will start with 'a' and go till 'ch'
            for (char c = 'a'; c <= ch; c++) {
                answer.add(bucket.toString() + c);
            }
            // once it is reached 'ch' we will go to the next letter
            bucket.append(ch);
        }
        return answer;
    }
```
