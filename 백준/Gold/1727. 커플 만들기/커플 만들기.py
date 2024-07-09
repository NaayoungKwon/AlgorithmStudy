import sys

def solution(n, m, men, women):
    if n < m:
        men, women = women, men
        n, m = m, n
    dp = [[0] * n for _ in range(m)]
    men.sort()
    women.sort()

    result = 0
    p = 0

    dp[0][0] = abs(men[0] - women[0])
    for j in range(1, n-m+1):
        dp[0][j] = min(abs(men[j] - women[0]), dp[0][j-1])

    for i in range(1,m): # 여자
        for j in range(i, n-m+i+1): # 남자
            if i == j:
                dp[i][j] = dp[i-1][j-1] + abs(men[j] - women[i])
            else:
                dp[i][j] = min(dp[i][j-1], dp[i-1][j-1] + abs(men[j] - women[i]))
    
    return dp[m-1][n-1]


n,m = map(int,sys.stdin.readline().split(' '));
men = list(map(int,sys.stdin.readline().split(' ')));
women = list(map(int,sys.stdin.readline().split(' ')));
print(solution(n, m, men, women));