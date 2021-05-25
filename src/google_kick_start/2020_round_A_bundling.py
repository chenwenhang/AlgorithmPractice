"""
Bundling
https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc7/00000000001d3ff3

Problem
Pip has N strings. Each string consists only of letters from A to Z. Pip would like to bundle their strings into groups of size K. Each string must belong to exactly one group.

The score of a group is equal to the length of the longest prefix shared by all the strings in that group. For example:

The group {RAINBOW, RANK, RANDOM, RANK} has a score of 2 (the longest prefix is 'RA').
The group {FIRE, FIREBALL, FIREFIGHTER} has a score of 4 (the longest prefix is 'FIRE').
The group {ALLOCATION, PLATE, WORKOUT, BUNDLING} has a score of 0 (the longest prefix is '').
Please help Pip bundle their strings into groups of size K, such that the sum of scores of the groups is maximized.

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins with a line containing the two integers N and K. Then, N lines follow, each containing one of Pip's strings.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the maximum sum of scores possible.

Limits
Time limit: 20 seconds per test set.
Memory limit: 1GB.
1 ≤ T ≤ 100.
2 ≤ N ≤ 105.
2 ≤ K ≤ N.
K divides N.
Each of Pip's strings contain at least one character.
Each string consists only of letters from A to Z.

Test set 1
Each of Pip's strings contain at most 5 characters.

Test set 2
The total number of characters in Pip's strings across all test cases is at most 2 × 106.

Samples

Input 1

Output 1

2
2 2
KICK
START
8 2
G
G
GO
GO
GOO
GOO
GOOO
GOOO

Case #1: 0
Case #2: 10


Input 2

Output 2

1
6 3
RAINBOW
FIREBALL
RANK
RANDOM
FIREWALL
FIREFIGHTER

Case #1: 6

Sample #1
In Case #1, Pip can achieve a total score of 0 by make the groups:

{KICK, START}, with a score of 0.
In Case #2, Pip can achieve a total score of 10 by make the groups:

{G, G}, with a score of 1.
{GO, GO}, with a score of 2.
{GOO, GOO}, with a score of 3.
{GOOO, GOOO}, with a score of 4.
Sample #2
In Case #1, Pip can achieve a total score of 6 by make the groups:

{RAINBOW, RANK, RANDOM}, with a score of 2.
{FIREBALL, FIREWALL, FIREFIGHTER}, with a score of 4.
Note #1: Only Sample #1 is a valid input for Test set 1. Consequently, Sample #1 will be used as a sample test set for your submissions.
Note #2: Unlike previous editions, in Kick Start 2020, all test sets are visible verdict test sets, meaning you receive instant feedback upon submission.
"""

# Trie + Greedy


class TrieNode:
    def __init__(self):
        self.cnt = 0
        self.children = [None] * 26


T = int(input())
for tt in range(T):
    N, K = map(int, input().split())
    ss = []
    for _ in range(N):
        ss.append(input())
    base = ord('A')

    root = TrieNode()

    for s in ss:
        t = root
        for ch in s:
            t.cnt += 1
            i = ord(ch) - base
            if not t.children[i]:
                t.children[i] = TrieNode()
            t = t.children[i]
        t.cnt += 1
    cnt = 0
    root.cnt = 0
    stack = [root]
    while stack:
        t = stack.pop()
        # 这边相当于向下对每一个字符进行计算，每次只加1分，所以每次都是cnt//k，
        # 最终求和获得总分
        cnt += t.cnt // K
        for c in t.children:
            if c and c.cnt >= K:
                stack.append(c)
    print('Case #%d: %d' % (tt + 1, cnt))
