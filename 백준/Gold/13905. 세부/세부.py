import sys
import heapq

def solution(n, s,e,load):

    path = [0] * (n+1);
    que = [(s,2000000)];
    while que:
        b, c = heapq.heappop(que);
        # print('pop ', b,c);
        if c >= path[b]:
            path[b] = c;
            for j , l in load[b]:
                k = min(c,l);
                if path[j] < k:
                    path[j] = k;
                    heapq.heappush(que, (j, k));

    return path[e];

n,m = map(int,sys.stdin.readline().split());
arr = [[] for _ in range(n+1)];
s, e = map(int,sys.stdin.readline().split());
for _ in range(m):
    a,b,c = map(int,sys.stdin.readline().split());
    arr[a].append((b,c));
    arr[b].append((a,c));
print(solution(n, s,e, arr));