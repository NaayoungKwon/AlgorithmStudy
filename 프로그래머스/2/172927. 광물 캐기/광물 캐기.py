import itertools
def solution(picks, minerals):
    answer = 25 * len(minerals)
    tired = [[1,1,1], [5,1,1],[25,5,1]]
    # minerals to minerals_serial
    minerals_serial = get_minerals_serial(minerals)
    # find number of picks 
    picks_num = min(sum(picks), len(minerals) // 5 + (0 if len(minerals) % 5 == 0 else 1))
    my_picks = find_my_picks(picks_num, picks)
    # print(picks_num, my_picks)
    # find permutation and make set
    for arr in set(itertools.permutations(my_picks, picks_num)):
        # print(arr)
        s = 0
        for i in range(len(arr)):
            for j in range(5):
                if i*5 + j < len(minerals_serial):
                    # print(i, j, tired[i][minerals_serial[i*5 + j]])
                    s += tired[arr[i]][minerals_serial[i*5 + j]]
        
        # find mininum result
        answer = min(answer, s)
    
    return answer

def get_minerals_serial(minerals):
    l = []
    for m in minerals:
        if m == "diamond":
            l.append(0)
        elif m == "iron":
            l.append(1)
        else:
            l.append(2)
    return l;

def find_my_picks(n, picks):
    l = []
    for pick in picks:
        if n <= 0:
            l.append(0)
        elif n >= pick:
            l.append(pick)
        else:
            l.append(n)
        n -= pick
    n_l = []
    # print(l) 
    for i in range(3):
        n_l = n_l + [i] * l[i]
    return n_l