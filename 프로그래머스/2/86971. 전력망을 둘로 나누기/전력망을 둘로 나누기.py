from collections import Counter

def solution(n, wires):
    answer = -1
    my_childs = [[] for _ in range(n+1)]
    m = len(wires)
    

    mr = n * 100
    for i in range(m):
        parent = [0] * (n+1)
        for a in range(1, n+1):
            parent[a] = a
        for j in range(m):
            if i == j:
                continue
            union(parent, wires[j][0], wires[j][1])
        
        a = 0
        b = 0
        for k in range(1, n+1):
            if find(parent, k) != 1:
                a += 1
        b = n -a
        mr = min(mr, abs(a-b))

    return mr

def find(path, i):
    if path[i] != i:
        path[i] = find(path,path[i]);
    return path[i];

def union(path, a,b):
    f_a = find(path, a);
    f_b = find(path, b);
    if f_a < f_b:
        path[f_b] = f_a;
    elif f_a > f_b:
        path[f_a] = f_b;