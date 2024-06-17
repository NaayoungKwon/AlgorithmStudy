import sys
import re

def solution(s):

    if re.compile(r'(100+1+|01)+').fullmatch(s):
        return 'SUBMARINE'
    return 'NOISE'


s = sys.stdin.readline().split('\n')[0];
print(solution(s));