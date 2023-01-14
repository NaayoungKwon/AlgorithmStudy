import sys
import heapq

NO_PATH = 50001;
def 다익스트라(start, n, load):
    path = [NO_PATH] * (n+1);
    arr = [(start,0)];
    path[start] = 0;

    while arr:
        last, l = heapq.heappop(arr);
        if path[last] < l:
            continue;
        for end in load[last]:
            if l + 1 < path[end]:
                path[end] = l +1;
                heapq.heappush(arr, (end, l+1));
    for i in range(n+1):
        if path[i] == NO_PATH:
            path[i] = 0;
    return path;

def solution(n, m, load):

    result = 0;
    path = 다익스트라(1,n,load);
    # print(path)
    max_len = max(path);
    idx = path.index(max_len);
    cnt = path.count(max_len);
    return [idx, max_len, cnt];

n, m = map(int,sys.stdin.readline().split());
myList = [[] for _ in range(n+1)];
for _ in range(m):
    a, b = map(int,sys.stdin.readline().split());
    myList[a].append(b);
    myList[b].append(a);
print(*solution(n, m, myList));