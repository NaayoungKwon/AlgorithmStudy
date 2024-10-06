import sys

def dfs(map_, fishes, now, ate):
    dirs = [[-1,0],[-1,-1],[0,-1],[1,-1],[1,0],[1,1],[0,1],[-1,1]]

    if len(fishes.keys()) == 0:
        return ate

    # 물고기 먹기
    ate += map_[now[0]][now[1]]
    fish = fishes.pop(map_[now[0]][now[1]])
    map_[now[0]][now[1]] = -1
    now[2] = fish[2]

    # 물고기 이동
    for i in range(1,17):
        if i not in fishes.keys():
            continue

        fish = fishes[i]
        for di in range(fish[2], fish[2] + 8):
            d = dirs[di % 8]
            next_fish = [fish[0] + d[0], fish[1] + d[1], di % 8]

            # 공간의 경계를 넘음
            if next_fish[0] < 0 or next_fish[0] >= 4 or next_fish[1] < 0 or next_fish[1] >= 4:
                continue
            # 상어있음
            if now[0] == next_fish[0] and now[1] == next_fish[1]:
                continue
            
            # 물고기 없어서 옮겨도 된다 
            if map_[next_fish[0]][next_fish[1]] == -1:
                map_[fish[0]][fish[1]] = -1
            else: # 물고기 있어서 swap 해야함
                j = map_[next_fish[0]][next_fish[1]]
                j_po = [fish[0], fish[1], fishes[j][2]]
                map_[fish[0]][fish[1]] = j
                fishes[j] = j_po
                
            map_[next_fish[0]][next_fish[1]] = i
            fishes[i] = next_fish
            break
    # print(now)
    # print(map_)

    # 상어 이동 dfs
    d = dirs[now[2]]
    mr = 0
    for k in range(1,5):
        x, y = now[0] + d[0] * k, now[1] + d[1] * k
        if x < 0 or x >= 4 or y < 0 or y >= 4:
            continue
        if map_[x][y] == -1:
            continue
        r = dfs([m[:] for m in map_], fishes.copy(), [x,y,now[2]], ate)
        mr = max(mr, r)
    # 이동할 수 없으면 아예 끝내버림 ? -> 어케하노..

        # print(now, x, y, r , ate)
    # 최댓 값 구해서 리턴
    return max(ate, mr)

def solution(map_, fishes):
    
    now = [0,0,0]
    result = dfs(map_,fishes, now, 0)
    
    return result


map_ = [[0] * 4 for _ in range(4)]
fishes = {}
for i in range(4):
    a = list(map(int,sys.stdin.readline().split(' ')))
    for j in range(4):
        map_[i][j] = a[j*2] # 물고기 번호
        fishes[a[j*2]] = [i, j, a[j*2+1] -1] # 좌표, 방향 번호

print(solution(map_, fishes))
