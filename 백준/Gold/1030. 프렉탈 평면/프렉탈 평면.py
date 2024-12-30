import sys

def find(i,j,l,n,k):
    if l == 1:
        return '0'
    c = l//n
    if c*(n-k)//2 <= i < c*(n+k)//2 and c*(n-k)//2 <= j < c*(n+k)//2:
        return '1'
    return find(i%c, j%c, c,n,k)
    
def solution(s,n,k,r1,r2,c1,c2 ):

    
    result = []
    l = n ** s
    for i in range(r1, r2+1):
        r = ''
        for j in range(c1, c2+1):
            r += find(i,j,l,n,k)
        result.append(r)

    for r in result:
        print(r)

s,n,k,r1,r2,c1,c2 = map(int,sys.stdin.readline().split(' '));
solution(s,n,k,r1,r2,c1,c2 )