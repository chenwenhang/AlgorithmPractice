package swordPointOffer;

/**
 * @Author: Wenhang Chen
 * @Description:下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。 示例1:
 * <p>
 * 输入：num = 2（或者0b10）
 * 输出：[4, 1] 或者（[0b100, 0b1]）
 * 示例2:
 * <p>
 * 输入：num = 1
 * 输出：[2, -1]
 * 提示:
 * <p>
 * num的范围在[1, 2147483647]之间；
 * 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
 * @Date: Created in 10:11 4/28/2020
 * @Modified by:
 */
public class NextNum {
    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    // 在高位多加一个0
    private char[] toBinaryCharArr(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num & 1);
            num >>>= 1;
        }

        sb.append('0');
        return sb.reverse().toString().toCharArray();
    }

    private long binaryCharArrToLong(char[] arr) {
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans <<= 1;
            ans += arr[i] - '0';
        }

        return ans;
    }

    public int[] findClosedNumbers(int num) {
        if (num == 1) {
            return new int[]{2, -1};
        }

        int[] ans = new int[]{-1, -1};

        // 找小的就是从低位到高位遍历二进制，找到1（右侧是0），然后与右边的0进行交换，同时，将遍历过的低位进行反转
        // 找大的就是从低位到高位遍历二进制，找到1（左侧是0），然后与左侧的0进行交换，同时，将遍历过的低位进行反转
        char[] arr = Integer.toBinaryString(num).toCharArray();
        int len = arr.length;

        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] == '1' && arr[i + 1] == '0') {
                swap(arr, i, i + 1);
                reverse(arr, i + 2, len - 1);
                break;
            }
        }

        ans[1] = (int) binaryCharArrToLong(arr);

        arr = toBinaryCharArr(num);
        len = arr.length;
        for (int i = len - 1; i >= 1; i--) {
            if (arr[i] == '1' && arr[i - 1] == '0') {
                swap(arr, i, i - 1);
                reverse(arr, i + 1, len - 1);
                break;
            }
        }

        long bigger = binaryCharArrToLong(arr);
        if (bigger <= Integer.MAX_VALUE) {
            ans[0] = (int) bigger;
        }

        return ans;
    }
}















