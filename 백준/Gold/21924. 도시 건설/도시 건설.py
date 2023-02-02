import sys
import heapq

def find(path, i):
    if path[i] != i:
        path[i] = find(path,path[i]);
    return path[i];

def solution(n, total, load):

    path = [1] * (n+1);
    for i in range(1,n+1):
        path[i] = i;

    cnt = 0;
    while load:
        c, a,b = heapq.heappop(load);
        f_a = find(path, a);
        f_b = find(path, b);
        if f_a < f_b:
            path[f_b] = f_a;
        elif f_a > f_b:
            path[f_a] = f_b;
        elif f_a == f_b:
            continue;
        cnt += 1;
        total -= c;

        if cnt == n-1:
            return total;

    return -1;

n,m = map(int,sys.stdin.readline().split());
myList = [];
s = 0;
for _ in range(m):
    a,b,c = map(int,sys.stdin.readline().split());
    s += c;
    heapq.heappush(myList, (c,a,b));
print(solution(n, s, myList));