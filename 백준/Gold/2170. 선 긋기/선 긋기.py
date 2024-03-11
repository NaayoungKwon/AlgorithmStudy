import sys
import heapq

def solution(n, road):

    result = 0;
    prev = min(road[0])
    while road:
        x, y = heapq.heappop(road)
        if prev >= min(x,y):
            if prev <= max(x,y):
                result += abs((max(x,y) - prev))
                prev = max(x,y)
        else:
            result += abs(x-y)
            prev = max(x,y)


    return result

n = int(sys.stdin.readline());
myList = []
for _ in range(n):
    x,y = map(int,sys.stdin.readline().split());
    heapq.heappush(myList, (x,y))
print(solution(n, myList));