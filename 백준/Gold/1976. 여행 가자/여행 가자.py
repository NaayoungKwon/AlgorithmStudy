import sys

def solution(n,m,link,plan):

    start = plan[0];
    for node in plan[1:]:
        visited = [0]*n;
        visited[start-1] = 1;
        que = [start-1];
        if start == node:
            continue;
        while que :
            start = que.pop(0);
            for idx, value in enumerate(link[start]):
                if idx != node-1 and value == 1 and visited[idx] == 0:
                    que.append(idx);
                    visited[idx] = 1;
                elif idx == node-1 and value == 1:
                    visited[idx] = 1;
                    que = [];
                    break;
        if visited[node-1] == 0:
            return 'NO';
        start = node;
        
    return 'YES';
  
n = int(sys.stdin.readline());
m = int(sys.stdin.readline());
myList = [list(map(int,sys.stdin.readline().split())) for i in range(n)];
plan = list(map(int,sys.stdin.readline().split()));
print(solution(n,m,myList,plan));