def solution(maps):
    answer = []
    lands = []
    dirs = [[1,0],[0,1],[-1,0],[0,-1]]
    
    n,m = len(maps), len(maps[0])
    for i in range(n):
        for j in range(m):
            if maps[i][j] == 'X':
                continue
                
            que = [(i,j)]
            cnt = int(maps[i][j])
            maps[i] = maps[i][:j] + 'X' + maps[i][j+1:]
            while que:
                a, b = que.pop()
                for d in dirs:
                    na, nb = a+d[0], b+d[1]
                    if na < 0 or na >= n or nb < 0 or nb >= m or maps[na][nb] == 'X':
                        continue
                    cnt += int(maps[na][nb])
                    maps[na] = maps[na][:nb] + 'X' + maps[na][nb+1:]
                    que.append((na,nb))
            lands.append(cnt)
    lands.sort()
    return lands if len(lands) > 0 else [-1]