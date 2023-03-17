import sys

def solution(n, arr):

    result = arr[0];
    dp = [[0]* n for _ in range(2)]; 
    dp[0][0] = arr[0];

    for i in range(1,n):
        dp[0][i] = max(dp[0][i-1] + arr[i], arr[i]);
        dp[1][i] = max(dp[0][i-1], dp[1][i-1] + arr[i]);
        result = max(result, dp[0][i], dp[1][i]);
    # print(dp)
    return result;

n = int(sys.stdin.readline());
myList = list(map(int,sys.stdin.readline().split()));
print(solution(n, myList));