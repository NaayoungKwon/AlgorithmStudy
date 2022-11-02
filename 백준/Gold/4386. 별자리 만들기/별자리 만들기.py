import sys
import math
import heapq

def calLen(a,b):
    return round(math.sqrt(pow(a[0]-b[0], 2) + pow(a[1]-b[1], 2)), 2);

def find(parent, idx):
    if parent[idx] == idx:
        return idx;
    return find(parent, parent[idx]);

def solution(n, nodes):
    parent = [ i for i in range(n)];
    arr = [];
    result = 0;
    line = 0;
    for i in range(n):
        for j in range(i+1,n):
            l = calLen(nodes[i], nodes[j]);
            heapq.heappush(arr, (l, (i,j)));

    while line < n-1 and arr:
        l, (i,j) = heapq.heappop(arr);
        parentI = find(parent, i);
        parentJ = find(parent, j);
        if parentI < parentJ:
            parent[parentJ] = parentI;
            result += l;
            line += 1;
        elif parentI > parentJ:
            parent[parentI] = parentJ;
            result += l;
            line += 1;
        

    return result;
  
n = int(sys.stdin.readline());
myList = [];
for i in range(n):
    x, y = map(float,sys.stdin.readline().split());
    myList.append([x,y]);

print(solution(n, myList));