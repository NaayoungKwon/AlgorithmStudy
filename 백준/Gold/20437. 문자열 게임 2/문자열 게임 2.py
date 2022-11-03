import sys

ALPHA_LEN = 26
def solution(T, games):
    alpha = [ chr(97+ i) for i in range(ALPHA_LEN)];
    
    result = [];
    for i in range(T):
        arr = [[] for i in range(ALPHA_LEN)];
        W, K = games[i];
        for charIdx, c in enumerate(W):
            idx = alpha.index(c);
            arr[idx].append(charIdx);
        
        maxLen = -1;
        minLen = 10001;
        for i in range(ALPHA_LEN):
            if len(arr[i]) >= K:
                for j in range(len(arr[i]) - K +1):
                    l = arr[i][j+K-1] - arr[i][j] + 1;
                    maxLen = max(maxLen, l);
                    minLen = min(minLen, l);
        if maxLen == -1:
            print(-1);
        else:
            print(minLen, maxLen);

    return True;
  
T = int(sys.stdin.readline());
myList = []
for _ in range(T):
    W = sys.stdin.readline();
    K = int(sys.stdin.readline());
    myList.append((W[:-1],K));

solution(T, myList);