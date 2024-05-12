import sys

p = [0,1,1,1,2,2,3,4,5,7,9,12]

def solution(n):
    
    if n < 12:
        return p[n]
    
    p[n-1] = solution(n-1) if p[n-1] == 0 else p[n-1]
    p[n-5] = solution(n-5) if p[n-5] == 0 else p[n-5]
    return p[n-1] + p[n-5]

t = int(sys.stdin.readline());
for _ in range(t):
    n = int(sys.stdin.readline());
    p = [0,1,1,1,2,2,3,4,5,7,9,12] + [0] * (n-12)
    print(solution(n))