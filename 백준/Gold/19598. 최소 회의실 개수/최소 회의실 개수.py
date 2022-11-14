import sys
import heapq
def solution(n, arr): 

    room = [];
    result = 1;
    
    heapq.heappush(room, 0);
    
    while arr:
        s, e = heapq.heappop(arr);
        if s >= room[0]:
            heapq.heappop(room);
        else:
            result += 1;
        heapq.heappush(room , e);
            
    return result;
  
n = int(sys.stdin.readline());
myList = [];
for i in range(n):
    s, e = map(int,sys.stdin.readline().split());
    heapq.heappush(myList, (s,e));
print(solution(n, myList));