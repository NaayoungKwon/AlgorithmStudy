import sys
import collections
def solution(n, arr, parent, children):
    
    next = collections.deque()
    dp = [[0] * 2 for _ in range(n+1)]
    leaf = set()
    see = [0] * (n+1)

    for i in range(1, n+1):
        if len(children[i]) == 0:
            leaf.add(i)
    for e in leaf:
        next.append(e)

    while next:
        node = next.popleft()
        if node in leaf:
            dp[node][1] = arr[node]
        else:
            s = 0
            p = 0
            for child in children[node]:
                s += dp[child][0]
                p += max(dp[child])
            dp[node][1] = s + arr[node]
            dp[node][0] = p
        # print(node, dp[node])
        if parent[node] > 0:
            see[parent[node]] +=1
            if see[parent[node]] == len(children[parent[node]]):
                next.append(parent[node])
        else:
            return max(dp[node])


    return 0


n = int(sys.stdin.readline());
arr = list(map(int,sys.stdin.readline().split(' ')));
child = [[] for _ in range(n+1)]
parent = [-1] * (n+1)
for _ in range(n-1):
    a, b = map(int,sys.stdin.readline().split(' '))
    a, b = min(a,b), max(a,b)
    if parent[b] != -1 : # 이미 부모가 있음
        a,b = b,a
    child[a].append(b)
    parent[b] = a
print(solution(n, [0] +arr, parent, child));