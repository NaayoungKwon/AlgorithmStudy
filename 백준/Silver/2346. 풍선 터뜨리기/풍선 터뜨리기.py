import sys
from collections import deque

def solution2(n, arr):
    result = [];
    while arr:
        idx, move = arr.popleft();
        result.append(idx);
        cnt = 1 if move > 0 else 0;
        # print(arr)
        while arr and cnt < abs(move):
            
            if move > 0:
                i, v = arr.popleft();
                arr.append((i,v));
            else:
                i, v = arr.pop();
                arr.appendleft((i,v));
            cnt += 1;
            # print(cnt, move, arr)
    return result;

n = int(sys.stdin.readline());
myList = deque(enumerate(map(int, sys.stdin.readline().split()), start=1));
print(*solution2(n, myList));