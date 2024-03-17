import itertools

def solution(friends, gifts):
    answer = 0
    n = len(friends)
    fmap = dict()
    for i in range(n):
        fmap[friends[i]] = i
    
    log = [[0] * n for _ in range(n)]
    for gift in gifts:
        a, b = gift.split(' ')
        log[fmap[a]][fmap[b]] += 1
    
    # 선물 지수 구하기
    levels = [0] * n
    for person in friends:
        to_friends = sum(log[fmap[person]])
        from_friends = sum([log[i][fmap[person]] for i in range(n)])
        level = to_friends - from_friends
        levels[fmap[person]] = level
    
    next_gift = [0] * n
    for a, b in itertools.combinations(range(n), 2):
        a_to_b = log[a][b]
        b_to_a = log[b][a]
        if a_to_b > b_to_a or (a_to_b == b_to_a and levels[a] > levels[b]): #a가 더 ㄴ많이줌
            next_gift[a] += 1
        elif a_to_b == b_to_a and levels[a] == levels[b]:
            continue
        else:
            next_gift[b] += 1
    return max(next_gift)