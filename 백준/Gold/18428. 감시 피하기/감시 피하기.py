import sys
import itertools

def solution(n, pans):

    result = 0;
    dir = [[1, 0], [-1,0], [0,1], [0,-1]]
    teachers = [] # 배열로 넣어둠
    empties = [] # 빈 공간 배열로 넣음
    # kC3을 set 을 한다
    # 선생님 별로 t를 확장하면서 O가 있는지 본다. O, S면 멈춘다
    for i in range(n):
        for j in range(n):
            if pans[i][j] == 'T':
                teachers.append((i,j))
            elif pans[i][j] == 'X':
                empties.append((i,j))
    
    for chairs in itertools.combinations(empties, 3):
        chairs_set = set(chairs)
        flag = True
        for teacher in teachers:
            for d in dir:
                l = 1
                while flag:
                    x, y = teacher[0] + l * d[0], teacher[1] + l * d[1]
                    if x < 0 or x >= n or y < 0 or y >= n: # 판을 벗어남
                        break

                    if len(chairs_set & set({(x,y)})) > 0 : # 의자를 만나면 더이상 확인하지 않음
                        break

                    if pan[x][y] == 'S': # 학생을 만나면 더이상 확인 안해도 된다
                        flag = False
                        break

                    l += 1
        if flag:
            return 'YES'
    return 'NO'

n = int(sys.stdin.readline());
pan = [list(map(str, list(input().replace(' ', '')))) for _ in range(n)]
print(solution(n, pan));