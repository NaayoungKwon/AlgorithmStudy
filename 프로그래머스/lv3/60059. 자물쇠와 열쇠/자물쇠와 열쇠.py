def solution(key, lock):
    answer = True
    # lock x3 배로 만드는데, 외곽은 2로 둔다
    # 중간부분만 lock으로 만든다
    # lock의 돌기 갯수를 저장해둔다.
    # key를 위왼쪽 -> 아래오른쪽으로 가면서 돌기를 전부 맞추는지 확인한다
    # 이걸 90씩 돌려가며 반복해본다
    n = len(key)
    m = len(lock)
    cnt = 0
    big_lock = [[2] * (m*3) for _ in range(m*3)]
    for i in range(m):
        big_lock[m+i] = [2] * m + lock[i][:] + [2] * m
        cnt += lock[i].count(0)
    
    for r in range(4):
        for i in range(m*3 -n):
            for j in range(m*3 -n):
                next_flag = False
                left = cnt
                for x in range(n):
                    if next_flag:
                        break;
                    for y in range(n):
                        if (big_lock[i+x][j+y] == 1 and key[x][y] == 1):
                            next_flag = True
                            break
                            
                        elif big_lock[i+x][j+y] == 0 and key[x][y] == 1:
                            left -= 1;
                        
                        if left == 0:
                            return True;
        key = list(map(list, zip(*key[::-1])))
    return False