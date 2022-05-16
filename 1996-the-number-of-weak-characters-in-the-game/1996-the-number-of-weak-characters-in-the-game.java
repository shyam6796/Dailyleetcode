class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
        Arrays.sort(properties, (a, b) -> {
            return (a[0] != b[0]) ? b[0] - a[0] : a[1] - b[1];
    });
    
    int weakCharsCount = 0;
    int mmax = 0;
    
    for (int i = 0; i < properties.length; i++) {
        if(properties[i][1] < mmax) 
            weakCharsCount++;
        
        mmax = Math.max(mmax, properties[i][1]);
    }
    
    return weakCharsCount;
        
    }
}