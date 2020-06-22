package array_and_matrix;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * <p>
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * <p>
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * @Date: Created in 21:01 6/22/2020
 * @Modified by:
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) return false;
        if (A[0] >= A[1]) return false;
        int i, j;
        for (i = 1; i < A.length; i++) { //前[0, i - 1]个数递增
            if (A[i] <= A[i - 1]) {
                break;
            }
        }
        for (j = i; j < A.length; j++) { // [i ,A.length]递减
            if (A[j] >= A[j - 1]) {
                return false;
            }
        }
        return j > i && i > 1;
    }
}
























