import sys

def solution(n, m, arr):
    visited = [False] * 101
    que = [[1,0]]

    arr_m = dict()
    for a, b in arr:
        arr_m[a] = b

    while que:
        node, cnt = que.pop(0)
        for i in range(6,0,-1):
            nx = node + i
            if nx == 100:
                # print(node, i, nx, cnt)
                return cnt +1
            elif nx > 100:
                continue
            elif visited[nx]:
                continue
            visited[nx] = True
            if nx in arr_m.keys() and visited[arr_m[nx]] == False:
                nx = arr_m[nx]
                visited[nx] = True
                que.append([nx, cnt+1])
            elif nx not in arr_m.keys():
                visited[nx] = True
                que.append([nx, cnt+1])
            # print(node, i, nx, cnt)
    return 0



n,m = map(int,sys.stdin.readline().split(' '));
ladders = [list(map(int,sys.stdin.readline().split())) for i in range(n+m)];
# snake = [list(map(int,sys.stdin.readline().split())) for i in range(m)];
print(solution(n, m, ladders));