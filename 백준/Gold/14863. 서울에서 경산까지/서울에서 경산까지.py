import sys

def solution2(n,k,walk, bicycle):
    dp = [[-1]* (k+1) for _ in range(100)];
    dp[0][walk[0][0]] = walk[0][1];
    dp[0][bicycle[0][0]] = max(dp[0][bicycle[0][0]] , bicycle[0][1]);

    for i in range(1,n):
        for j in range(k):
            thisWalk = j + walk[i][0];
            thisBicycle = j + bicycle[i][0];
            if dp[i-1][j] > 0 and thisWalk <= k:
                dp[i][thisWalk] = max(dp[i][thisWalk], dp[i-1][j] + walk[i][1]);
                # print(i, thisWalk,dp[i][thisWalk] )
            if dp[i-1][j] > 0 and thisBicycle <= k:
                dp[i][thisBicycle] = max(dp[i][thisBicycle], dp[i-1][j] + bicycle[i][1]);
                # print(i, thisBicycle, dp[i][thisBicycle]);
    return max(dp[n-1]);

n,k = map(int,sys.stdin.readline().split());
walk = [];
bicycle = [];
for i in range(n):
    a,b,c,d= map(int,sys.stdin.readline().split()) ;
    walk.append((a,b));
    bicycle.append((c,d));
print(solution2(n,k,walk, bicycle));