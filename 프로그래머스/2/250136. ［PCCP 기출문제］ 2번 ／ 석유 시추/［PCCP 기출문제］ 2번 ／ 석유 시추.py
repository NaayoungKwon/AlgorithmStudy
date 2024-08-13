def solution(land):
    answer = 0
    n, m = len(land), len(land[0])
    result = [0] * m
    
    dir = [[0,1], [1,0], [-1,0],[0,-1]]
    
    for i in range(n):
        for j in range(m):
            if land[i][j] == 0:
                continue
                
            que = []
            que.append((i,j))
            land[i][j] = 0
            idx = 0
            while idx < len(que):
                a,b = que[idx]
                for d in dir:
                    x,y = a + d[0], b + d[1]
                    if x >= 0 and x < n and y >= 0 and y < m and land[x][y] == 1:
                        que.append((x,y))
                        land[x][y] = 0
                idx += 1
            cnt = len(que)
            j_list = set([b for a,b in que])
            # print(que)
            for cj in j_list:
                result[cj] += cnt
    # print(result)
                    
    return max(result)