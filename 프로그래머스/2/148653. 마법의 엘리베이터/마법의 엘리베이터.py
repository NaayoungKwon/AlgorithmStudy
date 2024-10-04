
def solution(storey):
    answer = 0
    
    i = 1
    while storey > 0:
        k = storey // i
        c = int(str(k)[-1])
        if k == 0:
            break
        elif c < 5 or (c==5 and (len(str(k)) == 1 or int(str(k)[-2]) < 5)):
            answer += c
            storey -= (i*c)
        else:
            storey += ((10-c) * i)
            answer += (10-c)
        # print(k, answer , storey)
        i *= 10
    
    return answer