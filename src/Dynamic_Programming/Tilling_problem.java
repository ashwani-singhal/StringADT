package Dynamic_Programming;
import java.util.Scanner;

/* You r given n*2 grid and n tiles of 2*1 ,in how many ways we can form the grid?? */

public class Tilling_problem {

    // recursive calls are too many in this.
    /*static int tile(int n)
    {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        return tile(n-1) + tile(n-2);
    }*/

    // recursion with memorisation
    static int ar[] = new int[10000];
    static int tile(int n)
    {
        if (n == 1 || n == 2)
            return n;
        if (ar[n] != 0)
            return ar[n];
        ar[n] = tile(n-1) + tile(n-2);
        return ar[n];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(tile(n));

    }
}
