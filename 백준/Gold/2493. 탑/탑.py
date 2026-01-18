import sys
import heapq

def solution(n, arr):
    
    result = [0] * n
    que = []
    heapq.heappush(que, (arr[n-1], n-1))
    for i in range(n-2, -1, -1):
        # top = que[0]
        while que and arr[i] >= que[0][0]:
            v, idx = heapq.heappop(que)
            result[idx] = i+1
        heapq.heappush(que, (arr[i], i))

    return result


n = int(sys.stdin.readline());
myList = list(map(int,sys.stdin.readline().split())) ;
print(*solution(n,  myList));