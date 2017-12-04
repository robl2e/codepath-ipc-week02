public class SolutionLongestSubstringNoRepeat {
	public int lengthOfLongestSubstring(String a) {
	    if (a == null || a.length() == 0) return 0;
	    
	    int longestStr = 0;
	    
	    // Key is Character and Integer is index of character
	    HashMap<String,Integer> map = new HashMap<String,Integer>();
	    
	    for (int i=0; i < a.length(); i++) {
	        char letter = a.charAt(i);
	        String letterStr = Character.toString(letter);
	        // Repeated character found
	        if (map.containsKey(letterStr)) {
	            // Calculate longest, up to this point
	            int subStrLen = map.size();
	            longestStr = Math.max(longestStr, subStrLen);

                // Reset to location of repeated character            
	            int repeaterIndex = map.get(letterStr);
	            map.clear(); // clear out existing substring
	            i = repeaterIndex; //loop will increment to next letter
	        } else {
	            map.put(letterStr, i);
	        }
	    }
	    
	    int subStrLen = map.size();
	    longestStr = Math.max(longestStr, subStrLen);
	    return longestStr;
	}
}
