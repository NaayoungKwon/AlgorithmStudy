import sys

def solution(n, k, arr):

    result = sum(arr[:k]);
    prev_s = result;
    for i in range(k, n):
        s = prev_s - arr[i-k] + arr[i];
        # print(s)
        result = max(result, s);
        prev_s = s;
    return result;

n,k = map(int,sys.stdin.readline().split());
myList = list(map(int,sys.stdin.readline().split())) 
print(solution(n, k, myList));