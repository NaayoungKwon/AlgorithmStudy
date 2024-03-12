import sys
import heapq
import itertools

def solution(n,m,k,pan):

    start, end = 0, n
    mid = (start+end) // 2
    low = 0
    result = ''
    while start <= end:
        cnt = 1
        history = '1'
        prev = pan[0]
        for i in range(1,k):
            if pan[i] - prev >= mid:
                cnt += 1
                history += '1'
                prev = pan[i]
            else:
                history += '0'

        if cnt < m:
            end = mid - 1
            mid = (start + end) //2
        elif cnt >= m:
            c = 0
            for i in range(k):
                if history[i] == '1':
                    c += 1
                    if c == m:
                        history = history[:i+1] + '0' * (k - i-1)
                        break
            if low < mid:
                low = mid
                result = history
            elif low == mid and int(result if len(result) else '0') < int(history):
                result = history
            # 더 클 수 있는지 확인
            start = mid +1
            mid = (start + end) // 2
    return result


n,m,k = map(int,sys.stdin.readline().split());
myList = list(map(int,sys.stdin.readline().split())) ;
print(solution(n, m, k, myList));