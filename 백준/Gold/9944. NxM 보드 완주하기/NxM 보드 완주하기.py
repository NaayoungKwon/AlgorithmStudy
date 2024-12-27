import sys

def is_in(i,j,n,m):
    return i >= 0 and i < n and j >= 0 and j < m
def solution(n, m, arr):
    dirs = [[1,0],[-1,0],[0,1],[0,-1]]
    m_cnt = 1000001

    for i in range(n):
        for j in range(m):
            if arr[i][j] == '*':
                continue

            arr[i][j] = '*'
            que = [(i,j,0,[a[:] for a in arr])]
            while que:
                cnt = 0
                a,b,c,map_ = que.pop(0)
                for d in dirs:
                    x, y = a+d[0], b+d[1]
                    if (not is_in(x,y,n,m)) or map_[x][y] == '*': # 아예 못움직임
                        continue
                    cnt += 1
                    dmap_ = [dm[:] for dm in map_]
                    dmap_[x][y] = '*'
                    while is_in(x+d[0],y+d[1],n,m) and dmap_[x+d[0]][y+d[1]] == '.': #끝까지 가기
                        x, y = x+d[0], y+d[1]
                        dmap_[x][y] = '*'
                        
                    # print(a,b,x,y,c+1)
                    que.append((x,y,c+1,dmap_))
                if cnt == 0: # 사방 아무데로도 못갔다
                    s = set()
                    for p in map_:
                        s.update(list(set(p)))
                    if len(s) == 1 and '*' in s:
                        m_cnt = min(m_cnt, c)
                        break
            arr[i][j] = '.'

    # print(arr)
    return m_cnt if m_cnt < 1000001 else -1

case = 1
while True:
    try:
        n,m = map(int,sys.stdin.readline().split(' '));
        myList = [list(sys.stdin.readline())[:-1] for i in range(n)];
        print("Case " +str(case) + ": " + str(solution(n, m, myList)));
        case += 1
    except:
        break