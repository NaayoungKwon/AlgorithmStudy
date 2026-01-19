import sys
# import heapq

max_count = 1
visited = [False] * 26
def dfs(x, y, count, arr, n, m):
    dirs = [(0,1),(1,0),(0,-1),(-1,0)]
    global max_count
    max_count= max(max_count, count)
    for dx, dy in dirs:
        nx, ny = x + dx, y + dy
        if not (0 <= nx < n and 0 <= ny < m):
            continue
        if visited[ord(arr[nx][ny]) - ord('A')]:
            continue
        visited[ord(arr[nx][ny]) - ord('A')] = True
        dfs(nx, ny, count + 1, arr, n, m)
        # print(nx, ny, arr[nx][ny], visited)
        visited[ord(arr[nx][ny]) - ord('A')] = False

def solution(n, m, arr):
    visited[ord(arr[0][0]) - ord('A')] = True
    dfs(0, 0, 1, arr, n, m)
    return max_count


input = sys.stdin.readline

R, C = map(int, input().split())

board = []
for _ in range(R):
    line = input().strip()          # 예: "ABCD"
    board.append(list(line))        # ['A','B','C','D']
print(solution(R, C, board));