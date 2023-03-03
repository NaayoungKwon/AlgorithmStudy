import sys
from collections import defaultdict
import heapq

def solution(n, load):

    result = 0;

    return result;

Q = int(sys.stdin.readline());
dic = defaultdict(list);
result = 0;
for _ in range(Q):
    arr = sys.stdin.readline().split();
    query_type = int(arr[0]);
    name = arr[1];
    if query_type == 1:
        for e in arr[3:]:
            heapq.heappush(dic[name], -int(e));
    else:
        for _ in range(int(arr[2])):
            if len(dic[name]) == 0:
                break;
            result -= heapq.heappop(dic[name]);
            
    # print(dic);
print(result);