n = int(input())
expect_list = {}
for i in range(n):
    a = int(input())
    if a not in expect_list.keys():
        expect_list[a] = 1
    else:
        expect_list[a] = expect_list[a]+1
        
grade = 1
answer = 0
#for key in range(1,n+1):
for key in sorted(expect_list.keys()):
    #if key in expect_list.keys():
    num = expect_list[key]
    for k in range(grade, grade+num):
        answer += abs(k-key)
    grade += num

            
print(answer)