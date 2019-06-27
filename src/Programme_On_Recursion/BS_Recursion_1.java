//BINARY SEARCH OF NON-REPEATED ELEMENTS USING RECURSION

package Programme_On_Recursion;
import java.util.Scanner;

public class BS_Recursion_1 {

    int BinarySearch(int elements[],int search_element,int first,int last){
        int mid=(first+last)/2;
        if(first>last){return -1;}
        if (search_element == elements[mid]) {
            return mid;
        } else if (search_element < elements[mid]) {
            return BinarySearch(elements, search_element, first, mid-1);
        } else if (search_element > elements[mid]) {
            return BinarySearch(elements, search_element, mid+1, last);
        }
        return -1;
    }

    public static void main(String[] args) {
        try {
            BS_Recursion_1 object = new BS_Recursion_1();
            Scanner scan = new Scanner(System.in);
            System.out.println("enter the number of elements");
            int n=scan.nextInt();
            System.out.println("enter the "+n+" elements in sorted order");
            int elements[]=new int[n];
            for(int i=0;i<n;i++){
                elements[i]=scan.nextInt();
            }
            System.out.println("enter the element to be searched");
            int search_element=scan.nextInt();
            int temp = object.BinarySearch(elements, search_element ,0,elements.length-1);
            if (temp == -1) {
                System.out.println("element is not found");
            } else {
                System.out.println("element is found at index " + temp);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

