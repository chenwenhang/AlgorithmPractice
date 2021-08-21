# L[i]表示26个字母a-z,依次是：L[1]="a" L[2]="b" L[3]="c" …… L[26]="z"
# S[1]="a"
# 当i>1时，S[i]=S[i-1]+L[i]+reverse(invert(S[i-1])),
# 其中＋表示字符串的连接操作，reverse(x)返回反转x后得到的字符串，
# 而invert(x)则会翻转x中的每一位（例如：＇a'翻转为＇z','b'翻转为＇y',. . . 而＇z'翻转为＇a').
# 例如，符合上述描述的序列的前4个字符串依次是：
# S1="a"
# S2="abz"
# S3="abzcayz"
# S4="abzcayzdabzxayz"
# 请你返回Sn的第k位字符，题目数据保证k一定在Sn长度范围以内。

class Solution:
    def invert(self, x: str) -> str:
        res = ""
        for s in x:
            res += chr(219 - ord(s))
        return res

    def caculate_k_pos(self, n: int, k: int) -> str:
        if k == 1:
            return "a"
        L = [chr(letter) for letter in range(97, 123)]
        L.insert(0, "")
        s_pre = "a"
        idx = 2
        s_cur = None
        for i in range(2, n + 1):
            s_cur = s_pre + L[idx] + self.invert(s_pre)[::-1]
            s_pre = s_cur
            idx += 1
        return s_cur[k - 1]


sol = Solution()
sol.caculate_k_pos(2, 1)
sol.caculate_k_pos(3, 1)
sol.caculate_k_pos(4, 1)
sol.caculate_k_pos(5, 1)
# print(s[::-1])
