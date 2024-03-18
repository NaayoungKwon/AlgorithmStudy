import sys

def check(n, l, path):
    make = [False] * n
    for i in range(n-1):
        compare = path[i+1] - path[i]
        if compare == 0:
            continue
        elif abs(compare) > 1:
            return False
        elif compare == 1: # 증가
            if i+1 < l: # 앞에 그만큼 없을 때
                return False
            for j in range(i-l+1, i+1):
                if j < 0 or j >= n:
                    return False
                if path[j] != path[i] or make[j] == True: # 뒤의 l개가 값이 다 같아야한다
                    return False
                make[j] = True
        elif compare == -1: # 감소
            if i+l >= n: 
                return False
            for j in range(i+1, i+l+1):
                if j < 0 or j >= n:
                    return False
                if path[j] != path[i+1] or make[j] == True: # 뒤의 l개가 값이 다 같아야한다
                    return False
                make[j] = True
    
    return True

def solution(n, l , pan):

    cnt = 0
    for i in range(n):
        cnt += (1 if check(n, l,  pan[i]) else 0)
        # print(i, cnt)
    for i in range(n):
        path = [pan[j][i] for j in range(n)]
        cnt += (1 if check(n, l, path) else 0) 
        # print(i, cnt)
    return cnt

n,l = map(int,sys.stdin.readline().split());
myList = [list(map(int,sys.stdin.readline().split())) for _ in range(n)];
print(solution(n, l, myList));