def solution(cap, n, deliveries, pickups):
    answer = 0
    s_deliver = cap
    s_pickup = cap
    last = n
    for i in range(n-1, -1, -1):
        # 지금 완전 빈 상태면 last 갱신
        if s_deliver >= cap and s_pickup >= cap:
            last = i+1
        # print(i, answer, last, s_deliver, s_pickup )
        s_deliver -= deliveries[i]
        s_pickup -= pickups[i]
        
        while s_deliver < cap or s_pickup < cap:
            answer += (i+1)
            s_deliver += cap
            s_pickup += cap
    return answer * 2