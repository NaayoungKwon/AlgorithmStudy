import sys

def solution(arr):
    n = max(arr)
    dp = [[0] * 4 for _ in range(n+1)] 
    for i in range(1, n+1):
        dp[i][1] = 1
    dp[1][2] = 1
    dp[1][3] = 1
    dp[2][2] = 2
    dp[2][3] = 2
    dp[3][2] = 2
    dp[3][3] = 3

    for i in range(4, n + 1):
        for j in range(2, 4):
            dp[i][j] = dp[i][j-1] + dp[i-j][j]

    for a in arr:
        print(dp[a][3])
    # return dp[n][3]


t = int(sys.stdin.readline());
arr = []
for _ in range(t):
    n = int(sys.stdin.readline());
    arr.append(n)
solution(arr)