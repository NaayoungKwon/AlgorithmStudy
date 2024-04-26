def solution(s):
    answer = []
    index_map = dict()
    
    for i in range(len(s)):
        c = s[i]
        if c in index_map:
            answer.append(i - index_map[c])
        else:
            answer.append(-1)
        index_map[c] = i
            
    return answer