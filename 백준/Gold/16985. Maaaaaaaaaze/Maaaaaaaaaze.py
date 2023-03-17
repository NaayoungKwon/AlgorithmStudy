import sys
from itertools import permutations
from collections import deque;

MAX_LEN = 5 ** 10;
def make3D(pans, orders):
    new_pans = [];
    for order in orders:
        new_pans.append(pans[order]);
    return new_pans;

def rotate(pan):
    # print('---------')
    # print(pan)
    # print(list(zip(*pan)));
    return list(zip(*pan[::-1]));

def dfs(cube, now_max):
    dir = [(1,0,0),(0,1,0),(0,0,1),(-1,0,0),(0,-1,0),(0,0,-1)];
    arr = deque();
    if cube[0][0][0] == 0 or cube[4][4][4] == 0:
        return MAX_LEN;

    visited = [[[0]*5 for _ in range(5)] for _ in range(5)];
    arr.append((0,0,0,0));
    while arr:
        a,b,c,l = arr.popleft();
        if l > now_max:
            return MAX_LEN;

        for x,y,z in dir:
            if 0 <= a+x < 5 and 0 <= b+y < 5 and 0 <= c+z <5 and visited[a+x][b+y][c+z] == 0 and cube[a+x][b+y][c+z] == 1:
                arr.append((a+x,b+y,c+z,l+1));
                visited[a+x][b+y][c+z] = l+1;
                if a+x == 4 and b+y == 4 and c+z == 4:
                    # print(visited)
                    return l+1;
    return MAX_LEN;

def solution(pans):

    result = MAX_LEN;
    for order in permutations(range(5),5):
        cube = make3D(pans, order);
        for _ in range(4):
            cube[0] = rotate(cube[0]);
            for _ in range(4):
                cube[1] = rotate(cube[1]);
                for _ in range(4):
                    cube[2] = rotate(cube[2]);
                    for _ in range(4):
                        cube[3] = rotate(cube[3]);
                        for _ in range(4):
                            cube[4] = rotate(cube[4]);
                            l = dfs(cube, result);
                            # print(l)
                            result = min(result, l);

    return result if result != MAX_LEN else -1;

pans = [];
for _ in range(5):
    pan = [list(map(int,sys.stdin.readline().split())) for _ in range(5)];
    pans.append(pan);
print(solution(pans));