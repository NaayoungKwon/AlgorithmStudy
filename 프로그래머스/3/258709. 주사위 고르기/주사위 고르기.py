import itertools
import bisect

def solution(dice):
    answer = []
    max_com = 0
    max_list = []
    # dice 중 절반을 고른다
    n = len(dice)
    for mine in itertools.combinations(range(n), n//2):
        my_dice = [dice[i] for i in mine]
        your_dice = [dice[i] for i in set(range(n)) - set(mine)]
        l = n//2
        my_sum = []
        your_sum = []
        for com_list in list(itertools.product(list(range(6)), repeat=l)):
            my_sum.append(sum([my_dice[idx][element] for idx, element in enumerate(com_list) ]))
            your_sum.append(sum([your_dice[idx][element] for idx, element in enumerate(com_list) ]))

        win = 0
        
        a_count = dict()
        your_sum.sort()
        for e in my_sum:
            if e not in a_count:
                a_count[e] = 1
            else:
                a_count[e] += 1

        for a in a_count.keys():
            small = bisect.bisect_left(your_sum, a)
            win += (small * a_count[a])

    # 절반이 k개면 k^k의 조합을 만들고 이걸 또 더한 배열을 만든다
    # 이 배열과 상대팀 배열을 또 u^2로 비교해서 승률을 각각 저장한다
        if max_com < win:
            max_com = win
            max_list = mine
    # result = []
    # for i in max_list:
    #     # print(i)
    #     result.append(i+1)
    return [i + 1 for i in max_list] #list(set(range(n)) - set(max_list))