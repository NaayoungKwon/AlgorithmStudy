import sys

def solution(n, m, pan):

    dp = [[0] * (m+1) for _ in range(n+1)]
    for i in range(1, n+1):
        dp[i][0] = 1

    for i in range(1, n+1):
        e = pan[i-1]
        for j in range(1,e):
            dp[i][j] = dp[i-1][j]
        for j in range(e, m+1):
            dp[i][j] = (dp[i-1][j] + dp[i][j-e])


    return dp[n][m]

t = int(sys.stdin.readline());
for _ in range(t):
    n = int(sys.stdin.readline());
    pan = list(map(int,sys.stdin.readline().split())) ;
    m = int(sys.stdin.readline());
    pan = [a for a in pan if a <= m]
    print(solution(len(pan), m, pan));