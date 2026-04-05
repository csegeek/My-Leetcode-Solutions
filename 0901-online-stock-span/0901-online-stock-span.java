import java.util.*;

class StockSpanner {
    Stack<Integer> st;
    int day;
    Map<Integer,Integer> prices;

    public StockSpanner() {
        st = new Stack<>();
        day = 0;
        prices = new HashMap<>();
    }
    
    public int next(int price) {
        day++;
        prices.put(day, price);

        while (!st.isEmpty() && prices.get(st.peek()) <= price) {
            st.pop();
        }

        int span;
        if (!st.isEmpty()) {
            span = day - st.peek();
        } else {
            span = day;
        }

        st.push(day); 
        return span;
    }
}