
package ie.gmit.java2;

/**
 * @author Sarah Carroll ( G00330821 )
 *
 */

import java.util.Scanner;


public class TextAnalyser {


	public static void main(String[] args) {
		// Main Program Loop

		Scanner console=new Scanner(System.in);
		boolean done = false;
		int option, occurs;
		String dummy;
		String filename;

		TextProcessor tp = new TextProcessor();

		String search;

		while(done!=true) {

			option = tp.displayMenu();

			switch(option) {
				case 1 :
							// Get name of book or URL to process
							System.out.print("\nPlease enter .txt filename of BOOK or URL to load: ");
							filename = console.nextLine();

							//parse file or URL
							tp.readFile(filename);
							System.out.println("\nText file or URL loaded ... # words = "+tp.count()+"\n");
							System.out.print("\n\nPress ENTER to return to menu ...");
							dummy = console.nextLine();
							break;

				case 2 :
							//search for specified string
							System.out.print("\nPlease enter string to search for: ");
							search = console.nextLine();
							// Find how many occurrences of search string exist
							occurs = tp.countOccurences(search);

							System.out.println("\n\nString '"+search+"' appears in file : "+(tp.contains(search)==true?"YES":"NO"));
							if(occurs > 0) {
								System.out.println("\nString '"+search+"' appears "+occurs+" times!");
								System.out.println("\nString first occurs at: "+tp.getFirstIndex(search));
								System.out.println("\nString last  occurs at: "+tp.getLastIndex(search));
							}
							System.out.print("\n\nPress ENTER to return to menu ...");
							dummy = console.nextLine();
							break;

				case 3 :
							//delete entries for specified string
							System.out.print("\nPlease enter string to delete: ");
							search = console.nextLine();

							// Find how many occurrences of search string exist
							occurs = tp.countOccurences(search);

							System.out.println("\n\nString '"+search+"' appears in file : "+(tp.contains(search)==true?"YES":"NO"));
							if(occurs > 0) {
								System.out.println("\nString '"+search+"' appears "+occurs+" times!");
								//tp.getAllIndices(search);
								//System.out.println("\nList of indices created!");
								tp.delete(search);
								System.out.println("\nAll strings for '"+search+"' deleted!");
							}
							System.out.print("\n\nPress ENTER to return to menu ...");
							dummy = console.nextLine();
							break;

				case 4 :
							//print array stats
							System.out.printf("\nText file originally contained   %6d words",tp.getOriginalCount());
							System.out.printf("\nText file in Memory now contains %6d words",tp.count());
							System.out.printf("\nNumber of Searches performed  =  %6d",tp.getSearchCount());
							System.out.printf("\nNumber of Deletes  performed  =  %6d",tp.getDeleteCount());
							System.out.print("\n\nPress ENTER to return to menu ...");
							dummy = console.nextLine();
							break;

				case 5:		// toggle case sensitivity for searching/deleting/etc
							tp.toggleCaseSensitivity();
							break;

				case 6 :	// exit
							done = true;
							break;

				default:	// loop around again
							break;
			}


		}
		
		console.close();
		
		System.out.println("\nProgram terminated ...");
	}

}
