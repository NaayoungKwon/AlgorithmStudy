import sys

def cal(n, point, result):
    while n:
        result[int(n%10)] += point;
        n = int(n / 10);

def addLast(n, point, result):
    temp = [0] + [point] * n + [0] * (9-n);
    for i in range(10):
        result[i] += temp[i];

def solution(n):
    result = [0] * 10;
    P = [0] + [1]*9;
        
    point = 1;
    while n:
        if n < 10:
            addLast(n,point,result);
            return result;
        
        while n % 10 != 9:
            cal(n,point,result);
            n -= 1;
        
        n = int(n / 10);
        for i in range(10):
            result[i] += ((n*point) + P[i]*point);
        point *= 10;
        
    
    return result;
  
n = int(sys.stdin.readline());
print(*solution(n));