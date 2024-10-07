import sys

def solution(arr):

    money = 0
    mm = 0

    for a in arr:
        money += (a[0] * a[1])
        mm = max(mm, a[0])
        # ms.extend([a[0]] * a[1])

    if money % 2 == 1 or money // 2 < mm:
        return 0
    
    money //= 2
    dps = [True] + [False] * (money)
    
    for i in range(len(arr)):
        c, m = arr[i]
        for n in range(money, c-1, -1):
            if dps[n-c]:
                for j in range(m):
                    if n + c*j <= money:
                        dps[n+c*j] = True
                    else:
                        break
        if dps[money]:
            return 1
    
    return 1 if dps[money] else 0


for _ in range(3):
    n = int(sys.stdin.readline());
    myList = [list(map(int,sys.stdin.readline().split(' '))) for i in range(n)];
    print(solution( myList));