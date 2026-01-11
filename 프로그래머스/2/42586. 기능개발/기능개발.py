import math
def solution(progresses, speeds):
    answer = []
    # 남은 일 수를 우선 계산
    # [7,3,9]
    days = [0] * len(speeds)
    for i in range(len(speeds)):
        days[i] = math.ceil((100 -progresses[i]) / speeds[i])
        
    m = days[0]
    c = 1
    # if len(days) == 1:
    #     return [1]
    for i in range(1, len(days)):
        if m >= days[i]:
            c += 1
        else:
            answer.append(c)
            m = days[i]
            c = 1
        if i == len(days) -1 :
            answer.append(c)
    return answer