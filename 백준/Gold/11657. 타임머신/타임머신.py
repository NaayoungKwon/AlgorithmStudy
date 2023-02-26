import sys
INF = float('inf');
def solution(n, m,load):

    result = 0;
    dist = [INF] * (n+1);

    dist[1] = 0;

    for i in range(1,n+1):
        for j in range(m):
            start, end, l = load[j];
            if dist[start] != INF and dist[end] > dist[start] + l:
                dist[end] = dist[start] + l;
                if i == n:
                    print(-1);
                    return True;
    for i in range(2,n+1):
        if dist[i] == INF:
            print(-1);
        else:
            print(dist[i])        
    return True;

n ,m = map(int,sys.stdin.readline().split());
myList = [list(map(int,sys.stdin.readline().split())) for _ in range(m)];
solution(n, m, myList);