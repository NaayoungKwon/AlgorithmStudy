import sys

def solution(n):

    result = 0;
    bList = list(bin(n))[2:];
    l = len(bList) -1;

    for idx, t in enumerate(bList):
        result += (int(t) * (3 ** (l-idx)))
    return result;
  
n = int(sys.stdin.readline());
print(solution(n));