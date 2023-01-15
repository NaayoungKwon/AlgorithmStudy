import sys

def solution2(n, load):

    result = 0;
    dir = [[1,0], [0,1]];
    load_cost = [[int(1e9)] * n for _ in range(n)];
    load_cost[0][0] = 0;

    for x in range(n):
        for y in range(n):
            for i, j in dir:
                new_x = x + i;
                new_y = y + j;
                if new_x < n and new_y < n:
                    add = 0 if load[x][y] > load[new_x][new_y] else load[new_x][new_y] - load[x][y] + 1;
                    load_cost[new_x][new_y] = min(load_cost[new_x][new_y], load_cost[x][y] + add);
    # print(load_cost)
    return load_cost[n-1][n-1];

n = int(sys.stdin.readline());
myList = [list(map(int,sys.stdin.readline().split())) for _ in range(n)];
print(solution2(n, myList));