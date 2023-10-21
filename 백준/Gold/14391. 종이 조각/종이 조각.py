import sys

def findCur(n, m, visited):
    for a in range(n):
        for b in range(m):
            if visited[a][b] == False:
                return (a,b)
            
    return (-1,-1)
            
def dfs(n, m,  arr, visited, result):
    sum = 0
    max_result = result
    i, j = findCur(n, m, visited)
    if i == -1 and j == -1:
        return result

    for x in range(i, n+1):
        if x == n or visited[x][j] :
            for a in range(i, min(x,n)):
                visited[a][j] = False
            break
        else:
            sum = 10* sum + arr[x][j]
            visited[x][j] = True
            max_result = max(max_result, dfs(n,m, arr, visited, result + sum))
    
    sum = 0
    for y in range(j, m+1):
        if y == m or visited[i][y]:
            for b in range(j, min(y, m)):
                visited[i][b] = False
            break
        else:
            sum = sum * 10 + arr[i][y]
            visited[i][y] = True
            max_result = max(max_result, dfs(n,m, arr, visited, result + sum))
    
    return max_result

def solution(n, m, arr):
    visited = [[False] * m for i in range(n)]
    return dfs(n, m,  arr, visited, 0)


n,m = map(int,sys.stdin.readline().split(' '));
myList = []
for i in range(n):
    s = sys.stdin.readline();
    myList.append([int(c) for c in s[:-1]])
print(solution(n, m, myList));