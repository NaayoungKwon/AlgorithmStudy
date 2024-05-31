import sys

def solution(n, arr):
    
    dp = [0] * (n+1)
    
    for i in range(1,n):
        max_n = (max(arr[: i+1]) - min(arr[: i+1]))
        for j in range(i):
            # print(i,arr[j+1:i+1])
            max_n = max(max_n, dp[j] + (max(arr[j+1: i+1]) - min(arr[j+1: i+1])))
        dp[i] = max_n
    
    return dp[n-1]

n = int(sys.stdin.readline());
myList = list(map(int,sys.stdin.readline().split()))
print(solution(n, myList));