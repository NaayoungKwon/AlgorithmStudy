import sys

def dir(arr, k):
    if k == 1:
        return arr
    elif k == 2:
        return [arr[0] | arr[2], arr[1] | arr[3]]
    elif k == 3:
        return [arr[0] | arr[1], arr[1] | arr[2],  arr[2] | arr[3] , arr[3] | arr[0] ]
    elif k == 4:
        return [arr[0] | arr[1] | arr[2], arr[1] | arr[2] | arr[3], arr[2] | arr[3] | arr[0], arr[3] | arr[0] | arr[1]]
    elif k == 5:
        return [arr[1] | arr[3] | arr[0] | arr[2]]

def make_set(i,j, pans,n,m):
    arr = []
    for a,b in [[0,1],[1,0],[0,-1],[-1,0]]:
        k = 0
        s = set()
        while True:
            if i + a*k >= n or j + b*k >= m or i + a*k < 0 or j + b*k < 0 or pans[i+ a*k][j + b*k] == 6:
                break;
            if pans[i+ a*k][j + b*k] == 0:
                s.add((i+ a*k, j + b*k))
            k += 1
        arr.append(s)
    return dir(arr, pans[i][j]);

def solution(n, m, pans):

    result = 0;
    k = 0;
    block = 0
    que = []
    for i in range(n):
        for j in range(m):
            if pans[i][j] in [1,2,3,4,5]:
                k += 1;
                que.append((i,j))
            elif pans[i][j] == 6:
                block += 1
    boards = [[] for _ in range(k)]
    if len(que) == 0:
        return n*m - block

    for i in range(k):
        s_list = make_set(que[i][0], que[i][1], pans,n,m)
        for s in s_list:
            for b in (boards[i-1] if i > 0 else [set()]):
                new_s = s | b
                boards[i].append(new_s)

    for i in range(len(boards[k-1])):
        result = max(result, len(boards[k-1][i]))
    return n*m - len(que) - block - result

n,m = map(int,sys.stdin.readline().split());
myList = [list(map(int,sys.stdin.readline().split(' '))) for _ in range(n)];
print(solution(n, m, myList));