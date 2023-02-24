import sys

def solution2(n,k,arr):
    m = max(arr);
    len_arr = [0] * (m+1);
    cnt = 0;
    l = 0;
    r = -1;
    for i, value in enumerate(arr):
        if len_arr[value] == k:
            cnt = max(cnt, r-l+1);
            flag = True;
            while flag:
                if arr[l] == value:
                    flag = False;
                len_arr[arr[l]] -= 1;
                l += 1;
        len_arr[value] += 1;
        r = i;

    return max(cnt, r-l+1)

n,k = map(int,sys.stdin.readline().split());
myList = list(map(int,sys.stdin.readline().split()));
print(solution2(n, k, myList));