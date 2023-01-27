import sys

def solution(s):

    result = '';
    tag = False;
    arr = [];
    for c in s:
        if c == '<':
            tag = True;
            if len(result) and result[-1] != '>':
                result += ' ';
            while arr:
                result += (arr.pop());
            result += c;
        elif c == '>':
            tag = False;
            result += c;
        elif tag:
            result += c;
        elif tag == False and c != ' ':
            arr.append(c);
        else:
            # print(result+ ' ?')
            if len(result) and result[-1] != '>':
                result += ' ';
            while arr:
                result += (arr.pop());
    if len(result) and result[-1] != '>' and arr:
        result += ' ';
    while arr:
        result += (arr.pop());
    return result.replace('\n','');

s= (sys.stdin.readline());
print(solution(s.replace('\n','')));