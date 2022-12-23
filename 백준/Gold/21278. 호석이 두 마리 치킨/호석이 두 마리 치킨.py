import sys
import itertools

MAX_LEN = 101
def solution(n, city):

    for i in range(1,n+1):
        que = [(k,1) for k in range(1, n+1) if city[i][k] == 1];
        while que:
            k, l = que.pop(0);
            for j in range(1, n+1):
                if city[k][j] + l < city[i][j]:
                    city[i][j] = city[k][j] + l;
                    que.append((j, city[i][j]));
    min_result = MAX_LEN * n * n;
    min_idx = [0,0];
    for a, b in itertools.combinations(range(1,n+1), 2):
        s = 0;
        for i in range(1,n+1):
            s += min(city[a][i], city[b][i]);
        if min_result > s:
            min_result = s;
            min_idx = [a,b];
    return min_idx + [min_result *2];
  
n,m = map(int,sys.stdin.readline().split());
city = [[MAX_LEN] * (n+1) for _ in range(n+1)];
for i in range(m):
    A, B = map(int,sys.stdin.readline().split());
    city[A][B] = city[B][A] = 1;
for i in range(1,n+1):
    city[i][i] = 0;
print(*solution(n, city));