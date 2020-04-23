package swordPointOffer;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 9:11 4/23/2020
 * @Modified by:
 */
public class Flipdigital {
//    curLen记录当前长度，
//    preLen记录上次翻转后的长度，
//    因为只能翻转1次，所以需要再次翻转时curLen要减去preLen。
    public int reverseBits(int num) {
        int maxLen = 0, preLen = 0, curLen = 0, bits = 32;
        while (bits-- > 0) {
            if ((num & 1) == 0) {
                curLen -= preLen;
                preLen = curLen + 1;
            }
            curLen++;
            maxLen = Math.max(maxLen, curLen);
            num >>= 1;
        }
        return maxLen;
    }
}
