# ParsingABooleanExpression

**Topic:** `recursion`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/parsing-a-boolean-expression/description/)

## 📝 Problem Statement

so we made the pointer i as public static variable

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

this approach is very neat and clean

```java
    private static void type2() {
        String expression = "!(&(!(t),!(!(&(f))),&(&(!(&(f)),&(t),|(f,f,t)),&(t),&(t,t,f))))";
        i = 0;
        boolean ans = parseBoolExpr(expression);
        System.out.println(ans);
    }

    // this approach is very neat and clean
    public static boolean parseBoolExpr(String expression) {
        boolean result = true;

        switch (expression.charAt(i++)) {
            case 't':
                return true;
            case 'f':
                return false;

            case '(':
            case ',':
                return parseBoolExpr(expression);

            case '!':
                result = !parseBoolExpr(expression);
                break;

            case '&':
                while (expression.charAt(i) != ')') {
                    result &= parseBoolExpr(expression);
                }
                break;

            case '|':
                result = false;
                while (expression.charAt(i) != ')') {
                    result |= parseBoolExpr(expression);
                }
                break;
        }
        i++;

        return result;
    }
```

### Approach 1: 🔨 Brute Force

using recursion. one thing we understand is we need the pointer move irrespective of the recursion stack, so we made the pointer i as public static variable

```java
    private static void type1() {
        String expression = "!(&(!(t),!(!(&(f))),&(&(!(&(f)),&(t),|(f,f,t)),&(t),&(t,t,f))))";
        i = 0;
        boolean ans = parseBoolExpr(expression.toCharArray()) == 't';
        System.out.println(ans);
    }

    static int i;

    public static char parseBoolExpr(char[] arr) {
        char op = arr[i];
        i = i + 2;
        char curr = arr[i], prev = '-';
        while (curr != ')') {
            System.out.println(curr + " " + i);
            if (curr == 't' || curr == 'f') {
                prev = parse(op, prev, curr);
            } else if (curr != ',') {
                prev = parse(op, prev, parseBoolExpr(arr));
            }
            curr = arr[++i];
        }
        return prev;
    }

    public static char parse(char op, char prev, char curr) {
        if (op == '!') return curr == 't' ? 'f' : 't';
        if (prev == '-') return curr;
        if (op == '&') {
            return (prev == 'f' || curr == 'f') ? 'f' : 't';
        } else {
            return (prev == 't' || curr == 't') ? 't' : 'f';
        }
    }
}
```
