package array_and_matrix;

/**
 * @Author: Wenhang Chen
 * @Description:假设我们以下述方式将我们的文件系统抽象成一个字符串: 字符串 "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" 表示:
 * <p>
 * dir
 * subdir1
 * subdir2
 * file.ext
 * 目录 dir 包含一个空的子目录 subdir1 和一个包含一个文件 file.ext 的子目录 subdir2 。
 * <p>
 * 字符串 "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" 表示:
 * <p>
 * dir
 * subdir1
 * file1.ext
 * subsubdir1
 * subdir2
 * subsubdir2
 * file2.ext
 * 目录 dir 包含两个子目录 subdir1 和 subdir2。 subdir1 包含一个文件 file1.ext 和一个空的二级子目录 subsubdir1。subdir2 包含一个二级子目录 subsubdir2 ，其中包含一个文件 file2.ext。
 * <p>
 * 我们致力于寻找我们文件系统中文件的最长 (按字符的数量统计) 绝对路径。例如，在上述的第二个例子中，最长路径为 "dir/subdir2/subsubdir2/file2.ext"，其长度为 32 (不包含双引号)。
 * <p>
 * 给定一个以上述格式表示文件系统的字符串，返回文件系统中文件的最长绝对路径的长度。 如果系统中没有文件，返回 0。
 * <p>
 * 说明:
 * <p>
 * 文件名至少存在一个 . 和一个扩展名。
 * 目录或者子目录的名字不能包含 .。
 * 要求时间复杂度为 O(n) ，其中 n 是输入字符串的大小。
 * <p>
 * 请注意，如果存在路径 aaaaaaaaaaaaaaaaaaaaa/sth.png 的话，那么  a/aa/aaa/file1.txt 就不是一个最长的路径。
 * @Date: Created in 8:25 7/2/2020
 * @Modified by:
 */
public class MaxPathLengthOfFile {
    public int lengthLongestPath(String input) {
        if (input.length() == 0) {
            return 0;
        }
        int res = 0;
        int[] sum = new int[input.length() + 1];    //从1开始，第0层就是0

        for (String s : input.split("\n")) {
            int level = s.lastIndexOf('\t') + 2;    // 计算当前在第几层（从第一层开始，没有\t就是第一层）
            int len = s.length() - (level - 1);     // 计算当前这一行的长度
            if (s.contains(".")) {
                res = Math.max(res, sum[level - 1] + len);
            } else {
                sum[level] = sum[level - 1] + len + 1;  //是目录，要+1，目录有个/的
            }
        }
        return res;
    }

}





















