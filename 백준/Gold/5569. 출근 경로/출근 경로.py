import sys

def 오른쪽으로(x):
    return (x[3],0,x[0]+x[2],0);
def 위로(x):
    return (0,x[2],0,x[1]+x[3]);

def solution(w,h):

    load = [[(0,0,0,0)] * (w+1) for _ in range(h+1)];
    for i in range(1,w+1):
        load[1][i] = (0,0,1,0);

    for i in range(1, h+1):
        load[i][1] = (0,0,0,1);

    for i in range(1, h+1):
        for j in range(1, w+1):
            if j+1 <= w and i>1:
                a,b,c,d = 오른쪽으로(load[i][j]);
                load[i][j+1] = (load[i][j+1][0] + a, load[i][j+1][1] + b, load[i][j+1][2] + c, load[i][j+1][3] + d);
            if i+1 <= h and j>1:
                a,b,c,d = 위로(load[i][j]);
                load[i+1][j] = ( load[i+1][j][0]+a, load[i+1][j][1]+b, load[i+1][j][2]+c, load[i+1][j][3]+d );
    # for i in range(1,h+1):
    #     print(load[i][1:])
    return sum(load[h][w]) % 100000;

w,h = map(int,sys.stdin.readline().split());
print(solution(w,h));