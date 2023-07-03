// Justin Pope

public class SumOfMatrixColumns {

	public static void main(String[] args) {
		
		// Creating the 4-by-4 matrix
		double[][] m = new double[4][4];
		
		// Creating values that will automatically fill the matrix with different values.
		double number0 = 5;
		double number1 = 15;
		double number2 = 40;
		double number3 = 100;
		
		// Adding values to the 4-by-4 matrix
		for (int i=0; i < m.length; i++) {

			// This will add values to the matrix depending on the value of i in the first for loop.
			for (int j=0; j < m.length; j++) {
				
				// This switch statement will fill the matrix and change the values for each column and row.
				switch(i) {
				case 0:
					m[i][j] = number0;
					number0 += 5.5;
					break;
				case 1:
					m[i][j] = number1;
					number1 += 3.6;
					break;
				case 2:
					m[i][j] = number2;
					number2 += 8.8;
					break;
				case 3:
					m[i][j] = number3;
					number3 += 250.56;
					break;
				}
				
			}
			
		}
		
		// Output: This will display the sum of each column using the method sumColumn.
		for (int i = 0; i < m.length; i++) {
			
			// This will format the sum to only have 2 decimal points
			System.out.printf("Sum of the elements at column " + i + " is " + "%4.2f", sumColumn(m, i));
			System.out.println(); // This separates each printf statement with a newline character.

		}

	}
	
	public static double sumColumn(double[][] m, int columnIndex) {
		
		// Creating a variable to hold the sum
		double columnSum = 0;

		// This will iterate through the matrix at the specified column.
		for (int i = columnIndex, j = 0; j < m.length; j++) {
			
			// All of the values in the column will be added together into columnSum.
			columnSum += m[i][j];

		}
		
		return columnSum;
		
	}

}
