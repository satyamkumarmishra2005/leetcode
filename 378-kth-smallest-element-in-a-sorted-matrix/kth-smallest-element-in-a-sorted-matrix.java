class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        int left = matrix[0][0];

        int right = matrix[n-1][n-1];

        int ans = 0;


        while(left<= right){
            int mid = left + (right-left)/2;

            int lessequal = countlessEqual(matrix, mid ,n);

            if(lessequal>=k){
                ans = mid ;
                right = mid-1;
            }

            else{
                left = mid +1;
            }
        }

        return ans;
        
    }
public int countlessEqual(int[][] matrix, int mid, int n) {
    int count = 0;
    int row = 0;
    int col = n - 1;

    while (row < n && col >= 0) {
        if (matrix[row][col] <= mid) {
            count += (col + 1);   // FIX: use += instead of =
            row++;
        } else {
            col--;
        }
    }

    return count;
}
}