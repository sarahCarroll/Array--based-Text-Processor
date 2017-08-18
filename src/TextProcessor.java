package ie.gmit.java2;

/**
 * @author Sarah Carroll ( G00330821 )
 *
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.*;

public class TextProcessor implements TextInterface{

	private List<String> txtContents;		// ArrayList of words
	private boolean fileLoaded;				// File/URL loaded
	private boolean caseSensitive;			// Boolean flag to control case sensitive searching, etc
	private int originalCount;				// Original Word Count when file/URL initially loaded.
	private int searchCount;				// Search count statistics
	private int deleteCount;				// Delete count statistics

	public TextProcessor() {
		//Constructor - Initialize various private properties
		txtContents = new ArrayList<String>();
		fileLoaded = false;
		caseSensitive = false;
		originalCount = 0;
		searchCount = 0;
		deleteCount = 0;
	}

	public boolean contains(String	s) {
		// return true if word contains string in array
		searchCount++;

		if(caseSensitive) {							// case sensitive search
			for(int i=0;i<txtContents.size(); i++){
				if(txtContents.get(i).contains(s))
					return true;
			}
		} else {
			String search = s.toLowerCase();		// Case insensitive search

			for(int i=0;i<txtContents.size(); i++){
				if(txtContents.get(i).toLowerCase().contains(search))
					return true;
			}
		}

		return false;
	}

	public int getOriginalCount() {
		// return number of original entries in array (as read from book/URL)
		return originalCount;
	}

	public int getSearchCount() {
		// return number of searches performed during this run of application
		return searchCount;
	}

	public int getDeleteCount() {
		// return number of deletes performed during this run of application
		return deleteCount;
	}

	public int count() {
		// return number of entries in ArrayList
		return txtContents.size();
	}

	
	// TextInterface Methods
	
	public int countOccurences(String s) {
		//this counts all occurrences of specified string in array
		int count = 0;
		String search = s.toLowerCase();

		if(caseSensitive) {
			for (int i=0;i<txtContents.size(); i++){
				if(txtContents.get(i).contains(s))
					count++;
			}
		} else {
			for (int i=0;i<txtContents.size(); i++){
				if(txtContents.get(i).toLowerCase().contains(search))
					count++;
			}
		}

		return count;
	}


	public int getFirstIndex(String s) {
		// return index of first occurrence of specified string in array
		
		searchCount++;

		if(caseSensitive) {
			for (int i=0;i<txtContents.size(); i++){
				if(txtContents.get(i).contains(s))
					return i;
			}
		} else {
			String search = s.toLowerCase();
			for (int i=0;i<txtContents.size(); i++){
				if(txtContents.get(i).toLowerCase().contains(search))
					return i;
			}
		}
		return -1;
	}

	public int getLastIndex(String s) {
		// return index of last occurrence of specified string in array
		
		searchCount++;

		if(caseSensitive) {
			for (int i=txtContents.size()-1;i>=0; i--){
				if(txtContents.get(i).contains(s))
					return i;
			}
		} else {
			String search = s.toLowerCase();
			for (int i=txtContents.size()-1;i>=0; i--){
				if(txtContents.get(i).toLowerCase().contains(search))
					return i;
			}
		}

		return -1;
	}

	public int[] getAllIndices(String s) {
		// return int array of the indices of all occurrences of s in array (in reverse order).
		// reverse order is used so delete method can remove higher numbered occurences and maintain correct
		// lower number ordering. int[] array can be read backwards, if required, for forward processing.
		int kount = countOccurences(s);
		int[] indices = new int[kount];
		String search = s.toLowerCase();

		if(caseSensitive) {
			for (int i=0;i<txtContents.size(); i++){
				if(txtContents.get(i).contains(s)) {
					indices[kount-1] = i;
					kount--;
				}
			}
		} else {
			for (int i=0;i<txtContents.size(); i++){
				if(txtContents.get(i).toLowerCase().contains(search)) {
					indices[kount-1] = i;
					kount--;
				}
			}
		}

		return indices;
	}

	public void delete(String s) {
		//delete all occurrence of specific string from array
		// int[] array 'all' contains arrayList items in descending order number as provided by getAllIndices
		int[] all = getAllIndices(s);

		for(int i=0;i<all.length;i++) {
			delete(all[i]);
		}
	}

	public void delete(int i) {
		//delete specific string at given index in array
		deleteCount++;
		txtContents.remove(i);
	}

	public boolean readFile(String filename) {

		//buffer reader.
		BufferedReader br = null;

		// This reads files off local system or via Internet
		if(filename.contains("http:")) {	// is it web address?
			try {
				br = new BufferedReader(new InputStreamReader(new URL(filename).openConnection().getInputStream()));		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {	
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		//file reader
		try {

			//work with string to read lines of text
			String s =null;
			while ((s = br.readLine()) != null) {

				//using split method from string class
				//to split string on white space
				// \s+ - pattern \s looks for white space
				// the + means 1 or more instances  of the pattern
				String [] sa = s.split("\\s+");

				txtContents.addAll(Arrays.asList(sa));
				fileLoaded = true;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		originalCount = count();
		return true;

	}

	public void toggleCaseSensitivity() {
		//Toggle case sensitivity flag from true to false or vice versa
		caseSensitive = (caseSensitive==true?false:true);
	}

	public int displayMenu() {
		// display main menu and get user entered option

		String COPYRIGHT = "\u00a9";

		Scanner console=new Scanner(System.in);

		System.out.println("\n     ---- Text Analyser ----");
		System.out.println("\n Copyright "+COPYRIGHT+" 2016 - Sarah Carroll\n");
		System.out.println(" 1) Parse a File or URL");
		System.out.println(" 2) Search");
		System.out.println(" 3) Delete");
		System.out.println(" 4) Print Stats");
		System.out.println(" 5) Toggle Case Sensitivity (Current Status="+(caseSensitive==true?"ON":"OFF")+").");
		System.out.println(" 6) Exit");
		System.out.print("\n Select Option: ");

		return console.nextInt();		// prompt for user input

	}


}
