/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list =binaryMatrix.dimensions();
        int row =list.get(0);
        int col =list.get(1);
        int i=0, j=col-1;
        while(i<row && j>=0){
            if(binaryMatrix.get(i,j)==1){
                j--;
            }else{
                i++;
            }
        }
         return (j == col - 1) ? -1 : j + 1;
    }
}