/**
 * 
 * @author Christopher Marek
 * Student Number: 251034808
 * Course: Comp Sci 1027b
 * Assignment 4
 * 
 *  This class finds if any of the words in the input files
 *  are inside the Binary Search Tree
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Searcher {

	/**
	*  this is a reference to the table of binary search trees that implements
	*  the lexicon data structure
	*/
	private HashTable table;
	
	/**
	*   this is the name of the input file storing all words that will be searched
	*   for in the lexicon data structure
	*/
	private String inputFile;
	
	/**
	 * Recieves the Hash Table and the input file path
	 * and stores them in their corressponding instance variables
	 * @param filename
	 * @param HashTable
	 */
	public Searcher(HashTable wordHashTable, String theTestFile) {
		this.table = wordHashTable;
		this.inputFile = theTestFile;
	}
	
	/**
	 * 	This method reads the input file and for each word w in it invokes below method findWord to
	 *	look for the word w in the lexicon and print information about where the word appears in the
	 *  collection of text files that compose the lexicon.
	 *  
	 */
	public void findAllWords() throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader(inputFile));
		String line = in.readLine();
				
		while(line != null) {
			
			String[] words = line.split(" ");
			
			for(String word : words) {
				findWord(word);
			}
			line = in.readLine();
		}
		
		in.close();
	}
	
	/**
	 * This method looks for the searchWord inside
	 * of the Lexicon
	 * @param searchWord
	 */
	public void findWord(String searchWord) {
		
		int j = this.table.computeIndex(searchWord);
		BinSearchTreeNode wordNode = this.table.getTable()[j].getWord(searchWord);
		
		if(wordNode != null) {
			CustomPrinter.wordFound(searchWord, this.inputFile);
			
			LinkedList files = wordNode.getFiles();
			for(FileNode file : files) {
				CustomPrinter.printPositionsPerFileFound(file.getFilename(), file.getPositions(), this.inputFile);
			}
			
		}else {
			CustomPrinter.wordNotFound(searchWord, this.inputFile);
		}
	}



}
