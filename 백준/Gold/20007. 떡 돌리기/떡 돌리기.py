import sys
import heapq

MAX_DIST = 10000 * 5000

def dystra(start, path):
    arr = [(start,0)];
    dist = [MAX_DIST] * (len(path));
    dist[start] = 0;

    while arr:
        last, l = heapq.heappop(arr);
        if dist[last] >= l:
            for b, c in path[last]:
                if dist[b] > l + c:
                    dist[b] = l + c;
                    heapq.heappush(arr, (b, l+c));
    # print(dist)
    return dist[:start] + dist[start+1:];

def solution(n, m, x, y, path):
    
    dist = dystra(y, path)
    dist.sort()

    if max(dist) * 2 > x:
        return -1
    
    s = 0
    cnt = 0
    # print(dist)
    for d in dist:
        if 2*d + s > x:
            s = 2*d
            cnt += 1
        else:
            s += (2*d)
    
    if s > 0:
        cnt += 1
    return cnt


# n = int(sys.stdin.readline());
n,m,x,y = map(int,sys.stdin.readline().split(' '));
path = [[] for _ in range(n)];
for _ in range(m):
    a,b,c =  map(int,sys.stdin.readline().split(' '));
    path[a].append((b,c));
    path[b].append((a,c));
print(solution(n, m, x, y, path));