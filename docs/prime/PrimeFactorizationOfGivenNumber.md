# PrimeFactorizationOfGivenNumber

**Topic:** `prime`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/prime-factorisation_1760849)

## 📝 Problem Statement

Find the prime factorization of a given number n.

## 💡 Approaches

This problem can be solved in **4** different ways, each improving upon the previous:

### Approach 4: 🏆 Optimal Solution

the most optimized approach for any number maximum prime factor is log(n) base 2 because the lowest prime factor is 2 first we will have to create the modified sieve array

**Time Complexity:** `O(log(n)`

```java
	private static void type4() {
		int n = 124;
		primeFactor = null;
		initiateSieveArray();
		List<Integer> list = new ArrayList<>();
		while (n != 1) {
			if (list.isEmpty() || list.get(list.size() - 1) != primeFactor[n])
				list.add(primeFactor[n]);
			n = n / primeFactor[n];
		}
		System.out.println(list);
	}

	// the most optimized approach
	// for any number maximum prime factor is log(n) base 2
	// because the lowest prime factor is 2
	// time complexity O(log(n))
	// first we will have to create the modified sieve array
	private static int[] primeFactor = null;
	private static final int N = 1000000;// 10^6
```

### Approach 3

that means j is not marked with any prime factor

```java
	private static void type3() {
		if (null == primeFactor) initiateSieveArray();
		int[] queries = {12, 25, 8, 456, 122587, 128, 367};
		for (int query : queries) {
			int q = query;
			List<Integer> list = new ArrayList<>();
			while (query != 1) {
				list.add(primeFactor[query]);
				query = query / primeFactor[query];
			}
			System.out.println(q + " : " + list);
		}
	}

	private static void initiateSieveArray() {
		primeFactor = new int[N + 1];
		for (int i = 0; i <= N; i++) primeFactor[i] = i;
		for (int i = 2; i * i <= N; i++)
			for (int j = i * i; j <= N; j += i)
				// that means j is not marked with any prime factor
				if (primeFactor[j] == j) primeFactor[j] = i;
	}
```

### Approach 2

optimized modified approach but it will also give TLE if query size is 10^6 we know that for any number its factors can be found before sqrt(n) so we can run till sqrt(n) at the end if n is not 1 then there current n is prime that can not be divided further in range of sqrt(n)

**Time Complexity:** `O(sqrt(n)`

```java
	private static void type2() {
		int n = 629;
		List<Integer> answer = new ArrayList<>();
		// we know that for any number its factors can be found before sqrt(n)
		// so we can run till sqrt(n)
		for (int i = 2; i * i <= n; i++) {
			while (n % i == 0) {
				answer.add(i);
				n = n / i;
			}
		}
		// at the end if n is not 1
		// then there current n is prime that can not be divided
		// further in range of sqrt(n)
		if (n != 1) answer.add(n);
		System.out.println(answer);
	}
```

### Approach 1: 🔨 Brute Force

brute force

**Time Complexity:** `O(n)`

```java
	private static void type1() {
		int n = 48;
		List<Integer> answer = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				answer.add(i);
				n = n / i;
			}
		}
		System.out.println(answer);
	}
}
```
