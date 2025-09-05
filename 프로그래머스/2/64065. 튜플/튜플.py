import re

def parse_to_2d(s):
    # 중첩 중괄호를 건너뛰고, 가장 안쪽의 { ... } 들만 추출
    chunks = re.findall(r'\{([^{}]*)\}', s)
    result = []
    for c in chunks:
        c = c.strip()
        if not c:                   # "{}" 같은 빈 집합 처리
            result.append([])
            continue
        nums = [int(x) for x in c.split(',') if x.strip()]
        result.append(nums)
    return result

def solution(s):
    result = parse_to_2d(s)
    result.sort(key=len)
    sset = set()

    answer = []
    for r in result:
        new_n = list(set(r) - sset)[0]
        answer.append(new_n)
        sset.add(new_n)

    return answer