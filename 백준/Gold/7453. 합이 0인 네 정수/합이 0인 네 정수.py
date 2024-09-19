import sys
# import bisect
def solution(n,A,B,C,D):
    
    s1, s2 = [], dict()
    for i in range(n):
        for j in range(n):
            s1.append(A[i] + B[j])
            c = (C[i] + D[j])
            s2[c] = s2.get(c,0)+1
    
    result = 0

    for a in s1:
        result += s2.get(-a,0)

    return result


n = int(sys.stdin.readline());
A = [0] * n
B = [0] * n
C = [0] * n
D = [0] * n
for i in range(n):
    a,b,c,d = map(int,sys.stdin.readline().split(' '));
    A[i] = a
    B[i] = (b);
    C[i] = (c);
    D[i] = (d);
print(solution(n, A,B,C,D));