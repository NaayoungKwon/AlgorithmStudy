import sys

def solution(n, m, l, k, arr):
    
    xs = sorted(list(set([x[0] for x in arr])))
    ys = sorted(list(set([y[1] for y in arr])))

    mc = 0
    for x in xs:
        for y in ys:
            # if x + l >= n or y + l >= m:
            #     continue
            c = 0
            for a,b in arr:
                if x <= a <= x+l and y <= b <= y+l:
                    c += 1
            mc = max(mc, c)

    return k - mc


# n = int(sys.stdin.readline());
n,m,l,k = map(int,sys.stdin.readline().split(' '));
myList = [list(map(int,sys.stdin.readline().split(' '))) for i in range(k)];
print(solution(n, m, l, k, myList));