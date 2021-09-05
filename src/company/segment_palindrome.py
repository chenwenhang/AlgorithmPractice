# 分割段式回文串
# 题目描述：段式回文类似于回文，最小的单位可以是多个字符而不仅是单个字母
# 例如：一般的回文字符串形式如“level、noon、civic”，而“gotogo”不是，
# 但如果我们把“gotogo”分为“go”、“to”、“go”三段，
# 则可以认为“go to go”是段式回文,给定一个字符串s(s仅由小写英文字母组成，且s长度＜＝30),
# 请将s分割成一些子串，使每个子串都是段式回文。返回s所有可能的分割方案的个数例如gotogo,可有6种分隔方案，
# 即：［g,o,t,o,g,o],[g,o,t,ogo],[g,oto,g,o],[g,otogo],［gotog,o] , [gotogo]
from typing import List


# 时间复杂度过高，字符串长了会超时
class Solution:
    def __init__(self):
        self.cnt = 0

    def partition(self, s: str) -> List[List[str]]:
        self.cnt = 0
        result = []
        path = []

        def is_palindromic(s: str) -> bool:
            # 判断段式回文，满足以下其一即可:
            # 1. 首个和最后一个字符相同
            # 2. 前几个和最后几个元素相同
            if s[0] == s[-1]:
                return True
            else:
                mid = len(s) // 2
                for i in range(1, mid):
                    if s[0:i] == s[len(s) - i: len(s)]:
                        return True
                return False

        # 回溯函数，这里的index作为遍历到的索引位置，也作为终止判断的条件
        def back_track(s, index):
            # 如果对整个字符串遍历完成，并且走到了这一步，则直接加入result
            if index == len(s):
                result.append(path[:])
                self.cnt += 1
                return
            # 遍历每个子串
            for i in range(index, len(s)):
                # 剪枝，因为要求每个元素都是回文串，那么我们只对回文串进行递归，不是回文串的部分直接不care它
                # 当前子串是回文串
                if is_palindromic(s[index: i + 1]):
                    # 加入当前子串到path
                    path.append(s[index: i + 1])
                    back_track(s, i + 1)
                    path.pop()

        back_track(s, 0)
        print(result)
        return result

    def partitionNumber(self, text: str):
        self.partition(text)
        return self.cnt


sol = Solution()
print(sol.partitionNumber("gotogo"))
print(sol.partitionNumber("g"))
print(sol.partitionNumber("go"))
print(sol.partitionNumber("gog"))
print(sol.partitionNumber("tob"))
print(sol.partitionNumber("ttoo"))
print(sol.partitionNumber("ttot"))
print(sol.partitionNumber("22"))
print(sol.partitionNumber("11111111111111111111111111111"))
