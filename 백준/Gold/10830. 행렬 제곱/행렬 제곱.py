import sys

def multiply(q,w):
    l = len(q)
    mat = [[0] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            s = 0
            for u in range(n):
                s += q[i][u] * w[u][j]

            mat[i][j] = s % 1000
    return mat

def solution(mat, x):

    if x == 1:
        return mat

    new_x = 0
    div_x = solution(mat, x//2)
    new_x =  multiply(div_x, div_x)
    if x % 2 == 1:
        new_x = multiply(new_x ,mat)
    
    return new_x

n,b = map(int,sys.stdin.readline().split());
pan = [list(map(int,sys.stdin.readline().split())) for _ in range(n)]
for i in range(n):
    for j in range(n):
        pan[i][j] %= 1000
result = solution(pan, b)
for arr in result:
    print(*arr)