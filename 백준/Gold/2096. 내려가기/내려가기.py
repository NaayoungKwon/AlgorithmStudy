import sys
import heapq

def solution(n,stairs):
    result = [0] *2
    dp = [[0] * 3 for _ in range(2)]

    for a in range(2):
        dp[0] = stairs[0][:]
        for i in range(1,n):
            dp[i%2][0] = stairs[i][0] + (min(dp[(i-1)%2][0],dp[(i-1)%2][1]) if a == 0 else max(dp[(i-1)%2][0],dp[(i-1)%2][1]))
            dp[i%2][1] = stairs[i][1] + (min(dp[(i-1)%2][0],dp[(i-1)%2][1],dp[(i-1)%2][2]) if a == 0 else max(dp[(i-1)%2][0],dp[(i-1)%2][1], dp[(i-1)%2][2]))
            dp[i%2][2] = stairs[i][2] + (min(dp[(i-1)%2][1],dp[(i-1)%2][2]) if a == 0 else max(dp[(i-1)%2][1],dp[(i-1)%2][2]))
        result[a] = min(dp[(n-1)%2]) if a == 0 else max(dp[(n-1)%2])
    print(result[1], result[0])

n = int(sys.stdin.readline());
myList = [list(map(int,sys.stdin.readline().split())) for _ in range(n)];
solution(n,myList);