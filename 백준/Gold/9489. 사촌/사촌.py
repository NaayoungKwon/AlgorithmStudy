import sys

def solution3(n,k,l_tree):

    if n == 1:
        return 0;

    arr = [(0,0)] * (n);
    arr[0] = (-2,-1 ); # 할머니, 부모님
    idx = 0;
    prev = l_tree[1]-1;
    parent = 0;
    for i in range(1, len(l_tree)):
        if prev + 1 != l_tree[i]:
            idx += 1;
        prev = l_tree[i];
        arr[i] = (arr[idx][1] ,idx);
        if k == l_tree[i]:
            parent = arr[i];
    
    cnt = 0;
    for grandma, parent_ in arr:
        if parent[0] == grandma and parent[1] != parent_:
            cnt += 1;
    return cnt

while True:
    n, k = map(int,sys.stdin.readline().split());
    if n == 0 and k == 0:
        break;
    myList = list(map(int,sys.stdin.readline().split()));
    print(solution3(n, k,myList));