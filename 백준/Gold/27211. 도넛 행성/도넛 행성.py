import sys
from collections import deque;
sys.setrecursionlimit(10**6)
dir = [[1, 0], [0, 1], [-1, 0], [0,-1]];
def dfs(i,j,load):
    for x, y in dir:
        a = (i+x+n) % n;
        b = (j+y+m) % m;
        if load[a][b] == 0:
            load[a][b] = 1;
            dfs(a,b,load);

def solution(n, m, load):

    result = 0;
    arr = deque();
    

    if load[0][0] == 0:
        arr.append((0,0));

    for i in range(n):
        for j in range(m):
            if load[i][j] == 0:
                result += 1;
                load[i][j] = 1;
                dfs(i,j,load);
                
    return result;

n,m  = map(int,sys.stdin.readline().split());
myList = [list(map(int,sys.stdin.readline().split())) for _ in range(n)];
print(solution(n, m, myList));