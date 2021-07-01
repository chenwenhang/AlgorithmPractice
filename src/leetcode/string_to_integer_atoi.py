import re


class Solution:
    def myAtoi(self, s: str) -> int:
        return max(min(int(*re.findall(r"^[+-]?\d+", s.lstrip())), 2 ** 31 - 1), -2 ** 31)
