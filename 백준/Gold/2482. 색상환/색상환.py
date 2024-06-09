import sys

DIV = 1000000003

def solution(n, k):
    dp = [[0] * (n+1) for _ in range(k+1)]
    dp[0] = [1] * (n+1)
    dp[1] = [i for i in range(n+1)]

    for i in range(2, k+1):
        for j in range(3,n):
            dp[i][j] = (dp[i-1][j-2] + dp[i][j-1]) % DIV
        dp[i][n] = (dp[i-1][n-3] + dp[i][n-1]) % DIV

    return dp[k][n]


n = int(sys.stdin.readline());
k = int(sys.stdin.readline());
print(solution(n, k));