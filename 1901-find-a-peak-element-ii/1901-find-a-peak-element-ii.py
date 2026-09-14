class Solution:
    def findMaxRow(self,mat:List[List[int]],n:int,m:int,col:int) -> List[int]:
        maxElement=-1
        rowIndex=0
        for i in range(0,n):
            if(mat[i][col] > maxElement):
                maxElement=mat[i][col]
                rowIndex=i
        return rowIndex

    def findPeakGrid(self, mat: List[List[int]]) -> List[int]:
        n=len(mat)
        m=len(mat[0])
        low,high=0 ,m-1
        while low <= high :
            mid=low+(high-low)//2
            maxRow=self.findMaxRow(mat,n,m,mid)
            left = mat[maxRow][mid-1] if mid - 1 >= 0 else -1
            right= mat[maxRow][mid+1] if mid+1<m else -1
            if(mat[maxRow][mid]>left and mat[maxRow][mid]>right):
                return [maxRow,mid]
            elif (mat[maxRow][mid]<left):
                high=mid-1
            else :
                low=mid+1
        return [-1,-1]

        