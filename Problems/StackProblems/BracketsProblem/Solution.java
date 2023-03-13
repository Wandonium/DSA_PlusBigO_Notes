package Problems.Stack_Problems.BracketsProblem;

import java.util.*;

// Moving to non-maven folder structure so as to practice solutions to problems
// without use of IntelliJ IDE. Getting used to coding on a whiteboard or online 
// text editor.

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("[{}]");
        list.add("(()())");
        list.add("{]");
        list.add("[()]))()");
        list.add("[]{}({})");
        for(String item: list) {
            //System.out.println(item + " result: " + linkedListStack(item));
            System.out.println(item + " result: " + javaUtilStack(item));
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

    public static boolean javaUtilStack(String bracketString) {
        Stack<Character> stack = new Stack<Character>();
        char[] brackets = bracketString.toCharArray();
        for(char bracket: brackets) {
            char rev = getReversedBracket(bracket);
            if(bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else if(stack.isEmpty() || stack.pop() != rev) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}