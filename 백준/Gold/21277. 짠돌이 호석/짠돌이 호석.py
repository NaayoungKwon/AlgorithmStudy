import sys

def rotate(puz):
    n = len(puz);
    m = len(puz[0]);
    new_puz = [[0] * n for _ in range(m)];
    for i in range(n):
        for j in range(m):
            new_puz[j][n-1-i] = puz[i][j];
    return new_puz;

def next(n,m,i,j):
    if j+1 == m:
        return (i+1,0);
    return (i, j+1);
def solution(n1, m1, n2, m2, puz1, puz2):

    result = (min(n1,m1)*min(n2,m2))*(max(n1,m1)*max(n2,m2));
    puzList = [puz2];
    for _ in range(3):
        new_puz = rotate(puzList[-1]);
        puzList.append(new_puz);
    
    i = 0;
    j = 0;
    while i < n1 and j < m1:
        for k in range(4):
            ti, tj = i, j;
            puz = puzList[k];
            flag = True;
            n, m = len(puz), len(puz[0]);
            max_i, max_j = 0,0;
            for ui in range(n):
                for uj in range(m):
                    if ti >= n1 or tj >= m1:
                        tj += 1;
                        continue;
                    elif int(puz[ui][uj]) + int(puz1[ti][tj]) <= 1:
                        tj += 1;
                    else:
                        flag = False;
                        break;
                if flag == False:
                    break;
                ti += 1;
                max_j = max(max_j, tj,m1);
                max_i = max(max_i,ti,n1);
                tj = j;
            if flag:
                result = min(result, max_i*max_j);
        
        if j+1 == m:
            i += 1;
            j = 0;
        else:
            j += 1;
    return result;

n1, m1 = map(int,sys.stdin.readline().split());
myList = [];
for _ in range(n1):
    l = sys.stdin.readline()[:-1];
    myList.append(l);
n2, m2 = map(int,sys.stdin.readline().split());
myList2 = [];
for _ in range(n2):
    l = sys.stdin.readline()[:-1];
    myList2.append(l);
print(solution(n1, m1, n2, m2, myList, myList2));