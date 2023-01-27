import sys


def solution(n, m, plan):

    tickets = [[0,-3],[1,0], [3,1], [5,2]];
    pay = [0,10000, 25000, 37000];
    coupon_change = 3;
    dp = [(0,0)] * (n+1); #총 가격, 잔여 쿠폰
    left_days = [0] * (n+1);

    for i in range(n-1, 0,-1):
        left_days[i] = left_days[i+1] + (1 if plan[i+1] else 0);

    for i in range(1,n+1):
        if plan[i] == False: # 다른 일정
            dp[i] = dp[i-1];
            continue;
        
        for idx, (day, coupon) in enumerate(tickets):
            if day == 0 and dp[i][1] < 3: # 쿠폰 없으면 넘겨
                continue;
            
            j = i + day-1;
            for j in range(i+day-1, n):
                k = j - day;
                if plan[j] == False:
                    dp[j] = dp[j-1];
                elif dp[j][0] == 0:
                    dp[j] = (dp[k][0] + pay[idx], dp[k][1] +coupon);
                elif left_days[j] > 0: # 쿠폰을 고려한 비교
                    if (dp[j][0] - dp[j][1]*3300) > (dp[k][0] + pay[idx] - (dp[k][1] + coupon) *3300):
                        # print(i,j,k,day, dp[j][0] - dp[k][1]*3300, dp[k][0] + pay[idx] - (dp[k][1] + coupon) *3300)
                        dp[j] = (dp[k][0] + pay[idx] , dp[k][1] + coupon);
                else: # 쿠폰을 고려하지 않는 비교
                    if dp[j][0] < dp[k][0] + pay[idx]:
                        dp[j] = (dp[k][0] + pay[idx] , dp[k][1] + coupon);
        # print(dp)
    return dp[n-1][0];

def solution2(n, m, plan):
    inf = sys.maxsize;
    dp = [[inf] * (110) for _ in range(n+3)];
    tickets = [[0,-3],[1,0], [3,1], [5,2]];
    pay = [0,10000, 25000, 37000];
    coupon_change = 3;

    dp[0][0] = 0;
    for i in range(n+1):
        for j in range(110):
            if dp[i][j] == inf:
                continue;

            if i < n and plan[i+1] == False: # 쉬는날
                dp[i+1][j] = min(dp[i][j], dp[i+1][j]);

            cost = dp[i][j];
            # 하루
            if i+1 <= n and dp[i+1][j] > cost + 10000:
                dp[i+1][j] = cost + 10000;
            # 삼일권
            for day in range(1, 4):
                k = i + day;
                if k <= n and dp[k][j+1] > cost + 25000:
                    dp[k][j+1] = cost + 25000;
            # 5일권
            for day in range(1, 6):
                k = i + day;
                if k <= n and dp[k][j+2] > cost + 37000:
                    dp[k][j+2] = cost + 37000;
            # 쿠폰쓴 경우
            if i+1 <= n and j >= 3 and dp[i+1][j-3] > cost:
                dp[i+1][j-3] = cost;
    # print(dp[1])  
    # print(dp[n])           
    return min(dp[n]);

n,m = map(int,sys.stdin.readline().split());
myList = list(map(int,sys.stdin.readline().split()));
arr = [True] * (n+1);
for m in myList:
    arr[m] = False;
print(solution2(n, m, arr));