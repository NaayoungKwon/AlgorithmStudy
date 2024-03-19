import sys
import heapq

def arr_sort(A):
    # 행 별로 연산한다
    # set으로 count를 세고 heap에 넣는다 (count, value)
    # 빼면서 (수, 횟수) 순으로 넣는다
    # 제일 긴 행을 기준으로 0 padding
    max_len = 0
    for i in range(len(A)):
        arr = []
        new_arr = []
        count_dict = { x : 0 for x in A[i] if x > 0}
        for j in range(len(A[i])):
            if A[i][j] > 0:
                count_dict[A[i][j]] += 1
        for k, v in count_dict.items():
            heapq.heappush(arr, (v,k))
        while arr:
            count, value = heapq.heappop(arr)
            new_arr.extend([value, count])
        A[i] = new_arr if len(new_arr) <= 100 else new_arr[:100]
        max_len = max(max_len, len(A[i]))

    for i in range(len(A)):
        if len(A[i]) < max_len:
            A[i].extend([0] * (max_len - len(A[i])))
    return A

def solution(r,c,k,A):

    time = 0;
    while time <= 100:
        if len(A) <= r or len(A[0]) <= c:
            result = 1
        elif A[r][c] == k:
            break

        if len(A) >= len(A[0]): # 연산 R
            A = arr_sort(A)
        else: # 연산 C
            B = list(map(list, zip(*A[::-1]))) # 회전 해서 연산
            B = arr_sort(B)
            # 다시 돌려서 넣음
            A = list(map(list, zip(*B)))#[::-1]
        time += 1

    return time if time <= 100 else -1

r,c,k = map(int,sys.stdin.readline().split());
pan = [list(map(int,sys.stdin.readline().split())) for _ in range(3)]
print(solution(r-1,c-1,k,pan));