import sys

MAX_VALUE = (1 << 20) - 1


def solution(S, P):
    count = 0
    start_idx = 0
    l = 1
    while start_idx + l <= len(P):
        if S.find(P[start_idx: start_idx+l]) == -1:
            count += 1
            # print(P[start_idx: start_idx+l-1])
            start_idx += l-1
            l = 1
        elif start_idx + l == len(P):
            l += 1
            count += 1
        else:
            l += 1

    return count



s = input()
p = input()
print(solution(s, p))
