# Lisa喜欢字符串，尤其是长字符串。对于每个字符串，
# 她都有专门的评价体系来判断字符串的优雅程度。
# 她定义一个字符串S[1..3n-2](n≥2)是一个半回文当且仅
# 当它满足S[i]=S[2n-i]=S[2n+i-2](1≤i≤n).例如dfgfdfg是一个半回文串，
# 而dfgjfdfgj不是。现在，Lisa生成了一些长字符串。她请求你帮助找出有多少个半回文子串。

class Solution:
    def solution(self, n: int, s: str):
        cnt = 0
        for i in range(len(s)):
            ls = [[n, i + 3 * n - 2] for n in range(2, len(s)) if i + 3 * n - 2 <= len(s)]
            for n, j in ls:
                tmp = "_" + s[i:j]
                for k in range(1, n + 1):
                    if 2 * n - k < len(tmp) \
                            and 2 * n + k - 2 < len(tmp) \
                            and not tmp[k] == tmp[2 * n - k] == tmp[2 * n + k - 2]:
                        break
                else:
                    cnt += 1
        return cnt


sol = Solution()
print(sol.solution(1, "cdcdsdcdscbaabc"))
