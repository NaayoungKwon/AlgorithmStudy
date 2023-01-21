import sys

def solution2(n, load):

    result = 0;
    dp = [[0] * n for _ in range(2)];
    # dp[0] : 왼쪽이 1, dp[1] : 오른쪽이 1
    dp[0][0] = 1 if load[0] == 1 else -1;
    dp[1][0] = 1 if load[0] == 2 else -1;

    for i in range(1,n):
        if load[i] == 1:
            dp[0][i] = dp[0][i-1] + 1;
            dp[1][i] = max(0, dp[1][i-1] -1);
        else:
            dp[0][i] = max(0, dp[0][i-1] - 1);
            dp[1][i] = dp[1][i-1] + 1;

    return max(max(dp[0]), max(dp[1]));

n = int(sys.stdin.readline());
myList = list(map(int,sys.stdin.readline().split()))
print(solution2(n, myList));