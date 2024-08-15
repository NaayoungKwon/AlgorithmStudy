def solution(plans):
    answer = []
    left = []
    plans.sort(key=lambda x:(x[1],-int(x[2])))
    n = len(plans)
    
    for i in range(n):
        p = plans[i]
        start = list(map(int, p[1].split(":")))
        plans[i] = [p[0], start[0] * 60 + start[1] ,int(p[2])]
    # print(plans)
    for i in range(n):
        i_end = plans[i][1] + plans[i][2]
        if i == len(plans)-1 or i_end <= plans[i+1][1]:
            answer.append(plans[i][0])
            
            # 다음거 할 시간 있나?
            left_time = (plans[i+1][1] if i < n-1 else 24*120*100) - i_end
            while left_time > 0 and left:
                # print(i, left_time, left)
                use = left[-1][1]
                left[-1] = [left[-1][0], left[-1][1] - left_time]
                left_time -= use
                if left[-1][1] <= 0:
                    answer.append(left.pop()[0])
        else:
            t = i_end - plans[i+1][1]
            left.append([plans[i][0], t])
    return answer