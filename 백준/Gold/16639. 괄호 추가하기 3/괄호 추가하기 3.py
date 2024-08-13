import sys
import re

MAX_R = 2**63 -1
MIN_R = -2**63
def find(dp, ops, i, j):

    min_r = MAX_R
    max_r = MIN_R
    
    if dp[i][j] != [MAX_R, MIN_R]:
        return dp[i][j]
    
    # print(i,j)
    for a in range(i, j):
        r = find(dp, ops, i, a)
        l = find(dp, ops, a+1, j)

        if ops[a] == '+':
            x = min( r[0] + l[0], r[0] + l[1], r[1] + l[0], r[1] + l[1])
            y = max( r[0] + l[0], r[0] + l[1], r[1] + l[0], r[1] + l[1])
        elif ops[a] == '-':
            x = min(r[0] - l[0], r[0] - l[1], r[1] - l[0], r[1] - l[1])
            y = max(r[0] - l[0], r[0] - l[1], r[1] - l[0], r[1] - l[1])
        else:
            x = min(r[0] * l[0], r[0] * l[1], r[1] * l[0], r[1] * l[1])
            y = max( r[0] * l[0], r[0] * l[1], r[1] * l[0], r[1] * l[1])

        dp[i][j] = [x,y]
        min_r, max_r = min(min_r, x), max(max_r, y)
    dp[i][j] = [min_r, max_r]
    return dp[i][j]

def solution(n, s):
    

    nums = list(map(int,re.findall('[0-9]', s)))
    ops = re.findall('[^0-9]',s)
    dp = [[[MAX_R, MIN_R] for _ in range(len(nums))] for _ in range(len(nums))]

    for i in range(len(nums)):
        dp[i][i] = [nums[i], nums[i]]


    result = find(dp, ops, 0, len(nums)-1)
    # for i in range(len(nums)):
    #     print(dp[i])
    return result[1]


n = int(sys.stdin.readline());
s = sys.stdin.readline().split('\n')[0]
print(solution(n, s));