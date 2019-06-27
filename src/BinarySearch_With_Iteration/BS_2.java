//BINARY SEARCH FOR REPEATED AS WELL AS NON-REPEATED ELEMENTS
//RETURN FIRST REPEATED ELEMENT IF BOOLEAN==TRUE  ELSE RETURN LAST ELEMENT

package BinarySearch_With_Iteration;
import java.util.Scanner;

public class BS_2 {

    int BinarySearch(int elements[],int search_element,int choice){
        int low=0,high=elements.length-1;
        int temp=-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(search_element==elements[mid]){
                temp=mid;
                if (choice==1){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else if (search_element<elements[mid]){
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        BS_2 object=new BS_2();
        Scanner scan=new Scanner(System.in);
        try{
            System.out.println("enter the number of elements");
            int n=scan.nextInt();
            System.out.println("enter the "+n+" elements having repeated or non-repeated elements");
            int elements[]=new int[n];
            for (int i=0;i<n;i++){
                elements[i]=scan.nextInt();
            }
            System.out.println("enter the element to be find");
            int search_element=scan.nextInt();
            System.out.println("enter 1 for find the first occurrence of repeated element or enter other digit  for finding the last occurrence of repeated element");
            int choice=scan.nextInt();
            int temp = object.BinarySearch(elements, search_element,choice);
            if (temp == -1) {
                System.out.println("element is not found");
            } else {
                System.out.println("element is found at position " + (temp+1));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
