class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;
        int half = (total + 1) / 2; // # of els in the 1st half (+1 if odd)

        if (A.length > B.length) { // we move the i in the left array, so that
                                    // the half inv keeps stable
            int[] t = A;
            A = B;
            B = t;
        }

        int l = 0;
        int r = A.length; // r is the # of the elements 
        while (l <= r) {
            int i = l + (r - l) / 2; // i is the # of the left side elements for A
            int j = half - i; // for B
            System.out.println("l: " + l + " r: " + r + " i: " + i + " j: " + j);
            
            int Aleft = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;

            if (Math.max(Aleft, Bleft) <= Math.min(Aright, Bright)) {
                if (total % 2 != 0) {
                    return Math.max(Aleft, Bleft);
                }
                else return (double)(Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2;
            }

            else if (Aleft > Bright) {
                r = i - 1;
            }

            else l = i + 1;
            
        }
        return -1;
    }
}
