import sys


def fibo(n):
    data = [0]*15000001;
    data[0] = 0;
    data[1] = 1;
    i = 0;
    
    k = n % 15000000;
    while i < k:
        data[i+2] = (data[i]+ data[i+1]) % 1000000;
        i += 1;
    
    return data[k];
  
n = int(sys.stdin.readline());
print(fibo(n));