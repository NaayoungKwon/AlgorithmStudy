import sys

def solution(s, t):
    max_len = len(t)

    que = [s]
    while que:
        n = que.pop(0)
        if len(n) > max_len:
            continue
        n1 = n + 'A'
        n2 = (n + 'B')[::-1]
        if n1 == t or n2 == t:
            return 1
        if n1 in t or n1[::-1] in t:
            que.append(n1)
        if n2 in t or n2[::-1] in t:
            que.append(n2)
    return 0


s = (sys.stdin.readline().split('\n')[0]);
t = (sys.stdin.readline().split('\n')[0]);
print(solution(s, t));