import sys
import itertools
def isInBound(x, y):
    return x >= 0 and x < 6 and y >= 0 and y < 12

def solution(pan):
    count = 0
    dir = [[1, 0], [0,1], [-1, 0], [0, -1]]
    # check possible
    while True:
        visited = [[False] * 12 for _ in range(6)]
        remove_list = []
        for i in range(6):
            for j in range(12):
                if pan[i][j] == '.':
                    continue
                
                group = [(i,j)]
                que = [(i,j)]
                while que:
                    x, y = que.pop()
                    if visited[x][y]:
                        continue

                    visited[x][y] = True
                    for k in range(4):
                        new_x, new_y = x + dir[k][0], y + dir[k][1]
                        if isInBound(new_x, new_y) and visited[new_x][new_y] == False and pan[i][j] == pan[new_x][new_y]:
                            que.append((new_x, new_y))
                            group.append((new_x, new_y))
                if len(group) >= 4:
                    remove_list.extend(group)
        
        if len(remove_list) == 0:
            return count;

        count += 1
        for i,j in remove_list:
            pan[i][j] = '.'

        for i in range(6):
            pan[i] = [ dot for dot in pan[i] if dot != '.']
            pan[i].extend(['.'] * (12 - len(pan[i])))
    

pan = [list(map(str, input())) for _ in range(12)]
# print()
print(solution(list(map(list, zip(*pan[::-1])))));