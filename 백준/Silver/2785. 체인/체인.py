import sys
import collections

def solution(n, temp):
    temp.sort()
    arr = collections.deque()
    for e in temp:
        arr.append(e)
    result = 0
    
    while len(arr) > 1:
        if arr[0] == 0:
            arr.popleft()
            continue
        arr[0] -= 1
        arr[-2] += (arr[-1] +1)
        arr.pop()
        result += 1
    return result #+ (1 if len(arr) > 0 else 0)


n = int(sys.stdin.readline());
myList = list(map(int,sys.stdin.readline().split(' ')))
print(solution(n, myList));