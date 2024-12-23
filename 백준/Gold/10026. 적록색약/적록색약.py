import sys

def solution(n, arr):
    # print(arr)
    dir = [[-1,0],[0,-1],[1,0],[0,1]]

    # 첫 번째 부터 돌아가면서 본다, visited가 false 일때만 확인한다
    # que에 넣는데, 상하좌우를 확인해서 나랑 같으면 넣는다.
    nor, abnor = 0, 0
    visited = [[False] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if visited[i][j]:
                continue
            me = arr[i][j]
            que = [(i,j)]
            visited[i][j] = True
            while que:
                a, b = que.pop()
                for d in dir:
                    x, y = a+d[0], b+d[1]
                    if x < 0 or x >= n or y < 0 or y >= n or visited[x][y]:
                        continue
                    if arr[x][y] != me:
                        continue

                    visited[x][y] = True
                    que.append((x,y))
            nor += 1

    visited = [[False] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if visited[i][j]:
                continue
            me = set('B') if arr[i][j] == 'B' else set(['R', 'G'])
            # print(i,j,me)
            que = [(i,j)]
            visited[i][j] = True
            while que:
                a, b = que.pop()
                for d in dir:
                    x, y = a+d[0], b+d[1]
                    if x < 0 or x >= n or y < 0 or y >= n or visited[x][y]:
                        continue
                    if arr[x][y] not in me:
                        continue
                    # print(i,j,me, a,b,x,y)
                    visited[x][y] = True
                    que.append((x,y))
                # print(x,y)
            abnor += 1

        
    print(nor, abnor)


n = int(sys.stdin.readline());
myList = [list(sys.stdin.readline()) for i in range(n)];
solution(n, myList);