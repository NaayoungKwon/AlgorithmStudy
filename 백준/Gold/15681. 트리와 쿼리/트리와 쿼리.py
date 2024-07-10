import sys
sys.setrecursionlimit(1000000000) 

visited = []
def dfs(n, i, line):

    s = 1
    for e in line[i]:
        if visited[e] > 0:
            continue
        visited[e] += 1
        s += dfs(n, e, line)
    visited[i] = s
    return s

def solution(n, r, line, us):
    
    visited[r] = 1
    visited[r] = dfs(n, r, line)

    for u in us:
        print(visited[u])


n,r,q = map(int,sys.stdin.readline().split(' '));
visited = [0] * (n+1)
line = [[] for _ in range(n+1)]
for _ in range(n-1):
    a,b  = map(int,sys.stdin.readline().split(' '));
    line[a].append(b)
    line[b].append(a)
us = [int(sys.stdin.readline()) for i in range(q)]
solution(n, r, line, us);