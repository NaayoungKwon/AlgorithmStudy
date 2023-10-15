input_money = int(input())
machine_duck = list(map(int, input().split()))
 
j_cash, s_cash = input_money, input_money    # init current cash
j_stock, s_stock = 0, 0    # init current stock
 
for i in machine_duck:    # calculate joonhyun
    if j_cash >= i:
        j_stock += j_cash // i
        j_cash %= i
 
for i in range(len(machine_duck) - 3):    # calculate sungmin
    if machine_duck[i] > machine_duck[i+1] > machine_duck[i+2]:    # Decreased compared to the previous day (All buy)
        s_stock += s_cash // machine_duck[i+3]
        s_cash %= machine_duck[i+3]
 
    elif machine_duck[i] < machine_duck[i+1] < machine_duck[i+2]:    # Increased compared to the previous day (All sell)
        s_cash += s_stock * machine_duck[i+3]
        s_stock = 0
 
j_asset = [j_cash + (machine_duck[-1] * j_stock)]    # joonhyun profit rate
s_asset = [s_cash + (machine_duck[-1] * s_stock)]    # seongmin profit rate
 
if j_asset > s_asset:
    print('BNP')
elif j_asset < s_asset:
    print('TIMING')
else:
    print('SAMESAME')