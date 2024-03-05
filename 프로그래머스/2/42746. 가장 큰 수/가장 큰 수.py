
def solution(numbers): # 45분까지
    answer = ''
    str_numbers = list(map(str, numbers))
    str_numbers.sort(key=lambda x:x*3, reverse=True)
    return str(int(answer.join(str_numbers)))