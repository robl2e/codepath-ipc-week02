public class Solution {
	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
	    if (a.isEmpty() || b.isEmpty()) return 0;
	    if (a.size() == 1 && b.size() == 1) return 1;
	    
	    int maxNum = 0; // if more than one point two points form line
	    
	    HashMap<Double, Integer> slopeMap = new HashMap<>();
	    
	    int numCoord = a.size();
	    // (1 0) (1 4) (1 -1)
	   for (int i = 0; i < numCoord; i++) {
	        int duplicate = 1;
	        int vertical = 0;
	        
	        int x1 = a.get(i); // 1
	        int y1 = b.get(i); // 0
	        
	        for (int j=i+1; j < numCoord; j++) {
	            int x2 = a.get(j); // 1
	            int y2 = b.get(j); // -1
	            
	           if(x1 == x2){
                    if(y1 == y2){
                        duplicate++;
                    } else {
                        vertical++;
                    }
                } else {
    	            double m = calcSlope(x1,y1,x2,y2);
    	            Integer count = 0;
    	            if (slopeMap.containsKey(m)) {
    	                count = slopeMap.get(m);
    	                count++;
    	            } else {
    	                count = 1;
    	            }
    	            slopeMap.put(m, count);
	            }
	        }
	        
	       for(Integer count : slopeMap.values()) {
                maxNum = Math.max(maxNum, count+duplicate);
            }
            maxNum = Math.max(vertical+duplicate, maxNum);
            slopeMap.clear();
	   }
	    return maxNum;
	}
	
	// m = (y2 - y1) / (x2 - x1);
	// 1 0, 1 -1
	public static double calcSlope(int x1, int y1, int x2, int y2) {
	    if (y2 == y1) return 0.0;
	    
	    double numerator = (1.0 * (y2 - y1));
	    double denominator = x2 - x1;

	    return numerator / denominator;
	}
}
