import sys
import heapq

def solution(n, pan):
    idx_arr = [n-1] * n
    arr = [] # 값, 몇 번째 인덱스인지
    count = 0

    for i in range(n):
        heapq.heappush(arr, (-pan[n-1][i], i))

    while count < n-1:
        m, idx = heapq.heappop(arr)
        # print(m)
        idx_arr[idx] -= 1
        heapq.heappush(arr, (-pan[idx_arr[idx]][idx], idx))
        count += 1

    return -heapq.heappop(arr)[0]


n = int(sys.stdin.readline());
myList = [list(map(int,sys.stdin.readline().split())) for i in range(n)];
print(solution(n, myList));