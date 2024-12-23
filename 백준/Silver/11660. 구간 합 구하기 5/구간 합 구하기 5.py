import sys

def solution(n, m, pan, arr):
    dp = [[0] * (n+1) for _ in range(n+1)]

    for i in range(1, n+1):
        for j in range(1, n+1):
            dp[i][j] = dp[i-1][j] + pan[i-1][j-1]

    for i in range(1, n+1):
        for j in range(1, n+1):
            dp[i][j] += dp[i][j-1]
    
    result = []
    for a,b,c,d in arr:
        # s = 0
        # for j in range(b, d+1):
        #     s += (dp[c][j] - dp[a-1][j])
        print(dp[c][d] - dp[a-1][d] - dp[c][b-1] + dp[a-1][b-1])


n,m = map(int,sys.stdin.readline().split(' '));
myList = [list(map(int,sys.stdin.readline().split(' '))) for i in range(n)];
arr= [list(map(int,sys.stdin.readline().split(' '))) for i in range(m)]
solution(n, m, myList, arr);