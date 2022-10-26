import sys
import heapq

n = int(sys.stdin.readline());
map_line = [];
que = [];
parent = [ i for i in range(n)];
ternal = 0;
result = 0;

def calLen(a,b):
    return min(abs(a['x']-b['x']), abs(a['y']-b['y']), abs(a['z']-b['z']));


def find(a):
    if parent[a] != a:
        return find(parent[a]);
    return a;

def union(a, b):
    a = find(a);
    b = find(b);
    if a < b:
        parent[b] = a;
    else:
        parent[a] = b;
    
  
for i in range(n):
    a,b,c = map(int,sys.stdin.readline().split());
    map_line.append({ 'n' : i, 'x' : a, 'y': b, 'z' : c});

map_line.sort(key = lambda k : k['x'] );
for i in range(n-1):
    c = calLen(map_line[i], map_line[i+1]);
    heapq.heappush( que, (c, (map_line[i]['n'],map_line[i+1]['n'])));

map_line.sort(key = lambda k : k['y'] );
for i in range(n-1):
    c = calLen(map_line[i], map_line[i+1]);
    heapq.heappush( que, (c, (map_line[i]['n'],map_line[i+1]['n'])));
    
map_line.sort(key = lambda k : k['z'] );
for i in range(n-1):
    c = calLen(map_line[i], map_line[i+1]);
    heapq.heappush( que, (c, (map_line[i]['n'],map_line[i+1]['n'])));

# print(que)
while ternal < n-1:
    c, (a,b) = heapq.heappop(que);
    if find(a) != find(b):
        union(a, b);
        ternal += 1;
        result += c;
        
print(result);