import sys
def solution2(n,arrs):
    dp = [0] * n
    arrs.sort(key = lambda x:x[0])

    for i in range(n):
        for j in range(i):
            if arrs[i][1] > arrs[j][1] and dp[i] < dp[j]:
                dp[i] = dp[j]
        dp[i] +=1
    return n - max(dp)

n = int(sys.stdin.readline());
myList = [list(map(int,sys.stdin.readline().split())) for _ in range(n)];
print(solution2(n, myList));