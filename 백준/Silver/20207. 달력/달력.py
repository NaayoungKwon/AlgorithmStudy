import sys
import heapq

END_DAY = 365;
def solution(arr):

    result = 0;
    cal = [0] * (END_DAY + 10);
    while arr:
        s, e = heapq.heappop(arr);
        for i in range(s, (-e)+1):
            cal[i] += 1;
    
    max_cnt = 0;
    start = -1;
    for i in range(END_DAY+2):
        if cal[i] == 0:
            result += (( i - start) * max_cnt);
            start = -1;
            max_cnt = 0;
        else:
            if start == -1:
                start = i;
            max_cnt = max(max_cnt, cal[i]);

    return result;
  
n = int(sys.stdin.readline());
arr = [];
for _ in range(n):
    s, e = map(int,sys.stdin.readline().split());
    heapq.heappush(arr, (s,-e));
print(solution(arr));