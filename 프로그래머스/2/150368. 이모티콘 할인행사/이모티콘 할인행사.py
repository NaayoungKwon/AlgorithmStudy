import heapq


def solution(users, emoticons):
    result = []
    markup = [10,20,30,40]
    n = len(emoticons)
    perm = []
    
    def dfs(markups):
        if len(markups) == n:
            this_markup_r = [0,0]
            for user in users:
                plus = 0
                sum = 0
                for i in range(n):
                    if markups[i] < user[0]:
                        continue
                    price = (emoticons[i] * 0.01 * (100 - markups[i]))
                    if sum + price >= user[1]:
                        plus = 1
                        break
                    sum += price
            
                
                if plus == 1:
                    this_markup_r = [this_markup_r[0] + 1, this_markup_r[1]]
                else:
                    this_markup_r = [this_markup_r[0], this_markup_r[1] + sum]
            # print(markups, this_markup_r)
            heapq.heappush(result, [-this_markup_r[0], -this_markup_r[1]])
            return

        for m in markup:
            dfs(markups + [m])


    dfs([])
    top = heapq.heappop(result)
    return [-top[0], -top[1]]

