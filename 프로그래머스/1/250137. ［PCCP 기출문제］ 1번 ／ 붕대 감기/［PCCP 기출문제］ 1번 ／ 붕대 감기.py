def solution(bandage, health, attacks):
    answer = 0
    b_try = 0
    next_attack = 0
    max_health = health
    for i in range(1, attacks[-1][0] + 1):
        if i == attacks[next_attack][0]: # 공격
            health -= attacks[next_attack][1]
            next_attack += 1
            b_try = 0
        else:
            b_try += 1
            health += (bandage[1] + (bandage[2] if b_try == bandage[0] else 0))
            health = min(health, max_health)
            
            b_try = b_try if b_try < bandage[0] else 0
            
        # print(i, health, b_try)
        if health <= 0:
            return -1
    return health