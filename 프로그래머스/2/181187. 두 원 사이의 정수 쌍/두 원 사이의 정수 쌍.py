import math
def solution(r1, r2):
    answer = 0
    
    for i in range(1,r2+1):
        k = math.floor(math.sqrt((r2*r2) - (i*i)))
        l = math.ceil(math.sqrt((r1*r1) - (i*i))) if r1 > abs(i) else 0
        # print(i,k,l)

        # arr = set(range(l,k+1))
        # arr.update(list(range(-k, -l+1)))
        # print(set(arr))
        if l == 0:
            answer += ((k-l)*2 + 1)
        elif k == l:
            answer += (2 if l > 0 else 1)
        else:
            answer += ((k-l+1)*2)
        # if i == 0:
        #     answer += (k+1-l)
            # answer += len(arr)
        # else:
        #     answer += (len(arr)*2)
        # for j in range(math.ceil(l), math.ceil(k)+1):
        #     q = math.sqrt(i*i + j*j)
        #     if q >= r1 and q <= r2:
        #         arr.add((i,j))
        #         arr.add((i,-j))
        #         arr.add((-i,j))
        #         arr.add((-i,-j))
                
    return answer*2 + (r2-r1+1)*2