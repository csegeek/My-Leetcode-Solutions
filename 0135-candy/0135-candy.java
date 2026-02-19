class Solution {
    public int candy(int[] ratings) {
        int sum=1,i=1;
        while(i<ratings.length){
            while(i<ratings.length && ratings[i-1]==ratings[i]){
                sum++;
                i++;
                continue;
            }
            int peak=1;
            while(i<ratings.length && ratings[i-1]<ratings[i]){
                peak++;
                sum+=peak;
                i++;
            }
            int down=1;
            while(i<ratings.length && ratings[i-1]>ratings[i]){
                sum+=down;
                down++;
                i++;
            }
            if(down>peak){
                sum=sum+down-peak;
            }
        }
        return sum;
    }
}