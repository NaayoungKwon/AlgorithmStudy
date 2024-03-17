
import sys
from collections import deque

def solution(n,height,map_):

    answer = []
    dir = [[-1,0], [1,0], [0,-1], [0,1]]
    #height = sorted(list(height))
    height = list(height)
    if len(height) == 1:
        height.append(0)
    for h in height:
        que = deque()
        visited = [[0] * n for i in range(n)]
        cnt = 0
        for i in range(n):
            for j in range(n):
                if visited[i][j] == 0 and map_[i][j] > h:
                    que.append((i,j))
                    visited[i][j] = 1
                    
                    while len(que) > 0:
                        x, y = que.popleft()
                        for a in range(4):
                            if 0 <= x+dir[a][0] < n and 0 <= y+dir[a][1] < n and visited[x+dir[a][0]][y+dir[a][1]] == 0 and map_[x+dir[a][0]][y+dir[a][1]] > h:
                                que.append((x+dir[a][0],y+dir[a][1]))
                                visited[x+dir[a][0]][y+dir[a][1]] = 1
                    cnt += 1
        answer.append(cnt)
    #print(answer)
    return max(answer)
    
n = int(sys.stdin.readline())
map_ = []
height = []
for idx in range(n):
    temp_map = list(map(int,sys.stdin.readline().split()))
    map_.append(temp_map)
    height = set(height) | set(temp_map)
print(solution(n,height,map_))
