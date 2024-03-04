def solution(sequence, k):
    answer = []
    start = 0
    p_sum = 0
    m_len = len(sequence) +1
    for i in range(len(sequence)):
        p_sum += sequence[i]
        while p_sum > k:
            p_sum -= sequence[start]
            start += 1
        if p_sum == k and m_len > i-start +1:
            m_len =  i - start + 1
            answer = [start, i]
            
            
    return answer