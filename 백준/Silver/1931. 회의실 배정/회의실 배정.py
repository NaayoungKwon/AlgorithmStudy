import sys
import heapq;
def solution(n, m_time, arr):

    result = 0;
    prev = 0;
    while arr:
        end, start = heapq.heappop(arr);
        if start >= prev:
            result += 1;
            prev = end;
    return result;

n = int(sys.stdin.readline());
myList = [];
m_time = 0;
for _ in range(n):
    a, b =map(int,sys.stdin.readline().split());
    m_time = max(m_time, b);
    heapq.heappush(myList, (b,a));
print(solution(n, m_time, myList));