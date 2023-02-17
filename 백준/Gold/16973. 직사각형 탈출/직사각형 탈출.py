import sys
from collections import deque;

def isEmpty(load, new_a, new_b, h, w,i):
    if i == 0 : # 오른쪽
        for j in range(h):
            if load[new_a + j][new_b+w-1] == 1:
                return False;
    elif i == 1 : # 아래
        for j in range(w):
            if load[new_a+h-1][new_b + j] == 1:
                return False;
    elif i == 2: # 왼쪽
        for j in range(h):
            if load[new_a + j][new_b] == 1:
                return False;
    elif i == 3: # 위로
        for j in range(w):
            if load[new_a][new_b + j] == 1:
                return False;
    return True;

def solution(n, m, load, h,w,sr,sc,fr,fc):
    arr = deque();
    arr.append((sr,sc,0));
    # arr = [(sr,sc,0)];
    dir = [[0,1],[1,0],[0,-1],[-1,0]];
    visited = [[False] * m for _ in range(n)];
    visited[sr][sc] = True;
    while arr:
        a,b,l = arr.popleft();
        for i, (x, y) in enumerate(dir):
            new_a = a + x;
            new_b = b + y;
            if new_a == fr and new_b == fc:
                return l+1;
            # print(new_a, new_b, isEmpty(load, new_a, new_b, h,w))
            if new_a >= 0 and new_a + h <= n and new_b >= 0 and new_b +w <= m:
                if visited[new_a][new_b] == False and isEmpty(load, new_a, new_b, h, w,i) :
                    arr.append((new_a, new_b, l+1 ));
                    visited[new_a][new_b] = True;
                    # print(new_a, new_b ,l+1)

    return -1;

n,m = map(int,sys.stdin.readline().split());
myList = [list(map(int,sys.stdin.readline().split())) for _ in range(n)];
h,w,sr,sc,fr,fc = map(int,sys.stdin.readline().split());
print(solution(n, m,myList, h,w,sr-1,sc-1,fr-1,fc-1));