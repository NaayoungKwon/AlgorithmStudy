import sys
from collections import deque

def solution(r,c,pan):
    JIHOON, FIRES = (0,0), []
    dir = [(1, 0), (-1,0), (0,1), (0,-1)]

    for i in range(r):
        for j in range(c):
            if pan[i][j] == 'J':
                pan[i][j] = 1
                JIHOON = (i,j)
            elif pan[i][j] == 'F':
                pan[i][j] = '#'
                FIRES.append((i,j))

    que = deque()
    que.append((JIHOON, 'J'))
    for f in FIRES:
        que.append((f, 'F'))

    while que:
        hoon, case= que.popleft()
        if case == 'J' and (hoon[0] == 0 or hoon[0] == r-1 or hoon[1] == 0 or hoon[1] == c-1) and pan[hoon[0]][hoon[1]] != '#':
            return pan[hoon[0]][hoon[1]] 
        
        for d in dir:
            nha, nhb = hoon[0] + d[0], hoon[1] + d[1]
            if not (nha >= 0 and nha < r and nhb >= 0 and nhb < c):
                continue
    
            
            if case == 'F' and pan[nha][nhb] != '#': #fire
                pan[nha][nhb] = '#'
                que.append(((nha, nhb), 'F'))
            elif case == 'J' and pan[nha][nhb] == '.' and pan[hoon[0]][hoon[1]] != '#':
                pan[nha][nhb] = pan[hoon[0]][hoon[1]] + 1
                que.append(((nha, nhb), 'J'))


    return 'IMPOSSIBLE'


r,c = map(int,sys.stdin.readline().split(' '));
myList = [list(sys.stdin.readline())[:-1] for i in range(r)];
print(solution(r, c, myList));