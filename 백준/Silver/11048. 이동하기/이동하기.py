import sys

def solution(n, m, load):

    result = 0;
    dp  = [[0]* m for _ in range(n)];

    dp[0][0] = load[0][0];
    for i in range(1,n):
        dp[i][0] = dp[i-1][0] + load[i][0];
    for j in range(1,m):
        dp[0][j] = dp[0][j-1] + load[0][j];

    for i in range(1,n):
        for j in range(1,m):
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + load[i][j];
    # print(dp)
    return dp[n-1][m-1];

n,m = map(int,sys.stdin.readline().split());
myList = [list(map(int,sys.stdin.readline().split())) for _ in range(n)];
print(solution(n, m,myList));