import sys
import itertools

def solution(n):
    if n < 10:
        return (n % 2, n % 2);

    s = sum([1 for i in str(n) if int(i) % 2 == 1])
    if n < 100:
        a = solution((n//10) + (n % 10))[0]
        return (s+a, s+a)

    sn = str(n)
    min_r = n
    max_r = 0
    for a,b in itertools.combinations(range(1,len(sn)), 2):
        r = solution(int(sn[:a]) + int(sn[a:b]) + int(sn[b:]))
        min_r = min(min_r, s+ r[0])
        max_r = max(max_r, s+ r[1])
                

    return (min_r, max_r)


n = int(sys.stdin.readline());
print(*solution(n));