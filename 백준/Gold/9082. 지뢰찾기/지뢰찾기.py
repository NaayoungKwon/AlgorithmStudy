import sys
import collections

def solution(n, nums,  arr):
    result = 0

    for i in range(n):
        if i == 0 and nums[i] > 0 and nums[i+1] > 0:
            nums[i] -=1
            nums[i+1] -=1
            result += 1
        elif i == n-1 and nums[i] > 0 and nums[i-1]> 0:
            nums[i] -=1
            nums[i-1] -=1
            result += 1
        elif i > 0 and i < n and nums[i] > 0 and nums[i-1]> 0 and nums[i+1] > 0:
            nums[i] -=1
            nums[i-1] -=1
            nums[i+1] -=1
            result += 1

    return result


t = int(sys.stdin.readline());
for _ in range(t):
    n = int(sys.stdin.readline());
    nums = [int(d) for d in sys.stdin.readline()[:-1]]
    arr = list(sys.stdin.readline())
    print(solution(n, nums, arr[:-1]));