class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mindx = m-1;
        int nindx = n-1;

        int right = m+n-1;

        while(nindx>=0){
            if(mindx>=0 && nums1[mindx]> nums2[nindx]){
                nums1[right] = nums1[mindx];
                mindx--;
            }
            else{
                nums1[right] = nums2[nindx];
                nindx--;
            }

            right--;
        }
    }
}

//Step by Step Algorithm
// 1. Initialize Pointers
// midx: Points to the last element in the meaningful part of nums1 (i.e., m - 1).
// nidx: Points to the last element in nums2 (i.e., n - 1).
// right: Points to the last index in nums1 (i.e., m + n - 1).
// midx = m - 1
// nidx = n - 1 
// right = m + n - 1
// 2. Iterate While nidx is Non-Negative
// The loop continues until all elements from nums2 have been merged into nums1.
// while nidx >= 0:
// 3. Compare Elements and Merge
// If midx is non-negative and the element at nums1[midx] is greater than nums2[nidx], place nums1[midx] at nums1[right], then decrement midx.
// if midx >= 0 and nums1[midx] > nums2[nidx]:
//     nums1[right] = nums1[midx]
//     midx -= 1
// Otherwise, place nums2[nidx] at nums1[right], then decrement nidx.
// else:
//     nums1[right] = nums2[nidx]
//     nidx -= 1
// 4. Move the right Pointer Left
// After each placement, decrement the right pointer to move to the next position.
// right -= 1
// 5. End of Loop
// The loop ends when all elements from nums2 have been placed into nums1. If any elements remain in nums1, they are already in the correct position, so no further action is needed.