import sys
import itertools

def solution(n, pans):

    result = 200 * 11 * 11;
    dir = [[-1, 0], [0, 1], [1, 0], [0, -1]]
    can_plant = []
    for i in range(1, n-1):
        for j in range(1, n-1):
            can_plant.append((i,j))
    
    for cores in itertools.combinations(can_plant, 3):
        flower_set = set()
        for core in cores:
            flower_set.add((core[0], core[1]))
            for d in dir:
                x, y = core[0] + d[0], core[1] + d[1]
                if x >= 0 and x < n and y >= 0 and y < n:
                    flower_set.add((x,y))
        if len(flower_set) == 5 * 3:
            temp_result = 0
            for i, j in flower_set:
                temp_result += pans[i][j]
            result = min(result, temp_result)

    return result

n = int(sys.stdin.readline());
myList = [list(map(int,sys.stdin.readline().split())) for _ in range(n)];
# print(myList)
print(solution(n, myList));