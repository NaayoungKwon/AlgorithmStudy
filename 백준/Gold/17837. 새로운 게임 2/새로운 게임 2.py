import sys

WHITE = 0
RED = 1
BLUE = 2

def switch_dir(d):
    if d == 0:
        return 1
    elif d == 1:
        return 0
    elif d == 2:
        return 3
    else:
        return 2

def isInbound(x,y, n):
    return (x >= 0 and x < n and y >= 0 and y < n )

def solution(n, k, pan, chesses):
    dir = [[0,1],[0,-1],[-1,0],[1,0]]
    chess_pan = [[[] for _ in range(n)] for _ in range(n)]
    
    for i, chess in enumerate(chesses):
        chess_pan[chess['x']][chess['y']].append(i)

    cnt = 1
    while cnt <= 1000:
        for idx in range(len(chesses)):
            chess = chesses[idx]
            d = chess['d']
            x, y = chess['x'] + dir[d][0], chess['y'] + dir[d][1]
            if isInbound(x,y,n) and pan[x][y] != BLUE:
                my_index = chess_pan[chess['x']][chess['y']].index(idx)
                if pan[x][y] == WHITE:
                    chess_pan[x][y].extend(chess_pan[chess['x']][chess['y']][my_index : ])
                elif pan[x][y] == RED:
                    chess_pan[x][y].extend(reversed(chess_pan[chess['x']][chess['y']][my_index : ]))
                chess_pan[chess['x']][chess['y']] = chess_pan[chess['x']][chess['y']][:my_index]
                for i in chess_pan[x][y]:
                    chesses[i]['x'], chesses[i]['y'] = x,y
                if len(chess_pan[x][y]) >= 4:
                    return cnt;
            else: 
                d = switch_dir(d)
                chesses[idx]['d'] = d
                x, y = chess['x'] + dir[d][0], chess['y'] + dir[d][1]
                if isInbound(x,y,n) and pan[x][y] != BLUE:
                    my_index = chess_pan[chess['x']][chess['y']].index(idx)
                    if pan[x][y] == WHITE:
                        chess_pan[x][y].extend(chess_pan[chess['x']][chess['y']][my_index : ])
                    elif pan[x][y] == RED:
                        chess_pan[x][y].extend(reversed(chess_pan[chess['x']][chess['y']][my_index : ]))
                    chess_pan[chess['x']][chess['y']] = chess_pan[chess['x']][chess['y']][:my_index]
                    for i in chess_pan[x][y]:
                        chesses[i]['x'], chesses[i]['y'] = x,y
                    if len(chess_pan[x][y]) >= 4:
                        return cnt;
        cnt += 1;
    return -1

n,k = map(int,sys.stdin.readline().split());
pan = []
for _ in range(n):
    l =  list(map(int,sys.stdin.readline().split())) ;
    pan.append(l)

chess = []
for _ in range(k):
    l =  list(map(int,sys.stdin.readline().split())) ;
    chess.append({'x' : l[0]-1, 'y' : l[1]-1, 'd' : l[2]-1})
# print(chess[0]['x'])
print(solution(n, k, pan, chess));