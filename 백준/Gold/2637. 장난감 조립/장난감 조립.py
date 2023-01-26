import sys
from collections import deque;

def solution(n, parts):

    degree = [0] * (n+1);
    que = deque();
    visited = [False] * (n+1);
    result = [0] * (n+1);
    
    for i in range(1,n+1):
        for y, k in parts[i]:
            degree[y] += 1;
    while True:
        for i in range(1,n+1):
            if visited[i] == False and degree[i] == 0:
                que.append(i);
                visited[i] = True;
        
        if len(que) == 0:
            break;

        key = que.popleft();
        for y, k in parts[key]:
            need = k * (result[key] if result[key] > 0 else 1);
            result[y] += need;
            degree[y] -= 1;
    
    for i in range(1,n+1):
        if len(parts[i]) == 0:
            print(str(i) + ' ' + str(result[i]))

n = int(sys.stdin.readline());
m = int(sys.stdin.readline());
myList = [[] for _ in range(n+1)];
for _ in range(m):
    x,y,k = map(int,sys.stdin.readline().split());
    myList[x].append([y,k]);
solution(n, myList);