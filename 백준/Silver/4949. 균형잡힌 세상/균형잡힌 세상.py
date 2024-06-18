import sys
import re

def solution(s):

    s = re.sub('[a-zA-Z .]', '',s)
    st = []
    for c in list(s):
        if c == '(' or c == '[':
            st.append(c)
        elif c == ')':
            if len(st) == 0 or st[-1] != '(':
                return 'no'
            st.pop()
        elif c == ']':
            if len(st) == 0 or st[-1] != '[':
                return 'no'
            st.pop()
        
    if st:
        return 'no'
    return 'yes'

while True:
    s = input()
    if s == '.':
        break
    print(solution(s))
