def find_start(park):
    for i in range(len(park)):
        for j in range(len(park[0])):
            if park[i][j] == 'S':
                return [i,j]
    return [0,0]

def solution(park, routes):
    answer = []
    sx, sy = find_start(park)
    dir = {'N' : [-1,0], 'S' : [1,0], 'W' : [0,-1], 'E' : [0,1]}
    for route in routes:
        d, n = route.split(" ")
        n = int(n)
        nx = sx + dir[d][0] * n
        ny = sy + dir[d][1] * n
        if not (nx >= 0 and nx < len(park) and ny >= 0 and ny < len(park[0])):
            continue
            
        flag = True
        for i in range(1,n+1):
            cx = sx + dir[d][0] * i
            cy = sy + dir[d][1] * i
            if park[cx][cy] == 'X':
                flag = False
                break
        if flag == False:
            continue
            
        sx, sy = nx, ny
    return [sx, sy]