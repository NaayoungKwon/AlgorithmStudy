import sys
import heapq

def solution(n,m,arr):

    result = 0;
    que = []
    for e in arr:
        heapq.heappush(que, e)
    
    count = 0
    while count < m:
        a = heapq.heappop(que)
        b = heapq.heappop(que)
        heapq.heappush(que, a+b)
        heapq.heappush(que, a+b)
        count += 1

    return sum(que)

n,m = map(int,sys.stdin.readline().split());
myList = list(map(int,sys.stdin.readline().split())) ;
print(solution(n, m, myList));