# FindTheSequenceOfStringsAppearedOnTheScreen

**Topic:** `string`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/find-the-sequence-of-strings-appeared-on-the-screen/description/)

## 📝 Problem Statement

Simulate a typing sequence and return the strings that appeared on screen.

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

optimized approach we will start with 'a' and go till 'ch' once it is reached 'ch' we will go to the next letter

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
}
```
