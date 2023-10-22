import sys

def solution(n, k, arr):
    dp = [[5000*100] * n for i in range(2)]
    dp[0][0] = 0
    dp[1][0] = 0

    for i in range(n-1):
        dp[0][i+1] = min(dp[0][i+1], dp[0][i] + arr[i][0])
        dp[1][i+1] = min(dp[1][i+1], dp[1][i] + arr[i][0])

        if i < n-2:
            dp[0][i+2] = min(dp[0][i+2], dp[0][i] + arr[i][1])
            dp[1][i+2] = min(dp[1][i+2], dp[1][i] + arr[i][1])

        if i < n-3:
            dp[1][i+3] = min(dp[1][i+3], dp[0][i] + k)

    return min(dp[0][n-1], dp[1][n-1])

n = int(sys.stdin.readline());
myList = []
for i in range(n-1):
    a, b = map(int,sys.stdin.readline().split());
    myList.append([a,b])
k = int(sys.stdin.readline());
print(solution(n, k, myList));