import sys
import heapq
import re

def solution(n, arr):

    result = [];

    for s in arr:
        for c in re.findall(r'\d+', s):
            # print(c)
            heapq.heappush(result , int(c))

    while result:
        print(heapq.heappop(result))

n = int(sys.stdin.readline());
pan = [input() for _ in range(n)]

solution(n, pan);