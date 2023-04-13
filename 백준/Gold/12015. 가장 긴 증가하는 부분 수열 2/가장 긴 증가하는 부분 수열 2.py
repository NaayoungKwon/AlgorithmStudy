import sys
from bisect import bisect_left

def solution(n, arr):
    result = 0;
    dp = [0,1];
    X = [0,arr[0]];

    for i in range(1,n):
        if X[-1] < arr[i]: # 증가
            dp.append(len(X))
            X.append(arr[i])
        else:
            j = bisect_left(X, arr[i])
            X[j] = arr[i]
            dp.append(j) 

    return max(dp)

n = int(sys.stdin.readline());
myList = list(map(int,sys.stdin.readline().split())) ;
print(solution(n, myList));