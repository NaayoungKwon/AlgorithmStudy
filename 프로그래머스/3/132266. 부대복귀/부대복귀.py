import heapq
MAX_DIST = 10000 * 5000

def solution(n, roads, sources, destination):
    answer = []
    path = [[] for _ in range(n+1)];
    for r in roads:
        a,b = r
        path[a].append((b));
        path[b].append((a));
    
    dist = dsj(destination, path,n)
    for start in sources:
        answer.append((dist[start] if dist[start] < MAX_DIST else -1))
    return answer


def dsj(start, path, n):
    arr = [(0,start)];
    dist = [MAX_DIST] * (n + 1);
    dist[start] = 0;

    while arr:
        l, last = heapq.heappop(arr);
        if dist[last] >= l:
            for b in path[last]:
                if dist[b] > l + 1:
                    dist[b] = l + 1;
                    heapq.heappush(arr, (l+1, b));
    return dist;