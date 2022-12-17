import sys
import heapq

def solution(k, chapter):

    hq = [];
    for i in range(k):
        heapq.heappush(hq, chapter[i]);
    
    answer = 0;
    while len(hq) > 1:
        x = heapq.heappop(hq);
        y = heapq.heappop(hq);
        answer += (x+y);
        heapq.heappush(hq, x+y);

    return answer;
  
T = int(sys.stdin.readline());
for i in range(T):
    K = int(sys.stdin.readline());
    myList = list(map(int,sys.stdin.readline().split()));
    print(solution(K, myList));