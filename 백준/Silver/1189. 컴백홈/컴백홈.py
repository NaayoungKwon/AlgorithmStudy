import sys

def solution(r,c,k,pan):

    cnt = 0;
    start = (r-1, 0)
    end = (0, c-1)
    dir = [[1, 0], [0, 1], [-1, 0], [0, -1]]
    v = [[False] * c for _ in range(r) ]

    v[start[0]][start[1]] = True
    que = [(start, 1, v)]

    while que:
        # 꺼낸다 -> 새로운 위치를 하나 만든다
        # 도착지이고 거리가 k이면 cnt ++후 continue
        # 검사한다 (범위 안 + T가 아닌 것 + 방문하지 않은 것)
        # 검사에 패스했을 때 visited에 true 후, que에 넣는다
        node, l, visited = que.pop()
        if node == end:
            if l == k:
                cnt += 1
            continue
        if l >= k:
            continue

        for d in dir:
            x, y = node[0] + d[0], node[1] + d[1]
            if x >= 0 and x < r and y >= 0 and y < c and pan[x][y] != 'T' and visited[x][y] == False:
                new_v = [arr[:] for arr in visited]
                new_v[x][y] = True
                que.append(((x,y), l+1, new_v))

    
    return cnt

r,c,k = map(int,sys.stdin.readline().split());
pan = [list(map(str, input())) for _ in range(r)]
print(solution(r, c, k, pan));