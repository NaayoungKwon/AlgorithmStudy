import sys
import heapq

MAX_PRICE = 2000000*500000 + 1; 

def solution(n,a,b,c,path):

    dist = [MAX_PRICE] * (n+1);
    arr = [(0,a,0)];
    result = 0;
    while arr:
        max_price, e, total_len = heapq.heappop(arr);
        if dist[e] < max_price:
            continue;
        for x, l in path[e]:
            if total_len + l <= c and max(max_price, l) < dist[x]:
                dist[x] = max(max_price, l);
                heapq.heappush(arr,(dist[x], x, total_len + l));

    return (dist[b] if dist[b] < MAX_PRICE else -1 );
  
n,m,a,b,c = map(int,sys.stdin.readline().split());
path = [[] for _ in range(n+1)];
for _ in range(m):
    s,e,l = map(int,sys.stdin.readline().split());
    path[s].append((e,l));
    path[e].append((s,l));
print(solution(n,a,b,c,path));