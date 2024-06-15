class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n = len(s)
        dp = [False] * (n+1)
        dp[n] = True

        for i in range(n):
            for word in wordDict:
                l = len(word)
                # print(i, l ,s[i-l+1:i+1],word)
                if i+1 < l:
                    continue
                dp[i] = dp[i] or (dp[i-l] and (s[i-l+1:i+1] == word))
        # print(dp)
        return dp[n-1]
        
