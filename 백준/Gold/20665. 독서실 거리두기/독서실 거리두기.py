import sys
import heapq

def nextSeat(seat, start):
    full = []
    empty = []
    for i in range(1, len(seat)):
        if seat[i] > start:
            full.append(i)
        else:
            empty.append(i)
    
    nextIdx = 1
    maxLen = 0
    for e in empty:
        eMinLen = 200
        for f in full:
            eMinLen = min(eMinLen , abs(e-f))
        if maxLen < eMinLen:
            maxLen = eMinLen;
            nextIdx = e
    
    return nextIdx;

def htom(t):
    h = t//100;
    m = t%100;
    return h * 60 + m;

def solution(n, t, p, arr):

    result = 21 * 60 - 9 * 60;
    # nextPoint 함수로 찾는 과정 필요
    # 각 좌석의 종료 시간을 적어둔다
    seat = [0] * (n+1)
    while arr:
        start, end = heapq.heappop(arr);
        my_seat = nextSeat(seat, start)
        # print(start, my_seat)
        result -= ((htom(end) - htom(start)) if my_seat == p else 0)
        seat[my_seat] = end

    return result

n,t,p = map(int,sys.stdin.readline().split());
myList = []
for _ in range(t):
    s, e = map(int,sys.stdin.readline().split())
    heapq.heappush(myList, (s,e))
print(solution(n, t, p,myList));