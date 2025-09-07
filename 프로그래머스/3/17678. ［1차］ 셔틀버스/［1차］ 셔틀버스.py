import collections
def solution(n, t, m, timetable):
    answer = ''
    # 9시부터 출발하면서 t를 기준으로 돈다
    # timetable에서 출발시간까지 들어갈 수 있는 애를 구한다
    # max(걔들 중 가장 뒤에 있는거, 현재 출발시간, 누적 최대) 를 구해서 업데이트
    start = 9 * 60
    last_possible = start + t*(n-1)
    i = 0
    l = len(timetable)
    result = start
    timetable.sort()
    
    wait = collections.deque()
    for ta in timetable:
        tt = s_to_time(ta)
        wait.append(tt)
    
    # if t * m <= len(timetable) and last_possible >= wait[-1]:
    #     return time_to_s(wait[-1] -1)
    
    while True:
        if start > last_possible:
            break
        # print(time_to_s(start))
        cnt = []
        while wait:
            if wait[0] > start:
                if len(cnt) < m:
                    result = start
                break
            w = wait.popleft()

            if len(cnt) + 1 == m:
                result = w-1
                cnt.append(w)
                break
            
            result = w
            cnt.append(w)
        if len(wait) == 0 and len(cnt) < m:
            result = start
        elif len(wait) == 0 and len(cnt) == m:
            result = cnt[-1] -1
            

        start += t
        
    return time_to_s(result)

def s_to_time(s):
    h, m = s.split(":")
    return int(h) * 60 + int(m)

def time_to_s(tt):
    return str(tt//60).zfill(2) + ":" + str(tt%60).zfill(2)

