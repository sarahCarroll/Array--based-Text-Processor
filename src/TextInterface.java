/**
 * 
 */
package ie.gmit.java2;

/**
 * @author Sarah Carroll ( G00330821 )
 *
 */

public interface TextInterface {

	public int countOccurences(String s);
	public int getFirstIndex(String s);
	public int getLastIndex(String s);
	public int[] getAllIndices(String s);
	public void delete(String s);
	public void delete(int i);
	
}
