import sys

def solution(h, w, x, y ,B):

    A = [[0] * w for _ in range(h)]

    for i in range(h):
        for j in range(w):
            if i >= x and j >= y:
                A[i][j] = B[i][j] - A[i-x][j-y]
            else:
                A[i][j] = B[i][j]
    
    for i in range(h):
        print(*A[i])

h, w, x, y = map(int,sys.stdin.readline().split());
myList = []
for _ in range(h+x):
    l = list(map(int,sys.stdin.readline().split())) ;
    myList.append(l)
solution(h, w, x, y , myList);