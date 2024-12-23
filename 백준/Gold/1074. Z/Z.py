import sys
import math


def solution(n, r, c):
    
    if r < 2 and c < 2:
        map_ = [[0,1],[2,3]]
        return map_[r][c]
    elif r <= c:
        k = 2 ** (int(math.log2(c)))
        return k*k + solution(n, r, c-k)
    else:
        k = 2 ** (int(math.log2(r)))
        return 2*k*k + solution(n, r-k, c)


n,r,c = map(int,sys.stdin.readline().split(' '));
print(solution(n,r,c));