import sys
import heapq

def solution(n, link,lenArr):
    # print(info)
    result = [];
    # link = [[] for i in range(n+1)];
    # for a, b in info:
    #     link[b].append(a);
    # lenArr = [0] * (n+1);
    # for i in range(1,n+1):
    #     lenArr[i] = len(link[i]);
    
    que = [];
    # print(link);
    for i in range(1,n+1):
        if lenArr[i] == 0 and i not in result:
            heapq.heappush(que, i);
    # que += [ i for i in range(1,n+1) if len(link[i]) == 0 and i not in result];
    while que:
        # print(que);
        node = heapq.heappop(que);
        result.append(node);
        for i in link[node]:
            lenArr[i] -= 1;
            if lenArr[i] == 0:
                heapq.heappush(que, i);
        # print(que);
        
        # que += [ i for i in range(1,n+1) if len(link[i]) == 0 and i not in result and i not in que];
        # que.sort();
    
    return result;
  
n, m = map(int,sys.stdin.readline().split());
link = [[] for i in range(n+1)];
lenArr = [0] * (n+1);
for i in range(m):
    a, b =map(int,sys.stdin.readline().split());
    link[a].append(b);
    lenArr[b] += 1;
# myList = [list(map(int,sys.stdin.readline().split())) for i in range(m)];
print(*solution(n, link, lenArr));