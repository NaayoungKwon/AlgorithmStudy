import sys

def solution(n, arr):
    result = set()
    
    for i in range(1, n+1):
        start_e = [i]
        end_e = [arr[i]]
        cnt = 0
        while cnt < n:
            e = end_e[-1]
            if arr[e] == start_e[0]:
                start_e.append(e)
                result.update(set(start_e))
                break
            else:
                start_e.append(e)
                end_e.append(arr[e])
            cnt += 1

    print(len(result))
    # print(result)
    for i in sorted(result):
        print(i)


n = int(sys.stdin.readline());
myList = [-1] + [int(sys.stdin.readline()) for i in range(n)];
solution(n, myList);