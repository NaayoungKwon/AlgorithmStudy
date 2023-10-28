import sys

def cut(k,trees):
    cnt = 0
    for tree in trees:
        cnt += max(0,tree-k)
    return cnt;

def solution(n,m,trees,s,e):

    if s >= e:
        return e;

    k = (s + e) // 2;
    cnt = cut(k,trees)

    if m <= cnt:
        if s == k or k == e:
            return k
        return max(k, solution(n,m,trees,k,e))
    else:
        return max(0, solution(n,m,trees,s,k))

n,m = map(int,sys.stdin.readline().split());
myList = list(map(int,sys.stdin.readline().split())) ;
print(solution(n, m,myList,0,max(myList)));