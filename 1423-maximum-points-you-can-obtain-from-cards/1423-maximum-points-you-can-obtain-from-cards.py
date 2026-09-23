class Solution:
    def maxScore(self, cardPoints: list[int], k: int) -> int:
        n = len(cardPoints)
        maxScore = 0
        leftSum=0
        for i in range(0,k):
            leftSum +=cardPoints[i]
        maxScore=leftSum
        rightIndex=n-1
        rightSum=0
        
        for i in range(k-1,-1,-1):
            leftSum=leftSum-cardPoints[i]
            rightSum=rightSum+cardPoints[rightIndex]
            # print(f'left-->{leftSum}')
            # print(f'right-->{rightSum}')
            maxScore=max(maxScore,leftSum+rightSum)
            rightIndex-=1

        return maxScore