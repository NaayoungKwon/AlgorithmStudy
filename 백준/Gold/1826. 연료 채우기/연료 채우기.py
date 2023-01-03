
import sys
import heapq
def solution(n,station, L, P):

    answer = 0
    P_heap = []
    
    while P < L:
        
        while len(station) > 0 and station[0][0] <= P:
            dst, gas = heapq.heappop(station)
            heapq.heappush(P_heap, (-gas, dst))
        
        if len(P_heap) == 0:
            return -1
        
        a, b = heapq.heappop(P_heap)
        answer += 1
        P += (-a)

    return answer
    
n = int(sys.stdin.readline())
station = []
gas_sum = 0
for i in range(n):
    dst, gas = map(int, sys.stdin.readline().split())
    gas_sum += gas
    heapq.heappush(station, (dst, gas))
L, P = map(int, sys.stdin.readline().split())
if gas_sum + P < L:
    print(-1)
print(solution(n,station, L, P))
