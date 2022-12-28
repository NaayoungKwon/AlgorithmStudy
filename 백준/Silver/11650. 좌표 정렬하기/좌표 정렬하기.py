import sys
import heapq;
n = int(sys.stdin.readline());
result_arr = [];
arr = [];
for i in range(n):
    x, y = map(int, sys.stdin.readline().split());
    heapq.heappush(arr, (x,y));

while arr:
    x,y = heapq.heappop(arr);
    result_arr.append([x,y]);
for i in range(n):
    print(result_arr[i][0], result_arr[i][1]);
