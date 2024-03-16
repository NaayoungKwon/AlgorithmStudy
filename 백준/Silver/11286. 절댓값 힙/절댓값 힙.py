import sys
import heapq


n = int(sys.stdin.readline());
arr = []
for i in range(n):
    k = int(sys.stdin.readline());
    if k != 0:
        heapq.heappush(arr, (abs(k), k))

    else:
        if arr:
            top = heapq.heappop(arr)
            print(top[1])
        else:
            print(0)
