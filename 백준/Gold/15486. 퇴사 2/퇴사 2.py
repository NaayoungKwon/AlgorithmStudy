import sys

def solution(n, days):

    dp = [0] * (n+1);
    for i in range(n):
        dp[i+1] = max(dp[i+1], dp[i])
        if i + days[i][0] <= n:
            dp[i + days[i][0]] = max( dp[i+days[i][0]], dp[i] + days[i][1]);
    return max(dp);
  
n = int(sys.stdin.readline());
myList = [list(map(int,sys.stdin.readline().split())) for i in range(n)];
print(solution(n, myList));