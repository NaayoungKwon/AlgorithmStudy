import sys
import heapq;

NO_PATH = 10000 * 500000;
def 다익스트라(n, home, path):
    
    heap_ = [];
    dist = [NO_PATH] * (n+1);
    dist[home] = 0;
    heapq.heappush(heap_, (0,home));
    while heap_:
        l, node = heapq.heappop(heap_);
        if dist[node] < l:
            continue;
        for i in path[node]:
            # print(node, i, path[home][i], path[node][i], dist[i]);
            cost = l + i[1];
            if node != i and i[1] != NO_PATH and cost < dist[i[0]]:
                # print(home, node, i , cost, dist[i]);
                dist[i[0]] = cost;
                heapq.heappush(heap_, (cost,i[0]));
    return dist;

def solution(n, m, A,B,C, path):

    our_home = list(set([A,B,C]));
    min_len = [NO_PATH] * (n+1);

    for home in our_home:
        this_len = 다익스트라(n, home, path);
        # print(home, this_len);
        for i in range(1,n+1):
            min_len[i] = min(min_len[i], this_len[i]);

    return min_len.index(max(min_len[1:]));
  
n = int(sys.stdin.readline());
a,b,c = map(int,sys.stdin.readline().split());
m = int(sys.stdin.readline());
myMap = [[] for _ in range(n+1)];
for i in range(m):
    d,e,l = map(int,sys.stdin.readline().split());
    myMap[d].append((e,l));
    myMap[e].append((d,l));
print(solution(n,m,a,b,c,myMap));