import sys
import heapq

def solution(n, arr):
    dirs = [(0,1),(1,0),(0,-1),(-1,0)]
    dp = [[200 * n * n] * n for _ in range(n)]
    dp[0][0] = arr[0][0]

    que = []
    heapq.heappush(que, (arr[0][0], (0,0)))
    while que:
        cost, cur = heapq.heappop(que)
        for d in dirs:
            nx = cur[0] + d[0]
            ny = cur[1] + d[1]
            if not(0 <= nx < n and 0 <= ny < n):
                continue
            ncost = cost + arr[nx][ny]
            if ncost < dp[nx][ny]:
                if nx == n-1 and ny == n-1:
                    return ncost
                dp[nx][ny] = ncost
                heapq.heappush(que, (ncost, (nx, ny)))

    return dp[n-1][n-1]


input = sys.stdin.readline
i = 1
result = []
while True:
    N = int(input().strip())
    if N == 0:
        break

    cave = []
    for _ in range(N):
        row = list(map(int, input().split()))
        cave.append(row)
    result.append("Problem " + str(i) + ": " + str(solution(N, cave)))
    i += 1
for res in result:
    print(res)