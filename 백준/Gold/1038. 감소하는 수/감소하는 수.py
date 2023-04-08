import sys
from itertools import combinations
from math import comb


def solution2(n):
    if n <= 10:
        return n;

    cnt = 9;
    i = 0;
    for i in range(2,12):
        s = comb(10,i)
        if cnt + s < n:
            cnt += s
        else:
            break;

    if i == 11:
        return -1
    arr = []
    for com in combinations(range(10), i):
        r = list(com)
        r.sort(reverse=True)
        re = ''.join(str(c) for c in r)
        arr.append(re)
    
    arr.sort()
    return arr[n-cnt-1]


n = int(sys.stdin.readline());
print(solution2(n));