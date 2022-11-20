import sys

def solution(n, load):

    total = sum(load);
    result = 0;

    tempSum = total - load[0];
    for i in range(1,n-1):
        tempSum -= load[i];
        result = max(result, total - load[0] - load[i] + tempSum); #sum(load[i+1:]));
    
    for i in range(1, n-1):
        result = max(result, total - load[0] - load[n-1] + load[i]);

    tempSum = load[0];
    for i in range(1, n-1):
        result = max(result, total - load[n-1] - load[i] + tempSum); #sum(load[:i]));
        tempSum += load[i];
        
    return result;

n = int(sys.stdin.readline());
myList = list(map(int,sys.stdin.readline().split())) ;
print(solution(n, myList));