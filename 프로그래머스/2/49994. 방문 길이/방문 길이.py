def make_group(x1, y1, x2, y2):
    if x1 < x2:
        return ((x1, y1), (x2, y2))
    elif x2 < x1:
        return ((x2, y2), (x1, y1))
    else:
        if y1 < y2:
            return ((x1, y1), (x2, y2))
        return ((x2, y2), (x1, y1))
    
def solution(dirs): # 45분
    answer = 0
    # dir 정의한다
    alph_dir = {'L' : [-1, 0], 'D' : [0,-1], 'R' : [1,0], 'U' : [0,1]}
    a = 0
    b = 0
    # set 정의한다
    path = set()
    # 칸을 옮기면서 검사 + ((x1,y1), (x2,y2)) 를 저장한다
    for d in dirs:
        x, y = a + alph_dir[d][0], b + alph_dir[d][1]
        if x >= -5 and x <= 5 and y >= -5 and y <= 5:
            g = make_group(a,b,x,y)
            path.add(g)
            a, b = x, y
            # print(len(path), g)
    # set 길이
    return len(path)