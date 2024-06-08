import sys

def is_in_range(n,m, i,j):
    if i >= 0 and i < n and j >= 0 and j < m:
        return True
    return False

def solution(n, m, pan):

    MIN_K = -200 * n * m
    dp = [[[MIN_K,MIN_K,MIN_K] for _ in range(m)] for _ in range(n) ]
    dir = [(0,-1),(-1,0)] # 왼쪽에서 온거, 위에서 온거
    
    dp[0][0] = [pan[0][0],pan[0][0],MIN_K]
    for i in range(n):
        for j in range(m):
            for k in range(2):
                d  = dir[k]
                prev_x, prev_y = i + d[0], j + d[1]
                if not is_in_range(n,m,prev_x, prev_y):
                    continue
                
                dp[i][j][k] = max(dp[i][j][k], max(dp[prev_x][prev_y]) + pan[i][j])
        
        if i == 0:
            continue
        for j in range(m-2, -1, -1):
            prev_x, prev_y = i, j+1
            if not is_in_range(n,m,prev_x, prev_y):
                continue

            dp[i][j][2] = max(dp[i][j][2],  max(dp[prev_x][prev_y][1:]) + pan[i][j])
    

    return max(dp[n-1][m-1])


n,m = map(int,sys.stdin.readline().split(' '));
myList = [list(map(int,sys.stdin.readline().split())) for i in range(n)];
print(solution(n, m, myList));