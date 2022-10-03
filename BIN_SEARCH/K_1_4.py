import math;

def findK(num):
    j = 0;
    k = 0;
    while num > math.pow(2,j):
        j += 1;
    while j+1 > math.pow(2,k):
        k += 1;
    return (k, int(math.pow(2,k))-1); 

def solution(nodeList):
    answer = [];
    
    for num in nodeList:
        binNum = format(num, 'b');
        h, k = findK(num);
        binList = [];
        if len(binNum) == k:
            binList = ['x'] +list(binNum);
        else:
            binList = ['x','0'] + list(binNum);
        
        n = 1;
        st = [1];
        que = ['x'];
        while st and n <= k:
            if 2 * n <= k:
                st.append(2*n);
                n *= 2;
            else:
                que.append(st.pop());
                if st:
                    n = st.pop();
                    que.append(n);
                    if (2*n) + 1 <= k:
                        st.append((2*n)+1);
                        n = (2*n) +1;

        
        i = 1;
        flag = True;
        for i in range(1, k+1):
            idx = que.index(i);
            if binList[idx] == '0' and (2*i)+1 <= k and (binList[que.index(i*2)] == '1' or binList[que.index((i*2)+1)] == '1'):
                flag = False;
                break;
            
        if flag:
            answer.append(1);
        else:
            answer.append(0);
                    
    return answer;

print('my answer : ', solution([58,7,5]), 'real : [1,1,0]');
print('my answer : ', solution([63,111,95]), 'real : [1,1,0]');