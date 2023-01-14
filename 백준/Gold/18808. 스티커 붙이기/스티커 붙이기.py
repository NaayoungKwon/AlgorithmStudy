import sys

def 회전(sticker):
    n = len(sticker);
    m = len(sticker[0]);
    new_sticker = [[0] * n for _ in range(m)];
    for i in range(n):
        for j in range(m):
            new_sticker[j][n-1-i] = sticker[i][j];
    return new_sticker;

def 붙일수있나(pan, n,m,x,y,sticker):
    flag = False;
    for i in range(len(sticker)):
        for j in range(len(sticker[0])):
            if pan[i+x][j+y] == 1 and sticker[i][j] == 1:
                return False;
    for i in range(len(sticker)):
        for j in range(len(sticker[0])):
            if sticker[i][j] == 1:
                pan[i+x][j+y] = 1;
    return True;

def 갯수(sticker):
    cnt = 0;
    for i in range(len(sticker)):
        for j in range(len(sticker[0])):
            if sticker[i][j] == 1:
                cnt += 1;
    return cnt;

def solution(n, m, k, stickers):
    result = 0;
    pan = [[0] * m for _ in range(n)];
    for i in range(k):     # 스티커 별로
        sticker = stickers[i][:];
        for _ in range(4): # 90도 씩 회전
            is_attached = False;
            if len(sticker) > n or len(sticker[0]) > m:
                sticker = 회전(sticker);
                continue;
            for x in range(n -len(sticker)+1):
                for y in range(m-len(sticker[0]) +1):
                    is_attached = 붙일수있나(pan,n,m, x,y,sticker);
                    if is_attached:
                        result += 갯수(sticker);
                        break;
                if is_attached:
                    break;
            if is_attached:
                break;
            else:
                sticker = 회전(sticker);
    return result;

n, m, k = map(int,sys.stdin.readline().split());
sticker = [[] for _ in range(k)];
for i in range(k):
    r,c = map(int,sys.stdin.readline().split());
    sticker[i] = [list(map(int,sys.stdin.readline().split())) for _ in range(r)];
print(solution(n, m, k, sticker));