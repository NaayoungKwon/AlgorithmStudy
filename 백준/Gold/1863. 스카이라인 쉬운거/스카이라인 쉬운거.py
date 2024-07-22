import sys

def solution(n, arr):
    cnt = 0
    s = set()
    prev = -1

    for c, h in arr:
        if h == 0:
            s = set()
        elif h not in s:
            cnt += 1
        
        if prev > h:
            for k in range(h+1, prev+1):
                if k in s:
                    s.remove(k)

        prev = h
        s.add(h)
    return cnt


n = int(sys.stdin.readline());
arr = []
for _ in range(n):
    a,b = map(int,sys.stdin.readline().split(' '));
    arr.append((a,b))
print(solution(n, arr));