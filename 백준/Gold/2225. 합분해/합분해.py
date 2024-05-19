import sys

dp = []
def solution(n, k):

    for i in range(2,k+1):
        dp[i][0] = 1
        for j in range(1,n+1):
            dp[i][j] =( dp[i-1][j] + dp[i][j-1]) % 1000000000
    return dp[k][n]


a,b = map(int,sys.stdin.readline().split(' '));
dp = [[-1] * (a+1) for _ in range(b+1)]
dp[1] =  [1] * (a+1)
print(solution(a,b));