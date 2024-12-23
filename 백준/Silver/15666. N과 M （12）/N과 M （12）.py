import sys
# import itertools
# def solution(n, m, arr):
#     for l in sorted(set(list(itertools.combinations(arr, m)))):
#         print(*l)



n,m = map(int,sys.stdin.readline().split(' '));
arr = list(map(int,sys.stdin.readline().split(' ')))
# solution(n, m, sorted(list(set(arr))*m));

# n,m = map(int, input().split())

s = []
result = []
se = set()

def dfs(arr, start):
    if len(s)==m:
        result.append(' '.join(map(str,sorted(s))))
        return
    
    for i in range(start, n):
        s.append(arr[i])
        dfs(arr, i)
        s.pop()
    
dfs(sorted(arr), 0)
for c in result:
    if c not in se:
        print(c)
        se.add(c)