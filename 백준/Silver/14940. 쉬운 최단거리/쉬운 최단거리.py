import sys
import heapq

def find_start(n, m, arr):
    for i in range(n):
        for j in range(m):
            if arr[i][j] == 2:
                return (i,j)
            
def solution(n, m, arr):
    dir = [(0,1), (1,0), (0,-1), (-1,0)]
    start = find_start(n,m,arr);
    new_map = [[0] * m for _ in range(n)]

    que = [(0, start)]
    while que:
        l, node = heapq.heappop(que)

        for d in dir:
            x, y = node[0] + d[0], node[1] + d[1]
            if x < 0 or x >= n or y < 0 or y >= m or new_map[x][y] > 0: 
                continue
        
            if arr[x][y] != 1:
                continue
            
            new_map[x][y] = l+1
            heapq.heappush(que, (l+1, (x,y)))
            
    for i in range(n):
        for j in range(m):
            if arr[i][j] == 1 and new_map[i][j] == 0:
                new_map[i][j] = -1
            
    for line in new_map:
        # print(*line)
        print(' '.join(map(str, line)))
    # print(new_map)

n,m = map(int,sys.stdin.readline().split());
myList = [list(map(int,sys.stdin.readline().split())) for i in range(n)];
solution(n, m, myList);