import sys
import itertools

def multiple(arr):
    result = 1;
    for e in arr:
        if e == 0:
            continue;
        result *= e;
    return result;

def solution(n, arr, p, q):
    
    result = 0;
    for nums in set(itertools.permutations(arr, n)):
        dp = [([0] * (n+1)) for _ in range(n+1)];
        for i in range(1,n+1):
            dp[i][i] = nums[i-1];
            for j in range(1,i):
                dp[j][i] = nums[i-1] + dp[j][i-1];
                
        for op in itertools.combinations(list(range(1,n)) , q): # 1 2 | 3 4  5 | 
            st = [];
            start = 1;
            for end in op:
                st.append(dp[start][end]);
                start = end+1;
            if start <= n:
                st.append(dp[start][n]);
            result = max(result, multiple(st));

    return result;

n = int(sys.stdin.readline());
myList = list(map(int,sys.stdin.readline().split()));
p, q = map(int, sys.stdin.readline().split());
print(solution(n,myList, p,q));