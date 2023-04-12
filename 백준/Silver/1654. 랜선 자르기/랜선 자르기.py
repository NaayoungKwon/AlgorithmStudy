import sys

def getcnt(rows, k):
    cnt = 0
    for row in rows:
        cnt += (row // k)
    return cnt

def solution(n,rows,s,e):

    if s > e:
        return e;

    k = (s+e)//2
    cnt = getcnt(rows, k)

    if n <= cnt: # 너무 잘게 자름
        return solution(n,rows, k+1, e)
    elif n > cnt: # 너무  크게 자름
        return solution(n,rows, s, k-1)

k,n = map(int,sys.stdin.readline().split());
myList = [int(sys.stdin.readline()) for _ in range(k)];
print(solution(n, myList,1, sum(myList)));