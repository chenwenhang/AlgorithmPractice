package swordPointOffer;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 21:04 5/2/2020
 * @Modified by:
 */
public class NumberOfOddaluedCells {
//    奇 偶的加减可以转变成boolean的true 和 false
//    行列的加减可以统一用两个数组解决
//    最后根据公式（规律）来得出奇偶的数量
//    最后得到的是rr * m + cc * n - rr * cc * 2，原本行列奇数的数量相加为rr * m + cc * n - rr * cc，但是当行列同时为奇数时，重叠部分就成了偶数了。
//
//    所以 最后的结果是rr * m + cc * n - rr * cc * 2

    public int oddCells(int n, int m, int[][] indices) {
        boolean[] r = new boolean[n];
        boolean[] c = new boolean[m];

        for (int i = 0; i < indices.length; i++) {
            r[indices[i][0]] = !r[indices[i][0]];
            c[indices[i][1]] = !c[indices[i][1]];
        }

        int rr = 0, cc = 0;
        for (int i = 0; i < r.length; i++) {
            if (r[i]) rr++;
        }

        for (int i = 0; i < c.length; i++) {
            if (c[i]) cc++;
        }

        return rr * m + cc * n - rr * cc * 2;
    }
}
