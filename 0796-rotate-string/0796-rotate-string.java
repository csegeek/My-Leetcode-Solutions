class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!= goal.length()) return false;
        String doubleS=s+s;
         if(doubleS.contains(goal)) return true;
         return false;
    }
}