class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
      return true;
    }

    long left =2, right = num/2, guess=0;
    
    while(left<=right){
        long mid = left+(right-left) / 2;
        guess = mid*mid;
        if(guess==num)return true;
        else if(guess > num){
            right =mid-1;
        }else{
            left =mid+1;
        }
    }
        return false;
  }
}