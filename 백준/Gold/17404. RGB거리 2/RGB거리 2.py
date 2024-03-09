import sys
import itertools

RGB = {'R' : 0, 'G' : 1, 'B' : 2}

def solution(n, pans):
    dp = [[1000 * n] * 3 for _ in range(n)]
    result = 10000 * 10000

    for color in range(3):
        dp = [[1000 * n] * 3 for _ in range(n)]
        for i in range(n):        
            otherColors = list(set([0,1,2]) - set([color]))
            if i == 0:
                dp[i][color] = pans[i][color]
                for otherColor in otherColors:
                    dp[i][otherColor] = 10000 * n
            else:
                for j in range(3):
                    if j == 0:
                        dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + pans[i][0]
                    elif j == 1:
                        dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + pans[i][1]
                    else:
                        dp[i][2] = min(dp[i-1][1], dp[i-1][0]) + pans[i][2]
        
        for i in list(set(range(3)) - set([color])):
            result = min(result, dp[n-1][i])
        # result = min(result, min(dp[n-1]))
        
    return result
    

n = int(sys.stdin.readline());
pan = [list(map(int, list(input().split(' ')))) for _ in range(n)]
print(solution(n, pan));