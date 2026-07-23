# MaximizeAmountAfterTwoDaysOfConversions

**Topic:** `graph` | **File:** `com/problems/graph/MaximizeAmountAfterTwoDaysOfConversions.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/maximize-amount-after-two-days-of-conversions/description/)

## Approaches

Implementation:

### Implementation

Using recursion and dfs

```java
private static void type1() {
        String initialCurrency = "EUR";
        List<List<String>> pairs1 = List.of(
                List.of("EUR", "USD"),
                List.of("USD", "JPY")
        );
        double[] rates1 = {2.0, 3.0};
        List<List<String>> pairs2 = List.of(
                List.of("JPY", "USD"),
                List.of("USD", "CHF"),
                List.of("CHF", "EUR")
        );
        double[] rates2 = {4.0, 5.0, 6.0};

        double ans = maxAmount1(initialCurrency, pairs1, rates1, pairs2, rates2);
        System.out.println(ans);
    }
    public static double maxAmount1(String initialCurrency,
                                    List<List<String>> pairs1, double[] rates1,
                                    List<List<String>> pairs2, double[] rates2) {
        finalCurrency = initialCurrency;
        int n1 = rates1.length, n2 = rates2.length;
        boolean[] visited1 = new boolean[n1], visited2 = new boolean[n2];
        // We will create a map of initial currency and final currency.
        // However, we can also convert final currency to initial currency with (1/rate).
        // However, if we do this, then we will have an endless loop
        // so to prevent that we will use a visited array and along with storing the currency,
        // we will also store the index. We could also store the rates, but we can derive it from the 'rates' array easily
        Map<String, List<Data>> m1 = loadMap(n1, pairs1, rates1);
        Map<String, List<Data>> m2 = loadMap(n2, pairs2, rates2);
        convert(initialCurrency, 1.0, 0, visited1, m1, visited2, m2);
        return max;
    }
```
