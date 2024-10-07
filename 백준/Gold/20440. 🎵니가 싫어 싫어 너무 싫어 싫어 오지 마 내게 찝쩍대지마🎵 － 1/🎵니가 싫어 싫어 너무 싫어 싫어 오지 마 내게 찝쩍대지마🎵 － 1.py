import sys

def solution(n, arr):

    ts = {}

    for a in arr:
        ts[a[0]] = 1 + (ts[a[0]] if a[0] in ts.keys() else 0)
        ts[a[1]] = -1 + (ts[a[1]] if a[1] in ts.keys() else 0)
    ks = sorted(ts.keys())
    for i in range(1, len(ks)):
        ts[ks[i]] += ts[ks[i-1]]

    answer = 0
    max_arr = []
    for i in ks:
        if answer < ts[i]:
            answer = ts[i]
            max_arr = [i]
        elif answer > ts[i] and len(max_arr) == 1:
            max_arr.append(i)
    
    if len(max_arr) == 1:
        max_arr.append(ks[-1]+1)

    print(answer)
    print(max_arr[0], max_arr[-1])
    # return answer


n = int(sys.stdin.readline());
myList = [list(map(int,sys.stdin.readline().split(' '))) for i in range(n)];
solution(n, myList)