import java.util.Stack;
public class TowerOfHanoi {
    public static void tower(int numOfDisks, Stack src, Stack aux, Stack dest) {
        if(numOfDisks == 1) {
            dest.push(src.pop());
        } else {
            tower(numOfDisks - 1, src, dest, aux);
            dest.push(src.pop());
            tower(numOfDisks - 1, aux, src, dest);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> src = new Stack<Integer>();
        int length = 4;
        for(int i = length; i > 0; i--) {
            src.push(i);
        }
        Stack<Integer> aux = new Stack<Integer>();
        Stack<Integer> dest = new Stack<Integer>();
        System.out.println("Before starting game...");
        System.out.println("source stack: " + src);
        System.out.println("auxillary stack: " + aux);
        System.out.println("destination stack: " + dest);
        tower(length, src, aux, dest);
        System.out.println("After playing game...");
        System.out.println("source stack: " + src);
        System.out.println("auxillary stack: " + aux);
        System.out.println("destination stack: " + dest);            
    }
}