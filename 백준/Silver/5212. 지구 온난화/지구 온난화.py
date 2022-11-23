import sys

def check(i, j, map_):
    dir = [[-1,0], [0, -1], [1,0], [0,1]];
    cnt = 0;
    for k in range(4):
        x = i + dir[k][0];
        y = j + dir[k][1];
        if (x >= 0 and x < len(map_) and y >= 0 and y < len(map_[0])):
            if map_[x][y] == '.':
                cnt += 1;
        elif (x == -1 or x == len(map_) or y == -1 or y == len(map_[0])):
            cnt +=1;
    if cnt >= 3:
        return '.';
    else:
        return 'X';

def solution(R, C, map_):

    newMap = [['.'] * C for i in range(R)];
    for i in range(R):
        for j in range(C):
            if map_[i][j] == 'X':
                newMap[i][j] = check(i,j, map_);
            else:
                newMap[i][j] = '.' ;

    while 'X' not in newMap[0]:
        newMap = newMap[1:];
    while 'X' not in newMap[-1]:
        newMap = newMap[:-1];
    newMap = list(map(list, zip(*newMap)))
    while 'X' not in newMap[0]:
        newMap = newMap[1:];
    while 'X' not in newMap[-1]:
        newMap = newMap[:-1];
    newMap = list(map(list, zip(*newMap)))
    for i in range(len(newMap)):
        print(''.join(newMap[i]));
  
R, C = map(int, sys.stdin.readline().split());
myList = [(sys.stdin.readline())[:C] for i in range(R)];
solution(R,C,myList);