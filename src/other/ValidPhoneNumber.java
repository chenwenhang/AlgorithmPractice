package other;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个包含电话号码列表（一行一个电话号码）的文本文件 file.txt，写一个 bash 脚本输出所有有效的电话号码。
 * <p>
 * 你可以假设一个有效的电话号码必须满足以下两种格式： (xxx) xxx-xxxx 或 xxx-xxx-xxxx。（x 表示一个数字）
 * <p>
 * 你也可以假设每行前后没有多余的空格字符。
 * <p>
 * 示例:
 * <p>
 * 假设 file.txt 内容如下：
 * <p>
 * 987-123-4567
 * 123 456 7890
 * (123) 456-7890
 * 你的脚本应当输出下列有效的电话号码：
 * <p>
 * 987-123-4567
 * (123) 456-7890
 * @Date: Created in 9:48 5/22/2020
 * @Modified by:
 */
public class ValidPhoneNumber {
    public static void main(String args[]) {
        isPhoneValid("13877889900");
        isPhoneValid("184-585-4009");
        isPhoneValid("13977889900");
        isPhoneValid("12345678900");
        isPhoneValid("1.999-585-4009");
        isPhoneValid("089812399312");
        isPhoneValid("1 585 4009");
        isPhoneValid("136-myphone123");
        isPhoneValid("17789722552");
    }

    public static boolean isPhoneValid(String phone) {
        boolean retval = false;
        String phoneNumberPattern = "^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\\d{8})?$";
        retval = phone.matches(phoneNumberPattern);
        String msg = "No, pattern:" + phone + " regex: " + phoneNumberPattern;
        if (retval) {
            msg = "Yes, pattern:" + phone + " regex: " + phoneNumberPattern;
        }
        System.out.println(msg);
        return retval;
    }

}




















