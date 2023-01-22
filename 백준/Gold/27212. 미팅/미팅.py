import sys

def solution(n, m, c, W, A, B):

    left, right = (A,B) if n < m else (B,A);
    dp = [0]* max(n,m);
    # dp_idx = [0]* max(n,m);
    for i in range(min(n,m)):
        for j in range(max(n,m)-1, -1, -1):
            s = W[left[i]-1][right[j]-1] + (max(dp[:j]) if j > 0 else 0);
            if dp[j] < s:
                dp[j] = s;
    return max(dp);

n, m, c = map(int,sys.stdin.readline().split());
W = [list(map(int,sys.stdin.readline().split())) for _ in range(c)];
A = list(map(int,sys.stdin.readline().split()));
B = list(map(int,sys.stdin.readline().split()));
print(solution(n, m, c, W, A, B));