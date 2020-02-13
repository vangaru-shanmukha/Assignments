package spelling;

import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size;
    

    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should convert the 
	 * string to all lower case before you insert it. 
	 * 
	 * This method adds a word by creating and linking the necessary trie nodes 
	 * into the trie, as described outlined in the videos for this week. It 
	 * should appropriately use existing nodes in the trie, only creating new 
	 * nodes when necessary. E.g. If the word "no" is already in the trie, 
	 * then adding the word "now" would add only one additional node 
	 * (for the 'w').
	 * 
	 * @return true if the word was successfully added or false if it already exists
	 * in the dictionary.
	 */
	public boolean addWord(String word)
	{
		word = word.toLowerCase();
		TrieNode head = root;
		for(int i=0;i<word.length();i++)
		{
			char c = word.charAt(i);
			if(head.getValidNextCharacters().contains(c))
				head = head.getChild(c);
			else
				head = head.insert(c);
		}
		if(!head.endsWord())
		{
			head.setEndsWord(true);
			size++;
			return true;
		}
	    return false;
	}
	
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    return size;
	}
	
	
	/** Returns whether the string is a word in the trie, using the algorithm
	 * described in the videos for this week. */
	@Override
	public boolean isWord(String s) 
	{
		int i=0;
		s = s.toLowerCase();
		TrieNode node = root;
		while(i < s.length())
		{
			char c = s.charAt(i);
			if(node.getValidNextCharacters().contains(c))
				node = node.getChild(c);
			else
				return false;
			i++;
		}
		if(node.endsWord())
			return true;
		return false;
	}

	/** 
     * Return a list, in order of increasing (non-decreasing) word length,
     * containing the numCompletions shortest legal completions 
     * of the prefix string. All legal completions must be valid words in the 
     * dictionary. If the prefix itself is a valid word, it is included 
     * in the list of returned words. 
     * 
     * The list of completions must contain 
     * all of the shortest completions, but when there are ties, it may break 
     * them in any order. For example, if there the prefix string is "ste" and 
     * only the words "step", "stem", "stew", "steer" and "steep" are in the 
     * dictionary, when the user asks for 4 completions, the list must include 
     * "step", "stem" and "stew", but may include either the word 
     * "steer" or "steep".
     * 
     * If this string prefix is not in the trie, it returns an empty list.
     * 
     * @param prefix The text to use at the word stem
     * @param numCompletions The maximum number of predictions desired.
     * @return A list containing the up to numCompletions best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 List<String> predictions = new LinkedList<String>();
    	 int i=0;
    	 prefix = prefix.toLowerCase();
 		 TrieNode node = root;
 		 while(i < prefix.length())
 		 {
 			 char c = prefix.charAt(i);
 			 if(node.getValidNextCharacters().contains(c))
 				 node = node.getChild(c);
 			 else
 				 return predictions;
 			 i++;
 		 }
 		 if(node.endsWord())
 			 predictions.add(node.getText());
 		 Queue<TrieNode> queue = new LinkedList<TrieNode>();
 		 Set<Character> characters = node.getValidNextCharacters();
		 for(Character character : characters)
			 queue.add(node.getChild(character));
 		 while(!queue.isEmpty() && predictions.size() < numCompletions)
 		 {
 			 TrieNode word = queue.poll();
 			 if(word.endsWord())
 				 predictions.add(word.getText());
 			 characters = word.getValidNextCharacters();
 			 for(Character character : characters)
 				 queue.add(word.getChild(character));
 		 }
 		 return predictions;
     }

 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	

	
}