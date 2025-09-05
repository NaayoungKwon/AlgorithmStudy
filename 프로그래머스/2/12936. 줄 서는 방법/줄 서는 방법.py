import math

def solution(n, k):
    answer = []
    arr = list(range(1, n+1))
    
    t = math.factorial(len(arr)-1)
    while len(arr) > 0:
        
        fac = math.factorial(len(arr)-1)
        t = (k-1) // fac
        answer.append(arr[t])
        del arr[t]
        k = (k-1) % fac + 1
    return answer