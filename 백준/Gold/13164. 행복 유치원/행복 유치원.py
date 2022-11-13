import sys
import heapq

def calCost(kids, arr):
    result = 0;
    prevIdx = 0;
    arr.sort();

    for i in arr + [ len(kids) -1 ]:
        result += (kids[i] - kids[prevIdx]);
        prevIdx = i+1;
    return result;

def solution(n, k, kids):

    result = [];
    dif = [];
    for i in range(n-1):
        heapq.heappush(dif, (-(kids[i+1] - kids[i]), i));
    
    maxIdxList = [];
    for i in range(k-1):
        m, idx = heapq.heappop(dif);
        maxIdxList.append(idx);

    return calCost(kids, maxIdxList);

  
n, k = map(int, sys.stdin.readline().split());
kids = list(map(int,sys.stdin.readline().split()));
print(solution(n, k, kids));