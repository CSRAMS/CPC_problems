import java.util.Scanner;
import java.util.*;

public class F {

    static HashMap<Character, Character> open;
    static HashMap<Character, Character> close;
    static char [] openSymbols = {'(','[','{','<'};
    static char [] closeSymbols = {')',']','}','>'};
    static int count = 0;
    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if(input.length()==0) {
            //empty is valid
            System.out.println(0);
        }
        else {

            open = new HashMap<Character,Character>();
            close = new HashMap<Character, Character>();
            for (int i = 0; i<openSymbols.length; i++){
                open.put(openSymbols[i],closeSymbols[i]);
                close.put(closeSymbols[i],openSymbols[i]);
            }
            ArrayList<Character> stack = new ArrayList<Character>();
            placeBrackets(input,stack,0,input.charAt(0));
            System.out.println(count);
        }
    }
    

    private static void placeBrackets(String input, ArrayList<Character> stack, int ind, char next) {
        
        while (ind<input.length()) {

            // printStack(stack, next);
            if (next=='?') {
                if (input.length()-ind-1>stack.size()) {
                    for(int i = 0; i < openSymbols.length; i++) {
                        //try open brackets
                        placeBrackets(input,new ArrayList<Character>(stack),ind,openSymbols[i]);
                    }
                }
                if (stack.size()!=0) {
                    //place close brackets
                    placeBrackets(input,new ArrayList<Character>(stack),ind,open.get(stack.get(stack.size()-1)));     
                }
                return;
            }
            else {
                //prune: if spots left in string is less than size of stack, all open parens cannot possibly be closed
                if (open.containsKey(next)&&input.length()-ind-1>stack.size()) {
                    stack.add(next);
                }
                else if (stack.size()>0&&next==open.get(stack.get(stack.size()-1))) {
                    stack.remove(stack.size()-1);

                }
                else {
                    return;
                }
            }
            ind++;
            if (ind<input.length()) {
                next = input.charAt(ind);
            }
        }
        count++;
    }

    //for debugging
    public static void printStack(ArrayList<Character> stack, char next) {
        for (Character c: stack){
            System.out.print(c+" ");
        }
        System.out.print(next);
        System.out.println();
    }

}
