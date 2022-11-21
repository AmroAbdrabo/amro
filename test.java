import java.util.*;

class test {

    public static void main(String[] args){
        int[] input = {-2,1,-2,-2};
        System.out.println(asteroidCollision(input));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        int res_size = 0, i = 0, cnt_neg = 0;
        // skip asteroid moving towards left at the start of the row
        while(i < asteroids.length && asteroids[i] < 0){
            ++i;
            ++cnt_neg;
        }
        res_size = i;
        
        // Loop over all asteroids and push positive ones on stack
        Stack<Integer> st = new Stack<Integer>();
        for ( ; i < asteroids.length; ++i){
            if (asteroids[i] > 0){
                st.push(asteroids[i]);
                res_size += 1;
            }else {
                res_size += 1; // for the negative asteroid
                while (st.size() != 0 && st.peek() < Math.abs(asteroids[i])){
                    // as long as the negative leftward asteroid is bigger, it keeps popping the small positive asteroids 
                    // it encounter
                    if (st.peek() < 0){
                        break; // negative asteroids do not hurt other negative asteroids
                    }
                    st.pop();
                    res_size -= 1; //  for the asteroid getting popped
                }
                if (st.size() != 0 && st.peek()>0){
                    // clearly, a positive asteroid was able to stop the leftward force ONLY if strictly greater
                    if (st.peek() == Math.abs(asteroids[i])){
                        // if equal both get cancelled
                        res_size -= 2;
                        st.pop(); // positive asteroid still gets destroyed :(
                    } else {
                        res_size -= 1; // negative asteroid destroyed
                    }
                } else {
                    st.push(asteroids[i]); // negative asteroid count already taken into account
                }
            }
            System.out.println(st);
        }
        
        int[] res = new int[res_size];
        for (int h = 0; h < cnt_neg; ++h){
            res[h] = asteroids[h];
        }
        int r = 1;
        while (st.size() != 0){
            
            res[res_size - r] = st.pop();
            ++r;
        }
        return res;
    }
}