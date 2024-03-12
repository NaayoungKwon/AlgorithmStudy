import sys

def cal(mid, interval, c):
    if max(interval) > mid:
        return (10001, 0)
    cnt = 0
    sum_l = 0
    for i in range(len(interval)-1, -1, -1):
        sum_l += interval[i]
        if sum_l > mid:
            cnt += 1
            sum_l = interval[i]
    return cnt, sum_l if cnt == c else interval[0]

def solution(l, k, c, position):

    result = l;
    first = l
    start, end = 1, l
    interval = [position[i+1] - position[i] for i in range(k+1)]

    while start <= end:
        mid = (start + end) // 2
        cnt, s = cal(mid, interval, c)
        if cnt <= c:
            result = mid
            first = s
            end = mid-1 
        else:
            start = mid +1


    return (result, first)

l,k,c = map(int, input().split())
positions = [0, *sorted([*map(int, input().split())]), l]
print(*solution(l, k, c,positions));