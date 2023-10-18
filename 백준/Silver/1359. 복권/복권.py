import sys
import itertools

def solution(n,m,k):
    arr = range(1, n+1);

    count = 0;
    turn = 0;
    for myArr in itertools.combinations(arr, m):
        for yourArr in itertools.combinations(arr, m):
            if len(set(myArr) & set(yourArr) ) >= k:
                count +=1;
            turn += 1;

    return count / turn

n,m,k = map(int,sys.stdin.readline().split());
print(solution(n, m, k));