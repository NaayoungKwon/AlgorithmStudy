import sys

def solution(v,e,pathList):

    MIN_LEN = 10000 * E +1;
    NONE = MIN_LEN;
    path = [[NONE] * (v+1) for i in range(v+1)];
    que = [];
    for a,b,c in pathList:
        if a == b and c < MIN_LEN:
            MIN_LEN = c;
        else:
            path[a][b] = c;
            # que.append((a,b));
    
    for i in range(1,v+1):
        for j in range(1,v+1):
            for k in range(j+1,v+1):
                if i == k and path[i][j] + path[j][k] < MIN_LEN:
                    MIN_LEN = path[i][j] + path[j][k];
                elif i != k and path[i][j] + path[j][k] < path[i][k]:
                    path[i][k] = path[i][j] + path[j][k];

    if MIN_LEN == NONE:
        return -1;
    return MIN_LEN;
  
V, E = map(int,sys.stdin.readline().split());
myList = [list(map(int,sys.stdin.readline().split())) for i in range(E)];
print(solution(V,E,myList));