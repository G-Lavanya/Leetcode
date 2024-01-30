import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class StackUpSymbols {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for(char c : s.toCharArray()){

                if(c == '('|| c =='{' || c == '['){

                    stack.push(c);
                }
                else {

                    if(!stack.isEmpty() &&
                            (c == ')' && stack.peek() == '(' ||
                                    c == '}' && stack.peek() == '{' ||
                                    c == ']' && stack.peek() =='[')){
                        stack.pop();
                    } else{
                        System.out.println("false");
                        return false ;
                    }
                }
            }
            System.out.println("True");
            return stack.isEmpty();

        }

    public static void main(String[] args) {
        StackUpSymbols ss = new StackUpSymbols();
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String i =buffReader.readLine();
            ss.isValid(i);
        } catch (IOException e) {
            e.printStackTrace();
        }

       /* Scanner s = new Scanner(System.in);
        ss.isValid(s.next());*/

    }
    }

