import sys

def check(arr,m):
    cnt = 0;
    for i in range(len(arr)):
        cnt += (m//arr[i]);
    return cnt;

def solution(n, m, arr):
    max_a = max(arr) * m;

    left = 0;
    right = max_a;
    result = 0;
    while left <= right:
        mid = (left + right) //2;
        k = check(arr,mid);

        if k >= m:
            right = mid-1;
            result = mid;
        else:
            left = mid+1;

    return result;

n,m = map(int,sys.stdin.readline().split());
arr = [];
for _ in range(n):
    a = int(sys.stdin.readline());
    arr.append(a);
print(solution(n, m, arr));