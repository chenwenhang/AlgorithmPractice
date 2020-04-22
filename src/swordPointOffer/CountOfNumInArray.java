package swordPointOffer;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 18:55 4/22/2020
 * @Modified by:
 */
public class CountOfNumInArray {
    public int[] singleNumbers(int[] nums) {
//        本例中，这个数组中有两个数字只出现一次，剩下的数字都是出现两次的。如何找到这两个只出现一次的数字。
//        答：同样将整个数组异或，异或之后，得到一个数字，这个数字从二进制数的角度看，一定有位数为1。
//        这个1是怎么来的？就是那两个只出现一次的数字，异或得到的，他们对应的位不一样，肯定是一个数对应位数出现的是0，另一个数字对应位置上出现的数字是1.据此，将这个数组分成两个部分。
//        一部分是，对应位置出现的数是0的数组
//        一部分是，对应位置出现的数是1的数组
//        这样，整个数据就分成了两个数组，且这两个数组的特点是，数组中只有1个数只出现了一次。因此就可以求出那两个数字。

//        xorNumber为对整个数组求异或，用于求出分组条件。
//        onePosition表示最低位1的位置的数，n&-n是求一个二进制数的最低位的1对应的数。（除其所在最低位为1，其他位为0的一个数）
//        参考链接：https://blog.csdn.net/o_ohello/article/details/86663613
//        最后利用onePosition作为划分条件，将数组分成两个数组，最终求得ans1与ans2的值。
//        因为ans1与ans2的初始值为0，最终结果也应当异或一下0，不过由于0异或任何数都是，其本身，因此有没有都可以。
        int xorNumber = nums[0];
        for (int k = 1; k < nums.length; k++) {
            xorNumber ^= nums[k];
        }
        int onePosition = xorNumber & (-xorNumber);
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & onePosition) == onePosition) {
                ans1 ^= nums[i];
            } else {
                ans2 ^= nums[i];
            }
        }

        return new int[]{ans1 ^ 0, ans2 ^ 0};
    }
}
