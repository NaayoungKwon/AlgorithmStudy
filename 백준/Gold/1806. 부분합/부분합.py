import sys

def solution(n, s, arr):
    CAN_NOT = 200000000
    min_len = CAN_NOT
    start = 0
    end = 0
    total = 0
    while start < n and end < n:
        total += arr[end]
        # print(total, start, end)
        while total >= s:
            min_len = min(min_len, end - start + 1)
            total -= arr[start]
            start += 1
            # print(" " , total, start, end)
        else:
            end += 1

    return min_len if min_len != CAN_NOT else 0

input = sys.stdin.readline

N, S = map(int, input().split())
arr = list(map(int, input().split()))
print(solution(N, S, arr));
