class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left,right=0,0
        maxLength=0
        map={}
        for ind,ch in enumerate(s):
            if(ch not in map):
                map[ch]=ind
            else:
                left=max(left,map.get(ch)+1)
                map[ch]=ind
            length=(ind-left)+1
            maxLength=max(length,maxLength)
        return maxLength