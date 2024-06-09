import sys

visited = []
result = 999999999

def find_m(cur, cnt, l, n, pan):
    global result
    if cnt == n:
        result = min(result, l)
        return 
    
    for i in range(n):
        if visited[i] == True:
            continue
        
        visited[i] = True
        find_m(i, cnt+1, l + pan[cur][i], n , pan)
        visited[i] = False


def solution(n, k, pan):
    visited[k] = True

    for x in range(n):
        for i in range(n):
            for j in range(n):
                pan[i][j] = min(pan[i][j], pan[i][x] + pan[x][j])
    
    find_m(k,1,0,n,pan)
    return result


n,k = map(int,sys.stdin.readline().split(' '));
visited = [False] * n
myList = [list(map(int,sys.stdin.readline().split(' '))) for i in range(n)];
print(solution(n, k, myList));