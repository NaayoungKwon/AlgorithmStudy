import sys
# import bisect

def solution2(n, k, arr):
    arr = list(set(arr))
    arr.sort()
    # idx = bisect.bisect_left(arr, k)
    # arr = arr[:idx]
    dp = [10001] * (k+1)
    dp[0] = 0
    for coin in arr:
        if coin > k:
            continue
        dp[coin] = 1
        for j in range(coin, k+1):
            dp[j] = min(dp[j], dp[j-coin] + 1)

    return dp[k] if dp[k] < 10001 else -1


n,k = map(int,sys.stdin.readline().split(' '));
myList = [int(sys.stdin.readline()) for i in range(n)];
print(solution2(n, k, myList));