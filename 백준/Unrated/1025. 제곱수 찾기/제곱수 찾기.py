import sys
import math 
def solution(n,m,pans):

    result = -1;
    # 2차원을 돈다.
    # (i,j)에서 시작하는데 등차수열은 a,b 이고 이는 -n ~ n , -m ~ m 이다
    
    for i in range(n):
        for j in range(m):
            for a in range(-n+1,n):
                if i + a < 0 or i + a >= n:
                    continue
                for b in range(-m+1,m):
                    if j + b < 0 or j + b >= m:
                        continue
                    num = makeNum(pans, n,m,i, j , a,b)
                    result = max(result, num);

    return result


def makeNum(pans, n,m,i, j , a,b):
    k = 0
    num = 0
    success = -1
    if a == 0 and b == 0 :
        num = pans[i][j]
        sqt = int(math.sqrt(num))
        if num == sqt * sqt:
            return num
        return -1

    while True:
        ti = i + a*k
        tj = j + b*k
        if ti < 0 or ti >= n or tj < 0 or tj >= m:
            break

        num = num * 10 + pans[ti][tj]
        sqt = int(math.sqrt(num))
        if num == sqt * sqt:
            success = num
        k += 1;
    return success

n,m = map(int,sys.stdin.readline().split());
myList = [list(map(int,str(sys.stdin.readline().split()[0]))) for _ in range(n)];
print(solution(n, m,myList));