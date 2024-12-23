import sys
import itertools
def solution(n, m):
    for l in sorted(list(itertools.combinations(range(1,n+1), m))):
        print(*l)



n,m = map(int,sys.stdin.readline().split(' '));
solution(n, m);