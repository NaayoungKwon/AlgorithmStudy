import sys

def solution(s):

    result = len(s)
    a_count = s.count('a')
    s = s+s
    for i in range(len(s) - a_count + 1):
        t = s[i : i+a_count]
        result = min(result, t.count('b'))
    return result


s = sys.stdin.readline().split()[0];
print(solution(s));