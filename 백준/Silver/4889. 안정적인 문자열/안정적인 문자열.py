import sys

def solution(s):

    result = 0;
    if len(s) == 0:
        return 0;

    idx = 0;
    # {} 로 되어있는걸 계속 없앤다
    # 남아있는건 {{ , }} , }{ 
    # 하나 씩 바꿨을 때 {}가 되면 빼고 cnt + 1
    while '{}' in s:
        s = s.replace('{}','');
    # print(s);
    while idx < len(s):
        # print(s[idx:idx+2]);
        if s[idx:idx+2] in ['{{', '}}']:
            result += 1;
        elif s[idx:idx+2] == '}{':
            result += 2;
        idx += 2;
    return result;

index = 1;
while True:
    s = sys.stdin.readline();
    if '-' in s:
        break;
    print('{0}. {1}'.format(index, solution(s)))
    # print(index, '. ' ,solution(s));
    index += 1;