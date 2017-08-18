
README.TXT for TextAnalyser
===========================

Author:		Sarah Carroll
Student ID:	G00330821

This project consists of 3 source files:

TextAnalyser.java - contains main() method which controls the flow of the application.

TextInterface.java - which defines a number of methods that can be implemented by alternate versions of this application.

TextProcessor.java - main class which provides the ability to read text or URL files and provides methods to perform actions on this data.


On initial execution of TextAnalyser it will prompt the user with a menu of options:


     ---- Text Analyser ----

 Copyright © 2016 - Sarah Carroll (G00330821)

 1) Parse a File or URL
 2) Search
 3) Delete
 4) Print Stats
 5) Toggle Case Sensitivity (Current Status=OFF).
 6) Exit

 Select Option: 
 
 
 Option 1 will prompt the user for a filename or an URL. Enter .txt filename from local system
 or of an URL similar to:
 
 http://www.puzzlers.org/pub/wordlists/pocket.txt
 
 Note the string "http:" will cause the program to try and read the file as an URL!
 The data is loaded into an ArrayList in memory as seperate words, delineated by one or more spaces in the source text.
 
 Option 2 allows the resulting file/URL loaded in Option 1 to be searched for specific strings or substrings.
 The case sensitivity of these searches can be controlled by Option 5 which can toggle sensitivity ON/OFF as
 appropriate.
 
 Option 3 takes a string or substring like Option 2 but will remove the strings from the ArrayList in memory. Original file/URL is not affected.
 
 Option 4 prints statistics on the number of words/searches/deletes performed.
 
 Option 5, as previously noted, toggles case sensitivity ON/OFF for searching/deleting.
 
 Option 6 EXITS the program.
 
 =======================
 Sample Usage - Option 1
 =======================
 
 Select Option 1 to load file/URL:
 
 Please enter .txt filename of BOOK or URL to load: http://www.puzzlers.org/pub/wordlists/pocket.txt

 Text file or URL loaded ... # words = 21110

 Press ENTER to return to menu ...

 =======================
 Sample Usage - Option 2
 =======================

 Select Option 2 to search for a string/substring :

 Please enter string to search for: abandon

 String 'abandon' appears in file : YES

 String 'abandon' appears 2 times!

 String first occurs at: 6

 String last  occurs at: 7


 Press ENTER to return to menu ... 

 =======================
 Sample Usage - Option 3
 =======================

 Select Option 3 to delete a string/substring :

 Please enter string to delete: abandon

 String 'abandon' appears in file : YES

 String 'abandon' appears 2 times!

 All strings for 'abandon' deleted!


 Press ENTER to return to menu ...
 