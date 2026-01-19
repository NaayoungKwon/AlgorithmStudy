import sys
from collections import deque

def solution(R, C, maze, hoon, fires):
    dirs = [(0,1),(1,0),(0,-1),(-1,0)]
    que = deque()
    
    for fire in fires:
        que.append((fire, 'F', 1))
    que.append((hoon, 'J', 1))

    visited = [[False] * C for _ in range(R)]
    visited[hoon[0]][hoon[1]] = True

    while que:
        pos, type, l = que.popleft()
        if type == 'J' and (pos[0] == 0 or pos[0] == R-1 or pos[1] == 0 or pos[1] == C-1):
            return l
        
        for d in dirs:
            nx, ny = pos[0] + d[0], pos[1] + d[1]
            if not (0 <= nx < R and 0 <= ny < C):
                continue
            if maze[nx][ny] == '#':
                continue
            
            if type == 'F':
                maze[nx][ny] = '#'
                que.append(((nx, ny), type, l + 1))
            elif type == 'J' and not visited[nx][ny]:
                visited[nx][ny] = True
                que.append(((nx, ny), type, l + 1))
                if nx == 0 or nx == R-1 or ny == 0 or ny == C-1:
                    return l + 1
        # for a in maze:
        #     print(''.join(a))
        # print('---')
    return "IMPOSSIBLE"

input = sys.stdin.readline

R, C = map(int, input().split())

maze = []
hoon = None
fires = set()

for r in range(R):
    row = input().rstrip()
    maze.append(list(row))
    for c, ch in enumerate(row):
        if ch == 'J':
            hoon = (r, c)
        elif ch == 'F':
            fires.add((r, c))
            maze[r][c] = '#'

print(solution(R, C, maze, hoon, fires))
