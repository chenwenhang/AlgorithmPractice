class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        max_len = 0
        start = 0
        end = start
        alp = [False for _ in range(200)]
        while end < len(s):
            # print("({},{})".format(start, end))
            if not alp[ord(s[end])]:
                alp[ord(s[end])] = True
                end += 1
                max_len = max_len if max_len > end - start else end - start
            else:
                while s[start] != s[end]:
                    alp[ord(s[start])] = False
                    start += 1
                start += 1
                end += 1
        return max_len
