import sys
import collections
import heapq

def solution3(n,c,start, start_dic, heap_arr):
    result = 0;
    new_heap = [];
    path = [0] * (n+1);

    while heap_arr:
        a, b, weight = heapq.heappop(heap_arr);
        heapq.heappush(new_heap, (weight/(b-a), a,b,-weight));
    
    while new_heap:
        k, s, e, w = heapq.heappop(new_heap);
        now_max_weight = max(path[s:e]);
        if now_max_weight == c:
            continue;

        if now_max_weight + w > c:
            w = c - now_max_weight;
            heapq.heappush(new_heap, (-w/(b-a), a,b,w));
        else:
            for i in range(s, e):
                path[i] += w;
            # print('pop from new ', s,e,w, now_max_weight, path)
            result += w;
    return result;

n, c = map(int,sys.stdin.readline().split(' '));
m = int(sys.stdin.readline());
start_dic = collections.defaultdict(list);
start = n;
heap_arr = [];
for _ in range(m):
    a,b,box = map(int,sys.stdin.readline().split(' '));
    start = min(start, a);
    start_dic[a].append((b,box));
    heapq.heappush(heap_arr, (a,b,-box));
print(solution3(n,c,start, start_dic, heap_arr));