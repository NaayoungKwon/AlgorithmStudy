import sys
import math

MAX_VALUE = (1 << 20) - 1


def solution(c , arr):

    dp = [MAX_VALUE] * (c+1)
    arr.sort(key=lambda x: x[1])

    for cost, customer in arr:
        dp[min(c, customer)] = min(dp[min(c, customer)], cost)
        for i in range(customer+1, customer * math.ceil(c / customer)+1):
            ni = min(i, c)
            if i - customer < c:
                dp[ni] = min(dp[ni], dp[i-customer] + cost)

    return dp[c]

n, m =  map(int, sys.stdin.readline().split(' '))
arr = []
for _ in range(m):
    a, b = map(int, sys.stdin.readline().split(' '))
    arr.append((a, b))
print(solution(n, arr))
# print(solution(12, [[3,5], [1,1]]) == 8)