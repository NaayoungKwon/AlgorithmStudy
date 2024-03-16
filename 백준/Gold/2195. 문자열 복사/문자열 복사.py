import sys

def solution(s, p):

    cnt = 1
    idx = 0
    for i in range(len(p)):
        if s.find(p[idx : i+1]) >= 0: # p안에 s의 부분집합이 있다
            continue
        cnt += 1
        idx = i
    return cnt

s = input()
p = input()
print(solution(s, p));