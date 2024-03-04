import sys
import heapq


n = int(sys.stdin.readline());
arr = []
for _ in range(n):
    k = int(sys.stdin.readline());
    if k == 0 and arr:
        print(heapq.heappop(arr))
    elif k == 0 and len(arr) == 0:
        print(0)
    else:
        heapq.heappush(arr, k)
# print(solution(n, arr));
