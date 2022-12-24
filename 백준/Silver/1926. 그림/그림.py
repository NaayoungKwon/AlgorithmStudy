import sys

def 범위안인가(a,b,i):
    dir = [[1,0],[0,1], [-1,0],[0,-1]];
    return a + dir[i][0] >= 0 and a + dir[i][0] < n and b + dir[i][1] >= 0 and b + dir[i][1] < m
def solution(n,m,paint):

    max_size = 0;
    count = 0;
    dir = [[1,0],[0,1], [-1,0],[0,-1]];
    for i in range(n):
        for j in range(m):
            if paint[i][j] == 1:
                que = [(i,j)];
                paint[i][j] = 0;
                s = 0;
                count += 1;
                while que:
                    a, b = que.pop();
                    s += 1;
                    for k in range(4):
                        if 범위안인가(a,b,k) and paint[a+dir[k][0]][b+dir[k][1]] == 1:
                            paint[a+dir[k][0]][b+dir[k][1]] = 0;
                            que.append((a+dir[k][0],b+dir[k][1]));
                max_size = max(max_size , s);
    print(count);
    print(max_size);             
    return True;
  
n, m = map(int,sys.stdin.readline().split(' '));
myList = [list(map(int,sys.stdin.readline().split(' '))) for i in range(n)];
solution(n, m, myList);