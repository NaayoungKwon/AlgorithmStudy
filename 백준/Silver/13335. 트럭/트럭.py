import sys
from collections import deque

def solution(n,w,l,trucks):

    time = 0
    sum_que = 0
    i = 0
    que = []
    # que의 길이는 몇 초가 지났는지를 의미한다.
    # len = 1, l = 4이면 3초 뒤에 빈다
    for i in range(n):
        while True:
            if len(que) == l:
                fw = que.pop(0);
                sum_que -= fw
            if sum_que + trucks[i] <= w:
                break
            
            time += 1
            que.append(0)
            
        # time += 1
        que.append(trucks[i])
        sum_que += trucks[i]
        time += 1
            
    # while que:
    #     fw, ft = que.pop(0);
    #     time += (l - time + ft)
    return time + l

n,l,w = map(int,sys.stdin.readline().split());
myList = list(map(int,sys.stdin.readline().split())) ;
print(solution(n, w,l,myList));