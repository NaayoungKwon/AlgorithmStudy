import math
import collections
import itertools

def solution(weights):
    wc = {}
    answer = 0
    for w, cnt in collections.Counter(weights).most_common():
        wc[w] = cnt
        if cnt > 1:
            answer += (math.comb(cnt, 2))
    
    sisoW = collections.defaultdict(list)
    sisoS = set()
    
    for weight in set(weights):
        for m in range(2,5):
            sisoW[weight * m].append(weight)
    
    # print(sisoW)
    for v in sisoW.values():
        for k in itertools.combinations(v,2):
            # print(k)
            answer += (wc[k[0]] * wc[k[1]])
        # if len(v) == 1:
        #     continue
        # c = 0
        # for i in v:
        #     if i in wc:
        #         c += wc[i]
        #     else:
        #         c += 1
        # answer += math.comb(c, 2)
    
        
    return answer