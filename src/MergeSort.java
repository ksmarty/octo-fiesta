import java.util.Scanner;

public class MergeSort {

	/* Merge Sort function */
	public static void sort(String[] animals, int low, int high) {
		int N = high - low;

		if (N <= 1)
			return;
		int mid = low + N / 2;

		// Recursively sort
		sort(animals, low, mid);
		sort(animals, mid, high);

		// Merge two sorted subarrays
		String[] temp = new String[N];
		int i = low, j = mid;
		for (int k = 0; k < N; k++) {
			if (i == mid)
				temp[k] = animals[j++];
			else if (j == high)
				temp[k] = animals[i++];
			else if (animals[j].compareTo(animals[i]) < 0)
				temp[k] = animals[j++];
			else
				temp[k] = animals[i++];
		}
		for (int k = 0; k < N; k++)
			animals[low + k] = temp[k];
	}

	/* Main method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("The Greatest Merge Sort Ever\n");
		int n, i;

		/* Accept number of elements */
		System.out.println("Enter number of animals:");
		n = Integer.parseInt(input.nextLine());

		/* Create array of n elements */
		String[] arr = new String[n];

		/* Accept elements */
		System.out.println("\nEnter " + n + " animals:");
		for (i = 0; i < n; i++)
			arr[i] = input.nextLine();
		input.close();

		/* Call method sort */
		sort(arr, 0, n);

		/* Print sorted Array */
		System.out.println("\nSorted Animals:");
		for (i = 0; i < n; i++) {
			System.out.print(arr[i]);
			if (i != n - 1)
				System.out.print(", ");
		}
		System.out.println();
	}

}
