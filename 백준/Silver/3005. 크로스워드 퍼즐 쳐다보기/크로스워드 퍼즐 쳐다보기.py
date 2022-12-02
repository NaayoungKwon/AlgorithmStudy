import sys

def compareStr(a,b):

    for i in range(min(len(a), len(b))):
        if a[i] < b[i]:
            return a;
        elif a[i] > b[i]:
            return b;
    return (a if len(a) < len(b) else b);

def solution(R,C, puzzle):
    result = 'z' * max(R,C);
    for r in range(R):
        nowList = puzzle[r].split('#');
        for s in nowList:
            if len(s) >= 2:
                result = compareStr(result, s);

    for c in range(C):
        nowList = ''.join(puzzle[i][c] for i in range(R)).split('#');
        # print(nowList)
        for s in nowList:
            if len(s) >= 2:
                result = compareStr(result, s);
    return result;
  
R, C = map(int, sys.stdin.readline().split());
myList = [sys.stdin.readline()[:-1] for i in range(R)];
print(solution(R,C,myList));