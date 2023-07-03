package recusrsionAdvanced;

import java.io.File;
import java.io.IOException;

public class RecursionNumberOfFilesInDirectory {

	public static void main(String[] args) {
		System.out.print("Enter a file or a directory: ");
		java.util.Scanner input = new java.util.Scanner(System.in);
		String s = input.nextLine();
		input.close();
		try {
			System.out.println(numberOfFiles(new File(s)));
		}
		catch (IOException ex) {
			System.out.println(ex.toString());
		}
	}
	
	public static long numberOfFiles(File file)
			  throws java.io.FileNotFoundException{
			long count = 0;
			File[] files = file.listFiles();
			
			if (!file.exists())
				throw new java.io.FileNotFoundException(file + " not found");
			if (file.isFile()) {
				count++;
				return count;
			}
			else {
				for (int i = 0; i < files.length; i++)
					count += numberOfFiles(files[i]);

				return count;
			}
	}
}
