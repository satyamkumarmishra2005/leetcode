class Solution {
    public int[][] generateMatrix(int n) {
        int arr[][] = new int [n][n];
        int num = 1;
        int top = 0 ,bottom = n-1, left = 0 , right = n-1;

        while(top<=bottom && left<= right){
      for(int i = left ;i<=right; i++){
          arr[top][i]= num++;
      }
      top++;

      for(int i = top; i<=bottom; i++){
          arr[i][right] = num++;
      }
right--;

if(top<=bottom){
    for(int i = right ; i>=left ; i--){
        arr[bottom][i]= num++;
    }
bottom--;
}

if(left<=right){
    for(int i = bottom; i>= top ; i--){
arr[i][left] = num++;
    }
   left++;
}
//top++;
//right--;
//left++;
//bottom--;
   }
        return arr;
    }
}