import sys

# prev_pointer = []
def move(n, arr):
    # 벨트 회전
    last = arr[2*n -1]
    # print("prev: ", arr)
    for i in range(2*n-1, 0, -1):
        if i == n:
            arr[i] = (False, arr[i-1][1])
        else:
            arr[i] = arr[i-1]
    arr[0] = last
    # print("belt move : ", arr)
    
    # 로봇 이동
    for i in range(n-1, 0, -1):
        if i == n-1 and arr[i][0]:
            arr[i] = (False, arr[i][1])
        if arr[i-1][0] and not arr[i][0] and arr[i][1] > 0:
            arr[i] = (True, arr[i][1]-1)
            arr[i-1] = (False, arr[i-1][1])

    # 로봇 올리기
    if not arr[0][0] and arr[0][1] > 0:
        arr[0] = (True, arr[0][1]-1)
    # print("robot move : ", arr)
    return arr


def solution(n, k, arr):
    step = 1
    # prev_pointer = [2*n-1] + list(range(2*n-1))
    rarr = [0] * (2*n)
    for i in range(2*n):
        rarr[i] = (False, arr[i])

    while True:
        rarr = move(n, rarr)
        zero_cnt = sum(1 for i in range(2*n) if rarr[i][1] == 0)
        if zero_cnt >= k:
            return step
        step += 1
    return 0


n,k = map(int,sys.stdin.readline().split(' '));
myList = list(map(int,sys.stdin.readline().split(' ')))
print(solution(n, k, myList));