import sys

def solution(n, l, r, pan):
    day = 0
    dir = [(0,1), (0,-1), (1,0), (-1,0)]

    # 순회하면서 근접한 나라가 l ~r 차이만큼인지 확인
    # set에 넣기
    while True:
        visited = [[0] * n for _ in range(n)]
        cnt = 0
        for i in range(n):
            for j in range(n):
                if visited[i][j] > 0:
                    continue

                que = [(i,j)]
                cnt += 1
                visited[i][j] = cnt
                while que:
                    a, b = que.pop()
                    for d in dir:
                        na, nb = a + d[0], b + d[1]
                        if 0 <= na and na < n and nb >= 0 and nb < n and visited[na][nb] == 0:
                            # print(a,b, d, na, nb)
                            leng = abs(pan[a][b] - pan[na][nb])
                            if leng >= l and leng <= r:
                                que.append((na, nb))
                                visited[na][nb] = visited[a][b]
        
        dict = [{'sum' : 0, 'cnt' : 0, 'arr' : []} for _ in range(cnt+1)]
        for i in range(n):
            for j in range(n):
                dict[visited[i][j]]['sum'] += pan[i][j]
                dict[visited[i][j]]['cnt'] += 1
                dict[visited[i][j]]['arr'].append((i,j))
        move_cnt = 0
    
        for d in dict:
            # print(d)
            if d['cnt'] <= 1:
                continue
            move_cnt += 1
            avg = d['sum'] // d['cnt']
            for a, b in d['arr']:
                pan[a][b] = avg
        
        if move_cnt == 0:
            break
        day += 1
                

    # set에 있는 것들의 평균을 내서 업데이트
    # 업데이트를 곳이 하나라도 있는지 확인
    # 있으면 루프 계속 돈다
    # 없으면 끝낸다

    return day


n,l, r = map(int,sys.stdin.readline().split(' '));

myList = [list(map(int,sys.stdin.readline().split(' '))) for i in range(n)];
print(solution(n, l, r, myList));