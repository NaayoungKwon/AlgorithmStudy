import sys
from bisect import bisect_left

def solution(n,arr):

    result = 0;
    dp = [0,1]
    X = [0, arr[0]]
    for i in range(1,n):
        if X[-1] < arr[i]:
            dp.append(len(X))
            X.append(arr[i])
        else:
            j = bisect_left(X, arr[i])
            dp.append(j)
            X[j] = arr[i]

    return n - max(dp)

n = int(sys.stdin.readline());
myList = [int(sys.stdin.readline()) for _ in range(n)];
print(solution(n, myList));