import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	
	private static MorseCodeTree tree = new MorseCodeTree();
	
	public MorseCodeConverter()
	{
		tree = new MorseCodeTree();
	}

	/**
	 * Converts String in morse code to plain english.
	 * @param code
	 * @return the converted string
	 */
	public static String convertToEnglish(String code)
	{
		
		String[] list = code.split("/");
		String tro[];
		
		String temp = "";
		for (int i = 0; i < list.length; i++) {
			
			list[i] = list[i].trim();
			tro = list[i].split(" ");
			
			
			for (int j=0; j <tro.length; j++) 
				temp += tree.fetch(tro[j]);
			
			temp += " ";

		}
		String x = temp.trim();
		return x;
	}

	/**
	 * Converts text in morse code file  to plain english.
	 * @param f
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File f) throws FileNotFoundException 
	{
			String converted = "";
			Scanner sc = new Scanner(f);
			
			while(sc.hasNext())
				converted += convertToEnglish(sc.next());

			return converted.trim();

	}

	/**
	 * Prints all elements in the tree.
	 * @return
	 */
	public static String printTree()
	{
		ArrayList<String> temp = tree.toArrayList();
		String str = temp.toString();
		return str.replace(",", "").replace("[", "").replace("]", "");
	}
}

