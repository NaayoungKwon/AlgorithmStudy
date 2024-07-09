import sys

def solution(n, l ,j):
    hp = [0] * 101
    arr = [(l[i], j[i]) for i in range(n)]
    arr.sort()

    for i in range(n):
        for p in range(100, -1, -1):
            a = p - arr[i][0]
            if a > 0:
                hp[p] = max(hp[p], hp[a] + arr[i][1])

    happy = max(hp)
    return happy


n = int(sys.stdin.readline());
l = list(map(int,sys.stdin.readline().split(' ')));
j = list(map(int,sys.stdin.readline().split(' ')));
print(solution(n, l, j));