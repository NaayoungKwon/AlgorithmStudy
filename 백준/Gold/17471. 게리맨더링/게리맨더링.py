import sys
import itertools

def is_adj(n, l, map_):
    visited = [False] * n
    for b in set(range(n)) - set(l):
        visited[b] = True
    
    que = [l[0]]
    while que:
        node = que.pop(0)
        visited[node] = True
        for b in range(n):
            if visited[b] or map_[node][b] == False:
                continue
            que.append(b)
    return len(set(visited)) == 1

def solution(n, people, arr):
    result = 10000
    adj = [[False] * n for _ in range(n)]
    for i in range(n):
        for j in arr[i]:
            adj[i][j-1] = True
            adj[j-1][i] = True
    
    for k in range(1, n//2 +1):
        for ls in itertools.permutations(range(n), k):
            if not is_adj(n, ls, adj):
                continue
            rs = list(set(range(n)) - set(ls))
            if not is_adj(n, rs, adj):
                continue
            m = abs(sum([people[a] for a in ls]) - sum([people[b] for b in rs]))
            result = min(result, m)

    return result if result < 10000 else -1


n = int(sys.stdin.readline());
arr = list(map(int,sys.stdin.readline().split(' ')));
myList = [list(map(int,sys.stdin.readline().split(' ')[1:])) for i in range(n)];
print(solution(n, arr, myList));