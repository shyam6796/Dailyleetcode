/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int a=rand7(),b=rand7();
        while(a>5)a=rand7();
        while(b==7)b=rand7();
        
        return  (b<4) ? a : a+5;
    }
}