import sys

def find(path, node):
    while path[node] != node:
        node = path[node];
    return node;

def solution(n, arr):

    result = 0;
    path = [0] * (n+1);
    circle = set();
    for i in range(1,n+1):
        path[i] = i;

    arr.sort();
    for a,b in arr:
        f_a = find(path,a);
        f_b = find(path,b);
        if f_a < f_b:
            path[f_b] = f_a;
        elif f_a > f_b:
            path[f_a] = f_b;
        else:
            circle.add(f_a);

    tree = [];

    for i in range(1,n+1):
        f_i = find(path, i);
        path[i] = f_i;
    new_circle = set();
    for c in list(circle):
        a = find(path,c);
        new_circle.add(a);

    for node in path[1:]:
        f_node = find(path, node);
        if f_node not in tree and f_node not in circle:
            tree.append(f_node);
    return len(tree);

cnt = 1;
result_arr = [];
while True:
    n, m = map(int,sys.stdin.readline().split());
    if n == 0 and m == 0:
        break;
    myList = [list(map(int,sys.stdin.readline().split()))  for _ in range(m)];
    result = solution(n, myList);
    s = ('A forest of ' + str(result) + ' trees.') if result > 1 else ('There is one tree.' if result == 1 else 'No trees.');
    s = 'Case ' + str(cnt) + ': ' + s;
    result_arr.append(s);
    cnt += 1;

for s in result_arr:
    print(s);