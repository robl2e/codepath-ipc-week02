public class SolutionDiffKII {
    public static final int TRUE = 1;
    public static final int FALSE = 0;
    
	public int diffPossible(final List<Integer> a, int b) {
	    if (a == null || a.isEmpty()) return FALSE;
	    
	    HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
	    
	    // Store values in map ask key with index as value
	    for (int i = 0; i < a.size(); i++) {
	        int ai = a.get(i);
            map.put(ai, i);
	    }
	    
	    for (int i = 0; i < a.size(); i++) {
	        int ai = a.get(i);

            // i - j = k
            // j = i - k	        
	        int aj = ai - b;
	        
	        
	        Integer num = map.get(aj);
	        // Exists and not same index
	        if (num != null && num != i) {
	            return TRUE;
	        }
	    }
	    return FALSE;
	}
}