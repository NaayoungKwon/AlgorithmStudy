import sys
import itertools
def solution(n, m, arr):
    for l in sorted(set(list(itertools.permutations(arr, m)))):
        print(*l)



n,m = map(int,sys.stdin.readline().split(' '));
arr = list(map(int,sys.stdin.readline().split(' ')))
solution(n, m, sorted(arr));