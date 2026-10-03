class Solution:
    def minWindow(self, s: str, t: str) -> str:
        n=len(s)
        m=len(t)
        cnt=0
        minLength=float('inf')
        sIndex=-1
        l=0
        r=0
        map={}
        for ch in t :
            map[ch]=map.get(ch,0)+1
             
        while r < n:
            if(map.get(s[r],0) > 0):
                cnt+=1
            map[s[r]]=map.get(s[r],0)-1
            while(cnt==m):
                    if(r-l+1<minLength):
                        minLength=r-l+1
                        sIndex=l
                    map[s[l]]=map.get(s[l],0)+1
                    if(map.get(s[l])>0):
                        cnt-=1
                    l+=1
            r=r+1

        if(sIndex == -1):
             return ''
        else:
            return s[sIndex:sIndex+minLength]


        