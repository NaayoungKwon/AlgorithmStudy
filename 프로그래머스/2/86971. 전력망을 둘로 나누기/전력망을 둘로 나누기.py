from collections import Counter

def solution(n, wires):
    answer = 100000
    # for문을 돌면서 해당 idx의 것이 없을 때 몇개로 나뉘는지 찾는다
    wires.sort()
    for exclude in range(n-1):
        arr = [i for i in range(n+1)]
        for i in range(n-1):
            if i == exclude:
                continue
            arr = union(arr, wires[i][0], wires[i][1])
        for i in range(1, n):
            arr[i] = find(arr, i);
            
        a = 0
        b = 0
        for i in range(1, n+1):
            if find(arr, i) == 1:
                a += 1
        b = n - a
        answer = min(answer, abs(a-b))
        # c = Counter(arr[1:]).most_common()
        # if len(c) > 2:
        #     continue
            # print(exclude, arr)
        # answer = min(answer, abs(c[0][1] - c[1][1]))
            
    return answer

def union(arr, i, j):
    a = find(arr, i)
    b = find(arr, j)
    if a < b:
        arr[b] = a
    else:
        arr[a] = b
    return  arr

def find(arr, i):
    if arr[i] != i:
        arr[i] = find(arr, arr[i])
    return arr[i]
    