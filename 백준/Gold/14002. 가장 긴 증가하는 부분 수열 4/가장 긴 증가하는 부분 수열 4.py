import sys

def solution(n, seqList):

    dp = [[] for i in range(n)];
    for i in range(n):
        for j in range(i+1, n):
            if seqList[i] < seqList[j]:
                if len(dp[j]) == 0 or dp[j][-1] < seqList[i]:
                    dp[j].append(seqList[i]);
                elif len(dp[j]) <= len(dp[i]):
                    dp[j] = dp[i][:] + [seqList[i]];
        dp[i].append(seqList[i]);
                
    maxLen = -1;
    maxIdx = -1;
    for i in range(n):
        if maxLen < len(dp[i]):
            maxLen = len(dp[i]);
            maxIdx = i;
    
    print(maxLen);
    return dp[maxIdx];
  
n = int(sys.stdin.readline());
myList = list(map(int,sys.stdin.readline().split())) ;
print(*solution(n, myList));