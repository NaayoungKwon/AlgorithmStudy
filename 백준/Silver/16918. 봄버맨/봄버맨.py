import sys

def solution(i,n,myMap):

    dir = [[1,0],[0,1],[-1,0],[0,-1]]
    r = len(myMap)
    c = len(myMap[0])

    while i < n:
        # 모든 칸에 폭탄 설치
        now_bomb = 'O' if i % 4 == 1 else 'X'
        next_bomb = 'X' if i % 4 == 1 else 'O'# X로 된거 설치 아니면 O로된거 설치
        for a in range(r):
            for b in range(c):
                if myMap[a][b] == '.':
                    myMap[a][b] = next_bomb
        
        i += 1;
        if i >= n:
            break;

        que = []
        for a in range(r):
            for b in range(c):
                if myMap[a][b] == now_bomb:
                    myMap[a][b] = '.'
                    for x,y in dir:
                        if a + x >= 0 and a + x < r and b + y >= 0 and b + y < c and myMap[a+x][b+y] == next_bomb:
                            que.append([a+x, b+y])

        for a,b in que:
            myMap[a][b] = '.'
        i += 1;
    
    return myMap

r,c,n = map(int,sys.stdin.readline().split());
bomb_graph = [list(map(str, list(input()))) for _ in range(r)]
result = solution(1, n, bomb_graph);

for st in result:
    print("".join(st).replace("X","O"))