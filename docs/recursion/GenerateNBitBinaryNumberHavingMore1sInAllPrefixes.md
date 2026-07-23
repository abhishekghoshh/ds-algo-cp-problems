# GenerateNBitBinaryNumberHavingMore1sInAllPrefixes

**Topic:** `recursion`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=U81n0UYtk98&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=18)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/print-n-bit-binary-numbers-1s-0s-prefixes/)
- [📄 LeetCode](https://leetcode.com/discuss/interview-question/1517199/print-n-bit-binary-numbers-having-more-1s-than-0s-java-recursion)

## 📝 Problem Statement

Given a positive integer n, generate all n-bit binary numbers such that, for every prefix of each binary number, the count of 1&#x27;s is greater than or equal to the count of 0&#x27;s. 
Return the binary numbers in decreasing order of their decimal value.
Exa

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

it similar to previous one but here we are changing a little bit in place change we can create an array of 1's then on our need we can add and remove zero we will create a bucket of 1, so for digit 5 we will make 11111 as the bucket has already all ones, so we don't have to add one to the bucket externally again, we will just increase the one's counter as we are considering 0 here, so we are changing that position to 1 again after computation we are changing it back to 1

```java
	private static void type3() {
		int n = 3;
		List<String> answer = new ArrayList<>();
		// we will create a bucket of 1, so for digit 5 we will make 11111
		char[] bucket = new char[n];
        Arrays.fill(bucket, '1');
		traverse(0, 0, n, bucket, answer);
		System.out.println(answer);
	}

	private static void traverse(int ones, int zeros, int n, char[] bucket, List<String> answer) {
		if (ones + zeros == n) {
			answer.add(new String(bucket));
			return;
		}
		// as the bucket has already all ones, so we don't have to add one to the bucket
		// externally again, we will just increase the one's counter
		traverse(ones + 1, zeros, n, bucket, answer);

		if (ones > zeros) {
			// as we are considering 0 here, so we are changing that position to 1
			bucket[ones + zeros] = '0';
			traverse(ones, zeros + 1, n, bucket, answer);
			// again after computation we are changing it back to 1
			bucket[ones + zeros] = '1';
		}
	}
```

### Approach 2

similar to the previous one, but here we will use a char array as we can add 1 anytime, so we are adding to be a part of the answer if number of ones greater than number of zeros, then only we will be adding 0

```java
	private static void type2() {
		int n = 3;
		List<String> answer = new ArrayList<>();
		char[] bucket = new char[n];
		NBitBinary2(0, 0, n, bucket, answer);
		System.out.println(answer);
	}

	private static void NBitBinary2(int ones, int zeros, int n, char[] bucket, List<String> answer) {
		if (ones + zeros == n) {
			answer.add(new String(bucket));
			return;
		}
		// as we can add 1 anytime, so we are adding to be a part of the answer
		bucket[ones + zeros] = '1';
		NBitBinary2(ones + 1, zeros, n, bucket, answer);

		// if number of ones greater than number of zeros, then only we will be adding 0
		if (ones > zeros) {
			bucket[ones + zeros] = '0';
			NBitBinary2(ones, zeros + 1, n, bucket, answer);
		}
	}
```

### Approach 1: 🔨 Brute Force

as we can add 1 anytime, so we are adding to be a part of the answer if number of ones greater than number of zeros, then only we will be adding 0

```java
	private static void type1() {
		int n = 2;
		List<String> answer = new ArrayList<>();
		traverse(0, 0, n, new StringBuilder(), answer);
		System.out.println(answer);
	}

	private static void traverse(int ones, int zeros, int n, StringBuilder bucket, List<String> answer) {
		if (ones + zeros == n) {
			answer.add(bucket.toString());
			return;
		}
		// as we can add 1 anytime, so we are adding to be a part of the answer
		bucket.append("1");
		traverse(ones + 1, zeros, n, bucket, answer);
		bucket.deleteCharAt(bucket.length() - 1);

		// if number of ones greater than number of zeros, then only we will be adding 0
		if (ones > zeros) {
			bucket.append("0");
			traverse(ones, zeros + 1, n, bucket, answer);
			bucket.deleteCharAt(bucket.length() - 1);
		}
	}
}
```
