# 2.小猫钓鱼的游戏：鸡和鸭玩小猫钓鱼，鸡先出牌，然后鸭出，
# 无牌游戏结束，加入鸡鸭都没有牌了，桌上剩余的牌奇数属于鸡，偶数属于鸭。游戏结束输出鸡鸭各有多少牌
import sys
from typing import List


class Solution:
    def __init__(self, chicken, duck):
        self.table = []
        self.card_list = [
            chicken,
            duck
        ]
        self.money = [
            [],
            []
        ]

    def getRange(self, player):
        if not self.card_list[player]:
            return
        # 获取区间卡牌，并完成放牌尾操作
        card = self.card_list[player].pop(0)
        for i in range(len(self.table)):
            if self.table[i] == card:
                # 加筹码
                self.money[player] += self.table[i:]
                self.money[player].append(card)
                self.table = self.table[0:i]
                # 需要再放一张手牌到排位
                self.getRange(player)
                return
        # 放一张手牌到排位
        self.table.append(card)

    def getMoney(self):
        # print(self.money[0])
        # print(self.money[1])
        m = [len(self.money[0]), len(self.money[1])]
        for c in self.table:
            if c % 2 == 0:
                m[1] += 1
            else:
                m[0] += 1
        return [m[0], m[1]]

    def game(self):
        while self.card_list[0] and self.card_list[1]:
            self.getRange(0)
            self.getRange(1)
        while self.card_list[0]:
            self.getRange(0)
        while self.card_list[1]:
            self.getRange(1)
        # print(self.table)
        # print(self.card_list)
        # print(self.money)
        arrrr = self.getMoney()
        print(" ".join(list(map(str, arrrr))))


if __name__ == "__main__":
    flag = False
    # 读取第一行的n
    n = int(sys.stdin.readline().strip())

    table = []

    line = sys.stdin.readline().strip()
    chicken = list(map(int, line.split()))

    line = sys.stdin.readline().strip()
    duck = list(map(int, line.split()))

    sol = Solution(chicken, duck)
    sol.game()
