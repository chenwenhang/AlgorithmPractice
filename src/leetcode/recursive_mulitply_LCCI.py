class Solution:
    def multiply(self, A: int, B: int) -> int:
        def f(a, b):
            if b == 1:
                return a
            if b == 2:
                return a + a
            m = b // 2
            if b % 2:
                return f(a, m) + f(a, m) + f(a, 1)
            return f(a, m) + f(a, m)

        return f(A, B)
