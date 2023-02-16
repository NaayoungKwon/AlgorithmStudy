import sys

MAX_LEN = float('inf');


def 다익스트라(start, load):

    arr = [(start, 0)];
    path = [MAX_LEN] * (n+1);
    path[start] = 0;
    while arr:
        last, l = arr.pop();
        if path[last] < l :
            continue;
        for b in load[last]:
            if path[b] > l+1:
                arr.append((b, l+1));
                path[b] = l+1;
    return path;

def solution2(n, load):
    max_payload = 0;
    min_total = MAX_LEN;
    
    path_1 = 다익스트라(1,load);
    k = path_1.index(max(path_1[1:]));
    path_k = 다익스트라(k, load);
    max_len = max(path_k[1:]);
    return max_len // 2 + (1 if max_len % 2 == 1 else 0);

n = int(sys.stdin.readline());
myList = [[] for _ in range(n+1)];
for i in range(n-1):
    a, b = map(int,sys.stdin.readline().split());
    myList[a].append(b);
    myList[b].append(a);
print(solution2(n, myList));