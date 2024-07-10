import sys

def solution(s):
    
    n = len(s)
    wall = n-1
    for i in range(n-2, -1, -1):
        if s[i+1] > s[i]: # 작아지면 멈춰
            wall = i
            break
    for i in range(n-1, wall, -1):
        if s[wall] < s[i]:
            s[wall], s[i] = s[i], s[wall]
            break
    
    return ''.join(s[:wall+1] + sorted(s[wall+1:]))


t = int(sys.stdin.readline());
for _ in range(t):
    s = sys.stdin.readline().split()[0]
    print(solution(list(s)));