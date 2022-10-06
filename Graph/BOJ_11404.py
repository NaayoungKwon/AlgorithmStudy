# Floyd Algorithm
# node 수가 크지 않고 모든 정점의 최단 거리를 구하기
# node[i][j] = min(node[i][j], node[i][k] + node[k][j])

import sys

MAX_COST = 100000001;
def solution(n, m, pathSet):

    path = [[MAX_COST] * (n+1) for i in range(n+1)];
    for a,b,c in pathSet:
        path[a][b] = min(c, path[a][b]);
    
    for i in range(1, n+1):
        que = [];
        for j in range(1, n+1):
            if path[i][j] < MAX_COST and i != j:
                 que.append((i,j,path[i][j]));
        while que:
            a,b,cost = que.pop(0);
            for j in range(1, n+1):
                if b != j and a != j and path[b][j] != MAX_COST and cost + path[b][j] < path[a][j]:
                    path[a][j] = cost + path[b][j];
                    que.append((a,j, path[a][j]));
    # print(path)
    for i in range(1, n+1):
        answer = [];
        for j in range(1, n+1):
            cost = path[i][j] if path[i][j] < MAX_COST and i != j else 0;
            answer.append(cost);
        print(*answer);
    return True;
  
n = int(sys.stdin.readline());
m = int(sys.stdin.readline());
myList = [list(map(int,sys.stdin.readline().split())) for i in range(m)];
solution(n, m, myList);