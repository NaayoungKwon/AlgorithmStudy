import sys
import heapq

def isLoop(a,b,parent):
    rootA = parent[a];
    rootB = parent[b];
    if ((rootA < rootB and rootA == a) or (rootA > rootB and rootB == b)) and rootA == rootB:
        return False;
    return True;

def union(a,b,parent):
    
    rootA = parent[a];
    rootB = parent[b];
    if rootA < rootB:
        parent[b] = rootA;
        for i in range(1, len(parent)):
            if parent[i] == rootB:
                parent[i] = rootA;
    else:
        parent[a] = rootB;
        for i in range(1, len(parent)):
            if parent[i] == rootA:
                parent[i] = rootB;
    
def solution(n, que):
    # visited = [False] * (n+1);
    # visited[0] = True;
    result = 0;
    parent = [i for i in range(n+1)];
    
    while any( parent[i] != 1 for i in range(1,n+1)):
        temp, (a, b, l) = heapq.heappop(que);
        if parent[a] != parent[b]:
            # visited[a] = True;
            # visited[b] = True;
            union(a,b,parent);
            result += l;
            
    return result;
  
n,v = map(int,sys.stdin.readline().split());
myList = [];
# map_ = [[0] * n for i in range(n)];
for i in range(v):
    a, b, c = map(int,sys.stdin.readline().split());
    heapq.heappush(myList, (c, (a,b,c)));
    
print(solution(n, myList));

# 5 5
# 1 4 3
# 2 3 3
# 4 3 5
# 2 1 6
# 4 5 9
# 답 : 20