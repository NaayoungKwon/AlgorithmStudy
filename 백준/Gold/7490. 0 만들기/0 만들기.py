import sys
import itertools

def solution(n):

    arr = list(range(1, n+1))
    cal = ['-', '+', ' ']
    result = []

    for cals in itertools.product(cal, repeat= n-1):

        a = [arr[0]]
        b = []
        for i in range(n-1):
            if cals[i] == ' ':
                a[-1] = a[-1] * 10 + arr[i+1]
            else:
                a.append(arr[i+1])
                b.append(cals[i])

        sum = a[0]     
        for i in range(len(b)):
            if b[i] == '-':
                sum -= a[i+1]
            elif b[i] == '+':
                sum += a[i+1]
    
        
        # print(s, sum)
        if sum == 0:
            s = str(arr[0])
            for i in range(n-1):
                s += (cals[i] + str(arr[i+1]))  
            result.append(s)
    # print('ss')
    result.sort()
    for l in result:
        print(l)



T = int(sys.stdin.readline());
for i in range(T):
    n = int(sys.stdin.readline());
    solution(n);
    if i != T-1:
        print()