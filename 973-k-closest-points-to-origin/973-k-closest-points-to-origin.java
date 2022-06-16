class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] results = new int[k][2];
		PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a,b) -> distance(b) - distance(a));

		// loop through each point
		for(int[] point: points) {
			// add the point to the max heap
			maxHeap.add(point);
			// check if the max heap has too many points
			if(maxHeap.size() > k) {
				 maxHeap.remove();
			}
		}

		// add the points from the max heap into the 2-D array
		int size = maxHeap.size();
		for(int i = 0; i < size; i++) {
			results[i] = maxHeap.remove();
		}
		return results;
	}

	// method to calculate the distance 
	private int distance(int[] a) {
		int x = a[0], y = a[1];
		return x*x + y*y;
	}
    
}