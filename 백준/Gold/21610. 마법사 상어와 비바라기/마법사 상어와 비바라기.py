import sys

def find_new_cur(n, x, y):
    while x < 0:
        x += n
    if x >= n:
        x = (x % n)
    
    while y < 0:
        y += n
    if y >= n:
        y = (y % n)

    return (x,y)
    
def solution(n, m, pan, ds):

    result = 0;
    cloud = [(n-1, 0), (n-1,1), (n-2,0), (n-2,1)]
    dir = [(0,-1), (-1,-1),(-1,0),(-1,1),(0,1),(1,1),(1,0),(1,-1)]
    dig = [ (-1,-1),(-1,1),(1,1),(1,-1)]

    for i in range(m):
        # m번 순회를 한다
        d = ds[i]
        dx, dy = dir[d[0]-1][0] * d[1], dir[d[0]-1][1] * d[1]
        
        # 구름은 이동한다 (범위 넘어가면 고려한다)
        cloud_bucket = [0] * len(cloud)
        for j in range(len(cloud)):
            cloud[j] = find_new_cur(n, cloud[j][0] + dx, cloud[j][1] + dy)
            # 구름있는 곳에 물의 양 1증가시킨다
            pan[cloud[j][0]][cloud[j][1]] += 1
            
            # 구름 있는곳마다 바구니에 추가로 더할걸 따로 구해둔다
        for j in range(len(cloud)):
            s = 0
            for dg in dig:
                dg_x, dg_y = cloud[j][0] + dg[0], cloud[j][1] + dg[1]
                if dg_x >= 0 and dg_x < n and dg_y >= 0 and dg_y < n and pan[dg_x][dg_y] > 0:
                    s += 1
            cloud_bucket[j] = s
        # 구한걸 더한다
        for j in range(len(cloud)):
            pan[cloud[j][0]][cloud[j][1]] += cloud_bucket[j]
        # 새로운 구름을 찾는다 (이전에 고름이 아니고, 구름을 갱신하고 물 -2를 한다)
        old_cloud = set(cloud[:])
        cloud = []
        for a in range(n):
            for b in range(n):
                if pan[a][b] >= 2 and (a,b) not in old_cloud:
                    cloud.append((a,b))
                    pan[a][b] -= 2
    
    # 전부 순회하며 물의 합을 구한다
    for i in range(n):
        for j in range(n):
            result += pan[i][j]
    return result

n,m = map(int,sys.stdin.readline().split());
pan = [list(map(int,sys.stdin.readline().split())) for _ in range(n)]
ds = [list(map(int,sys.stdin.readline().split())) for _ in range(m)];
print(solution(n, m, pan, ds));