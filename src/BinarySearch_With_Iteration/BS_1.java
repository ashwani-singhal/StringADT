//BINARY SEARCH WITH NON-REPEATED ELEMENTS

package BinarySearch_With_Iteration;
import java.util.Scanner;

public class BS_1 {

    int BinarySearch(int elements[],int search_element){
        int answer=-1,first=0,last=elements.length-1;
        while (first<=last){
            int mid=first+((last-first)/2);
            if(elements[mid]==search_element){
                answer=mid;
                break;
            }
            else  if(search_element<elements[mid]){
                last=mid-1;
            }
            else if(search_element>elements[mid]) {
                first=mid+1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        BS_1 object=new BS_1();
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("enter the number of elements");
            int n = scan.nextInt();
            int elements[] = new int[n];
            System.out.println("enter the " + n + " elements in sorted form");
            for (int i = 0; i < n; i++) {
                elements[i] = scan.nextInt();
            }
            System.out.println("enter the element you want to search");
            int search_element = scan.nextInt();
            int temp = object.BinarySearch(elements, search_element);
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

