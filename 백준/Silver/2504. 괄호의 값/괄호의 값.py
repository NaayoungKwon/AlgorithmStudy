def solution(s):
    answer = 0

    charQ = []

    for c in s:
        if c == '(' or c == '[':
            charQ.append(c)
        elif (c == ')' or c == ']') and len(charQ) > 0:
            if c == ')':
                n = 2
            elif c == ']':
                n = 3

            
            if charQ[-1].isdigit():  #숫자
                num = 0
                while len(charQ) > 0 and charQ[-1].isdigit():
                    num += int(charQ.pop())
                if len(charQ) > 0 and ((n == 2 and charQ[-1] == '(') or (n == 3 and charQ[-1] == '[')):
                    charQ.pop()
                else:
                    return 0
                charQ.append(str(num * n))
            elif (n == 2 and charQ[-1] == '(') or (n == 3 and charQ[-1] == '['):
                charQ.pop()
                charQ.append(str(n))
            else:
                return 0
        else:
            return 0

    for i in charQ:
        if i.isdigit():
            answer += int(i)
        else:
            return 0
    return answer

N = input()
print(solution(N))