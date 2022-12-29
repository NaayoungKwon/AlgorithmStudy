import sys
import heapq;

def 다익스트라(start, path):

    arr = [(start,0)];
    dist = [10000 * 5000] * (len(path) + 1);
    dist[start] = 0;

    while arr:
        last, l = heapq.heappop(arr);
        if dist[last] >= l:
            for b, c in path[last]:
                if dist[b] > l + c:
                    dist[b] = l + c;
                    heapq.heappush(arr, (b, l+c));
    # print(dist);
    return dist;

def solution(v,p,path):

    dist = 다익스트라(1,path);
    p_to_v = (다익스트라(p,path))[v];
    
    if dist[v] == dist[p] + p_to_v:
        return 'SAVE HIM';
    else:
        return 'GOOD BYE';

v, e, p = map(int,sys.stdin.readline().split());
path = [[] for _ in range(v+1)];
for _ in range(e):
    a,b,c =  map(int,sys.stdin.readline().split());
    path[a].append((b,c));
    path[b].append((a,c));
print(solution(v,p,path));