import sys
# import heapq

def solution(n, m, arr):
    set_list = set()
    dirs = [(0,1),(1,0),(0,-1),(-1,0)]
    st = [(0,0,set(arr[0][0]))]
    
    ts = set()
    for i in range(n):
        for j in range(m):
            ts.add(arr[i][j])
    all_count = len(ts)
    max_count = 1
    while st:
        x, y, alpha = st.pop()
        for dx, dy in dirs:
            nx, ny = x + dx, y + dy
            if not (0 <= nx < R and 0 <= ny < C):
                continue
            if arr[nx][ny] in alpha:
                continue
            nalpha = alpha | set(arr[nx][ny])
            max_count = max(max_count, len(nalpha))
            st.append((nx, ny, nalpha))
            if len(nalpha) == all_count:
                return all_count
    return max_count


input = sys.stdin.readline

R, C = map(int, input().split())

board = []
for _ in range(R):
    line = input().strip()          # 예: "ABCD"
    board.append(list(line))        # ['A','B','C','D']
print(solution(R, C, board));