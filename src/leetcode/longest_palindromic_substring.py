class Solution:
    def longestPalindrome(self, s: str) -> str:
        max_str = ""

        # 奇数个时
        for i in range(len(s)):
            j = 0
            while i - j >= 0 and i + j < len(s):
                if s[i - j] == s[i + j]:
                    max_str = max_str if len(max_str) >= j * 2 + 1 else s[i - j:i + j + 1]
                else:
                    break
                j += 1

        # 偶数个时
        for i in range(len(s)):
            j = 1
            while i - j + 1 >= 0 and i + j < len(s):
                if s[i - j + 1] == s[i + j]:
                    max_str = max_str if len(max_str) >= j * 2 else s[i - j + 1:i + j + 1]
                else:
                    break
                j += 1

        return max_str
