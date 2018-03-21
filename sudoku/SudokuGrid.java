//Marija Mumm, 2232817m

package sudoku;

import java.io.IOException;
import java.util.Arrays;

public class SudokuGrid {

	public int[][] sudokuGrid;

	// constructor
	public SudokuGrid(String filename) throws IOException {
		String loadedValues = Utils.loadGrid(filename);

		// arr is an array with some integers and empty entries
		String[] arr = loadedValues.split(",", 81);

		// replacing empty entries with 0s
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("")) {
				arr[i] = "0";
			}
		}

		// creating a two-dimensional array of integers
		sudokuGrid = new int[Utils.SIZE][Utils.SIZE];
		int k = 0; // index
		for (int i = 0; i < Utils.SIZE; i++) {
			for (int j = 0; j < Utils.SIZE; j++) {
				sudokuGrid[i][j] = Integer.valueOf(arr[k]);
				k++;
			}
		}
	}

	// creating a string representation of the array
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Utils.SIZE; i++) {
			for (int j = 0; j < Utils.SIZE; j++) {
				sb.append(String.valueOf(sudokuGrid[i][j]));
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public String check() {
		// if after all checks incomplete is true and array is valid, then it is
		// incomplete
		boolean incomplete = false;
		// small_array[] is an array of 9 integers, a column/row/square of 9
		// check rows
		for (int i = 0; i < Utils.SIZE; i++) {
			int[] small_array = new int[Utils.SIZE];
			for (int j = 0; j < Utils.SIZE; j++) {
				small_array[j] = sudokuGrid[i][j];
			}
			// result shows if the small array of 9 elements is valid/incomplete or invalid
			int result = check_small_array(small_array);

			// results variable: if 1 - array of 9 elements is valid, 2 - incomplete, 3 -
			// invalid
			if (result == 2) {
				incomplete = true;
			} else if (result == 3) {
				return Utils.INVALID;
			}

		}

		// check columns
		for (int i = 0; i < Utils.SIZE; i++) {
			int[] small_array = new int[Utils.SIZE];
			for (int j = 0; j < Utils.SIZE; j++) {
				small_array[j] = sudokuGrid[j][i];
			}
			// result shows if the small array of 9 elements is valid/incomplete or invalid
			int result = check_small_array(small_array);
			// results variable: if 1 - array of 9 elements is valid, 2 - incomplete, 3 -
			// invalid
			if (result == 2) {
				incomplete = true;
			} else if (result == 3) {
				return Utils.INVALID;
			}
		}

		// check 3x3 squares
		for (int col = 0; col < 3; col++) {
			for (int row = 0; row < 3; row++) {
				int[] small_array = new int[Utils.SIZE];
				int no = 0;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						small_array[no] = sudokuGrid[row * 3 + i][col * 3 + j];
						no++;
					}
				}
				// result shows if the small array of 9 elements is valid/incomplete or invalid
				int result = check_small_array(small_array);
				// results variable: if 1 - array of 9 elements is valid, 2 - incomplete, 3 -
				// invalid
				if (result == 2) {
					incomplete = true;
				} else if (result == 3) {
					return Utils.INVALID;
				}
			}
		}

		// final check
		// if array was invalid, the Utils.INVALID was returned already
		// array might be incomplete or otherwise valid
		if (incomplete == true) {
			return Utils.INCOMPLETE;
		} else {
			return Utils.VALID;
		}

	}

	public static int check_small_array(int[] check_array) {
		int[] classic_array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		boolean incomplete = false;
		// returns 1 if an array of 9 elements is valid
		// returns 2 if an array of 9 elements is incomplete
		// returns 3 if an array of 9 elements invalid

		// check_array is sorted ascending
		Arrays.sort(check_array);
		if (Arrays.equals(check_array, classic_array) == false) {
			for (int i = 0; i <= 9; i++) {
				int count = 0; // count how many times each number from 0 to 9 appears (0 for empty cells)
				for (int j = 0; j < Utils.SIZE; j++) {
					if (check_array[j] == i) {
						count++;
					}
				}
				if (count > 1 & i != 0) {
					return 3; // if a non-0 number is repeated more than once, array is invalid
				} else if (count > 0 & i == 0) {
					incomplete = true; // array is incomplete, but still might be invalid, so keep checking
				}
			}
		}
		if (incomplete == true) {
			return 2; // array is incomplete
		}
		return 1; // array is valid
	}

}