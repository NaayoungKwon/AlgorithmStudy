import sys
import re

def solution(s):
    reg = r'([+-]?\d{0,5}x{0,2})'
    arr = []
    for e in re.split(reg, s):
        if e != '':
            arr.append(e)

    # count = len(arr)
    result = ''
    i = '+'
    # print(arr)
    for e in arr:
        if e[0] == '0':
            continue
        if e[-1] == 'x':
            c =  (int(e[:-1])//2)
            if c == 1 or c ==0:
                c = ''
            elif c == -1:
                c = '-'
            else:
                c = str(c)

            result += ( c + 'xx')
        else:
            c = int(e)
            if c == 1 or c ==0:
                c = ''
            elif c == -1:
                c = '-'
            else:
                c = str(c)


            if c != '' and (c == '-' or int(c) < 0):
                result += (c + 'x')
            elif result == '':
                result = (c + 'x')
            else:
                result += ('+' + c  + 'x')
        
    return result + ('+W' if result != '' else 'W')


s = sys.stdin.readline().split('\n')[0];
print(solution(s));