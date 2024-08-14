def solution(data, col, row_begin, row_end):
    
    data.sort(key=lambda x : (x[col-1], -x[0]))
    s = []
    # print(data)
    for i in range(row_begin, row_end+1):
        sums = sum([a % i for a in data[i-1]])
        s.append(sums)
    # print(s)
    answer = s[0]
    for c in s[1:]:
        answer = answer ^ c
    return answer