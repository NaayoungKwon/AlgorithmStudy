import sys

def solution(n):

    result = 0;
    dp = [''] * max(7, n+1)
    dp[1] = 'SK'
    dp[2] = 'CY'
    dp[3] = 'SK'
    dp[4] = 'CY'
    dp[5] = 'SK'
    dp[6] = 'CY'

    if n <= 6:
        return dp[n]
    return solution(n-6)

n = int(sys.stdin.readline());
print(solution(n));