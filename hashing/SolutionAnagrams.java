public class Solution {
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	    // key: sorted word, values: index
	    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
	    
	    // Store words in map
	    for (int i=0; i < a.size(); i++) {
	        String word = a.get(i);
	        String sortedWord = sortWord(word);

        ArrayList<Integer> indexes = new ArrayList<>();
	        if (map.containsKey(sortedWord)) {
	           indexes = map.get(sortedWord);
	        } else {
	           indexes = new ArrayList<>();
	        }
            indexes.add(i+1);   
	        map.put(sortedWord, indexes);
	    }
	    
	    for (ArrayList<Integer> indexes : map.values()) {
	        result.add(indexes); 
	    }
        return result;	    
	}
	
	public static String sortWord(String word) {
	    char[] charArray = word.toCharArray();
	    Arrays.sort(charArray);
	    String sorted = new String(charArray);
	    return sorted;
	}
}
