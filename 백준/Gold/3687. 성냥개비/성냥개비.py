import sys

#map = { 1 : [], 2 : [1], 3:[7], 4:[4], 5:[5], 6:[6,9,0], 7:[8] }
min_dp = [''] * 101
min_dp[2] = '1'
min_dp[3] = '7'
min_dp[4] = '4'
min_dp[5] = '2'
min_dp[6] = '6'
min_dp[7] = '8'

max_dp = [''] * 101
max_dp[2] = '1'
max_dp[3] = '7'
max_dp[4] = '11'
max_dp[5] = '71'
max_dp[6] = '111'
max_dp[7] = '711'

def max_merge_sort(a,b):
    a_len = len(a)
    b_len = len(b)
    arr = ''
    a_i, b_i = 0,0

    while a_i < a_len and b_i < b_len:
        if a[a_i] > b[b_i]:
            arr += (a[a_i])
            a_i += 1
        else:
            arr += (b[b_i])
            b_i += 1

    if a_i == a_len:
        arr = arr + b[b_i:]
    else:
        arr = arr + a[a_i:]
    
    return arr

def min_merge_sort(a,b):
    a_len = len(a)
    b_len = len(b)
    arr = ''
    a_i, b_i = 0,0

    while a_i < a_len and b_i < b_len:
        if a[a_i] < b[b_i]:
            arr += (a[a_i])
            a_i += 1
        else:
            arr += (b[b_i])
            b_i += 1

    if a_i == a_len:
        arr = arr + b[b_i:]
    else:
        arr = arr + a[a_i:]
    
    return arr[0] + arr[1:].replace('6', '0')

def find_max(n):
    for i in range(8, n+1):
        if max_dp[i] != '':
            continue
        
        k = '0'
        for j in range(i-2, i//2, -1):
            k = max(int(k), int(max_merge_sort(max_dp[j],max_dp[i-j])))
        max_dp[i] = str(k)

    return max_dp[n]

def find_min(n):

    for i in range(8, n+1):
        if min_dp[i] != '':
            continue

        k = '9' * n
        for j in range(i-2, (i//2) -1, -1):
            k = min(int(k), int(min_merge_sort(min_dp[j],min_dp[i-j])))
        min_dp[i] = str(k)

    return min_dp[n]



t = int(sys.stdin.readline());
for _ in range(t):
# for n in range(2,101):
    n = int(sys.stdin.readline())
    max_n = find_max(n)
    min_n = find_min(n)
    print(min_n, max_n);