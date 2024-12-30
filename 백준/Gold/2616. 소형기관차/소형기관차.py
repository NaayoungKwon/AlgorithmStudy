import sys

def solution(n, l, train):
    arr = [0]*n
    arr[l-1] = sum(train[:l])
    for i in range(l,n):
        arr[i] = arr[i-1] + train[i] - train[i-l]
    dp = [[0] * n for _ in range(4)]

    dp[1][l-1] = arr[l-1] 
    for i in range(l, n):
        dp[1][i] = max(dp[1][i-1], arr[i])
        dp[2][i] = max(dp[2][i-1], dp[1][i-l] + arr[i]) if dp[1][i-l] > 0 else 0
        dp[3][i] = max(dp[3][i-1], dp[2][i-l] + arr[i]) if dp[2][i-l] > 0 else 0

    # print(dp)
    return dp[3][n-1]


n = int(sys.stdin.readline());
train = list(map(int,sys.stdin.readline().split(' ')));
ml = int(sys.stdin.readline());
print(solution(n, ml, train));