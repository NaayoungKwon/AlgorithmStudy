import sys
import itertools

def solution(n, m, arr):
    
    # homes를 전부 구한다
    homes = []
    markets = []
    # markets를 전부 구한다
    for i in range(n):
        for j in range(n):
            if arr[i][j] == 1:
                homes.append([i,j])
            elif arr[i][j] == 2:
                markets.append([i,j])
    # hl (home과의 거리) [i][j] = home[i]와 market[j]와의 거리
    hl = [[0] * len(markets) for _ in range(len(homes))]
    for i in range(len(homes)):
        for j in range(len(markets)):
            l = abs(homes[i][0] - markets[j][0]) + abs(homes[i][1] - markets[j][1])
            hl[i][j] = l

    # markets 중 m개를 픽 kCm
    mk = 10000 * 100
    for ks in itertools.combinations(list(range(len(markets))), m):
        mi = 0
        for i in range(len(homes)):
            mr = 10000
            for k in ks:
                mr = min(mr, hl[i][k])
            mi += mr
        mk = min(mk, mi)
    # homes에서 min을 각각 구한다
    return mk


n,m = map(int,sys.stdin.readline().split(' '));
myList = [list(map(int,sys.stdin.readline().split(' '))) for i in range(n)];
print(solution(n, m, myList));