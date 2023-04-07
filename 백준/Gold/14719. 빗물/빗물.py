import sys

def solution(n,loads):

    result = 0;
    left = loads[0];
    temp = 0
    mid = 0
    startIdx = 0
    for i in range(1,n):
        if left <= loads[i]:
            # print(i, temp,loads[i])
            result += temp;
            temp = 0;
            mid = 0;
            left = loads[i];
            startIdx = i
        else:
            temp += (left - loads[i]);
            mid = max(mid, loads[i])

    subMid = mid
    while temp:
        temp = 0
        mid = subMid
        for i in range(startIdx+1, n):
            if loads[i] != mid:
                temp += (mid - loads[i])
                subMid = max(subMid, loads[i])
            else:
                startIdx = i
                result += temp
                temp = 0
                subMid = 0
                
    return result

h,w = map(int,sys.stdin.readline().split());
myList = list(map(int,sys.stdin.readline().split())) ;
print(solution(w, myList));