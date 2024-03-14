import sys

def solution(n):

    dp = [0] * 32

    dp[2] = 3
    dp[4] = dp[2] * 3 + 2
    dp[6] = dp[4] * 3 + dp[2] * 2 + 2
    
    if n >= 8:
        for i in range(8, n+1, 2):
            dp[i] = dp[i-2] * 3
            k = 4
            while i - k > 0 :
                dp[i] += (dp[i - k] * 2)
                k += 2
            dp[i] += 2
    return dp[n]

n = int(sys.stdin.readline());
print(solution(n));