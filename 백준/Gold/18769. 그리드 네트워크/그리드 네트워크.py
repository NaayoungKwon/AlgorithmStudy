import sys
import heapq

def encode_idx(r,c,i,j):
    return i * (c+1) + j;

def decode_idx(r,c,a):
    return (a//(c+1), a % (c+1));

def find(path, a):
    if path[a] != a:
        path[a] = find(path, path[a]);
    return path[a];

def solution(r,c, load):

    result = 0;
    cnt = 0;
    parent = [0] * (r+1)*(c+1);
    for i in range(len(parent)):
        parent[i] = i;
    
    arr = [];
    start = encode_idx(r,c,1,1);
    for end, l in load[start]:
        heapq.heappush(arr, (l, start,end));
    while arr:
        l, start, end = heapq.heappop(arr);
        f_a = find(parent, start);
        f_b = find(parent, end);
        if f_a < f_b:
            parent[f_b] = f_a;
        elif f_a > f_b:
            parent[f_a] = f_b;
        else:
            continue;
        result += l;
        cnt += 1;
        if cnt == r*c -1:
            break;
        for e, l in load[end]:
            heapq.heappush(arr, (l, end,e));
        
        # print(start,end,l);
    return result;

T = int(sys.stdin.readline());
for _ in range(T):
    r,c = map(int,sys.stdin.readline().split());
    map_ = [[] for _ in range((r+1)*(c+1))];
    for i in range(1,r+1):
        arr = list(map(int,sys.stdin.readline().split()));
        for idx, l in enumerate(arr):
            a = encode_idx(r,c,i,idx+1);
            b = encode_idx(r,c,i,idx+2);
            map_[a].append((b,l));
            map_[b].append((a,l));
    
    for i in range(1,r):
        arr = list(map(int,sys.stdin.readline().split()));
        for idx, l in enumerate(arr):
            a = encode_idx(r,c,i,idx+1);
            b = encode_idx(r,c,i+1,idx+1);
            map_[a].append((b,l));
            map_[b].append((a,l));
    
    print(solution(r,c,map_));
