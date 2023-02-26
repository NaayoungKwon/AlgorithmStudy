import sys
import heapq

max_l = int(1e9);
def 다익스트라(load,n,x):

    path = [max_l] * (n+1);
    que = [(x,0)];
    path[x] = 0;
    while que:
        end, l = heapq.heappop(que);
        if path[end] < l:
            continue;
        
        for e, el in load[end]:
            if l + el < path[e] :
                path[e] = l + el;
                heapq.heappush(que, (e, path[e]));
    return path;

def solution(n, m,x,load):

    result = [0] * (n+1);
    for i in range(1,n+1):
        path = 다익스트라(load, n,i);
        if i != x:
            result[i] += path[x];
        else:
            for j in range(1,n+1):
                result[j] += path[j];
    # print(path)
    max_result = 0;
    for i in range(1,n+1):
        if i == x:
            continue;
        max_result = max(max_result, result[i]);

    return max_result;

n,m,x = map(int,sys.stdin.readline().split());
myList = [[] for _ in range(n+1)];
for _ in range(m):
    a,b,c = map(int,sys.stdin.readline().split());
    myList[a].append((b,c));
print(solution(n, m,x ,myList));