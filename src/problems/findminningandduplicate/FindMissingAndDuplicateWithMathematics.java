package problems.findminningandduplicate;

public class FindMissingAndDuplicateWithMathematics {
	public static void main(String[] args) {
		int arr[] = { 7, 3, 4, 5, 5, 6, 2 };
		int n = arr.length;
		int calculatedSum = 0;
		int calculatedSquaredSum = 0;
		for (int item : arr) {
			calculatedSum = calculatedSum + item;
			calculatedSquaredSum = calculatedSquaredSum + item * item;
		}
		int sum = n * (n + 1) / 2;
		int squaredSum = n * (n + 1) * (2 * n + 1) / 6;
		int difference = sum - calculatedSum;
		int addition = (squaredSum - calculatedSquaredSum) / difference;
		int missingElement = (addition + difference) / 2;
		int duplicateElement = (addition - difference) / 2;

		System.out.println("Missing element is " + missingElement);
		System.out.println("duplicate element is " + duplicateElement);

	}
}
