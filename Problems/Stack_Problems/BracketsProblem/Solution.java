import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("[{}]");
        list.add("(()())");
        list.add("{]");
        list.add("[()]))()");
        list.add("[]{}({})");
        for(String item: list) {
            System.out.println(item + " result: " + linkedListStack(item));
        }
    }

    public static char getReversedBracket(char bracket) {
        switch(bracket) {
//            case '(': return ')';
//            case '{': return '}';
//            case '[': return ']';
            case ')': return '(';
            case '}': return '{';
            case ']': return '[';
            default: return '\u0000';
        }
    }

    public static boolean linkedListStack(String bracketString) {
        LinkedList<Character> list = new LinkedList<Character>();
        char[] brackets = bracketString.toCharArray();
        for(char bracket: brackets) {
            char reverseBracket = getReversedBracket(bracket);
            //if(!list.isEmpty()) System.out.println("list.getLast: " + list.getLast());
            //System.out.println("bracket: " + bracket);
            //System.out.println("reverseBracket: " + reverseBracket);
            if(bracket == '(' || bracket == '[' || bracket == '{') {
                list.add(bracket);
            } else if(list.isEmpty() || list.removeLast() != reverseBracket) {
                return false;
            }
            //System.out.println("*********************");
        }
        return list.isEmpty();
    }
}