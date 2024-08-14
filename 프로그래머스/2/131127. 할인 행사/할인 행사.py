def solution(want, number, discount):
    answer = 0
    # 일단 dict에 10일치를 넣어놔
    # 하루 씩 보면서 전에꺼 빼고, 다음날꺼 넣어
    idx_dict = dict()
    n = len(want)
    for i in range(n):
        idx_dict[want[i]] = i
    
    discount_l = [0] * n
    for i in range(10):
        if discount[i] not in idx_dict.keys():
            continue
            
        discount_l[idx_dict[discount[i]]] += 1
    # print(discount_l)
    for i in range(10, len(discount)):
        # print(discount_l, number)
        if discount_l == number:
            answer += 1
        
        if discount[i-10]  in idx_dict.keys():
            discount_l[idx_dict[discount[i-10]]] -= 1
        if discount[i] in idx_dict.keys():
            discount_l[idx_dict[discount[i]]] += 1
    if discount_l == number:
            answer += 1
    return answer