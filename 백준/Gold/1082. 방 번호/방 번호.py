import sys

def solution(n, m, arr):
    
    dp = [0] * (m+1)

    for k in range(m, -1, -1):
        for i in range(n-1, -1, -1):
            if (dp[k] != 0 or k == m) and k-arr[i] >= 0:
                dp[k-arr[i]] = max(dp[k-arr[i]], dp[k] * 10 + i)
    # print(dp)
    return max(dp)


n = int(sys.stdin.readline());
arr = list(map(int,sys.stdin.readline().split(' ')))
m = int(sys.stdin.readline());
print(solution(n, m, arr));