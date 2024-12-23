import sys
from bisect import bisect_left

def solution(n, arr):
    dp = [0,1]; # dp[i] = arr[i]가 부분 수열의 마지막 값일 때 부분수열길이
    X = [0,arr[0]]; # X[i] = 길이가 i 인 부분 수열의 제일 끝의 값

    for i in range(1,n):
        if X[-1] < arr[i]: # 이전에서 부터 증가
            dp.append(len(X))
            X.append(arr[i])
        else:
            j = bisect_left(X, arr[i]) # 이분 탐색으로 찾는다.
            X[j] = arr[i] # 끼워넣음
            dp.append(j) 

    return max(dp)

n = int(sys.stdin.readline());
myList = list(map(int,sys.stdin.readline().split())) ;
print(solution(n, myList));