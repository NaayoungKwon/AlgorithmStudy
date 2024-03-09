import sys


def solution(n, m, k, trees, food):
    dir = [[-1,-1], [-1,0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1,1]]
    result = 0;
    pan = [[[] for _ in range(n)]  for _ in range(n)]
    food_pan = [[5] * n for _ in range(n)]

    for tree in trees:
        pan[tree[0]-1][tree[1]-1].append(tree[2])

    for i in range(n):
        for j in range(n):
            pan[i][j].sort()
    for _ in range(k):
        
        # spring
        for i in range(n):
            for j in range(n):
                # pan[i][j].sort()
                for z in range(len(pan[i][j])):
                    if pan[i][j][z] <= food_pan[i][j]:
                        food_pan[i][j] -= pan[i][j][z]
                        pan[i][j][z] += 1
                    else: # dead
                        food_pan[i][j] += (sum([age//2 for age in pan[i][j][z:]]))
                        pan[i][j] = pan[i][j][:z]
                        break

        # summer 
        # do dead line    

        # fall
        for i in range(n):
            for j in range(n):
                cnt =  len([l for l in pan[i][j] if l % 5 == 0])
                if cnt > 0:
                    for d in dir:
                        x, y = i + d[0], j + d[1]
                        if x >= 0 and x < n and y >= 0 and y < n:
                            pan[x][y] = [1] * cnt + pan[x][y]
            
        # winter
        for i in range(n):
            for j in range(n):
                food_pan[i][j] += food[i][j]

    for i in range(n):
        for j in range(n):
            result += len(pan[i][j]) 

    return result

n,m,k = map(int,sys.stdin.readline().split());
food = [list(map(int, input().split(' '))) for _ in range(n)]
trees = [list(map(int, input().split(' '))) for _ in range(m)]
print(solution(n, m, k, trees, food));