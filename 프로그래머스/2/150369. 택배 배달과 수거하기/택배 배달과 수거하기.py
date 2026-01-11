def solution(cap, n, deliveries, pickups):
    answer = 0
    i = moveLeftToNonZero(n-1, deliveries)
    j = moveLeftToNonZero(n-1, pickups)

    while i >= 0 or j >= 0:
        dcap = cap
        pcap = cap
        next_i = i
        next_j = j
        answer += (max(i,j)+1) * 2
        
        for a in range(i, -1,-1):
            next_i = a
            if dcap >= deliveries[a]:
                dcap -= deliveries[a]
                deliveries[a] = 0
            else:
                deliveries[a] -= dcap
                break

        for a in range(j, -1,-1):
            next_j = a
            if pcap >= pickups[a]:
                pcap -= pickups[a]
                pickups[a] = 0
            else:
                pickups[a] -= pcap
                break
        # print(next_i, next_j, answer)
        i = moveLeftToNonZero(next_i, deliveries)
        j = moveLeftToNonZero(next_j,  pickups)
        
    return answer

def moveLeftToNonZero(last, arr):
    i = last
    while i >= 0 and arr[i] == 0: i-= 1
    return i