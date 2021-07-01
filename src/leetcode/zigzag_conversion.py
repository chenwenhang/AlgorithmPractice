class Solution:
    def convert(self, s: str, numRows: int) -> str:
        pos = 0
        res = [""] * numRows
        if numRows == 1:
            return s
        while pos < len(s):
            i = 0
            while pos < len(s) and i < numRows - 1:
                # print("{},{}".format(i, res[i]))
                res[i] += s[pos]
                i += 1
                pos += 1
            while pos < len(s) and i > 0:
                # print("{},{}".format(i, res[i]))
                res[i] += s[pos]
                i -= 1
                pos += 1
        # print(res)
        # print(''.join(res))
        return ''.join(res)


sol = Solution()
sol.convert("AB", 2)
sol.convert("A", 1)
