//SEARCHING AN ELEMENT IN SORTED CIRCULARLY ROTATED ARRAY
//USING BINARY SEARCH IN BIG O(log n) COMPLEXITY

package BinarySearch.BinarySearch_Through_Iteration;
import java.util.Scanner;

public class BS_5_Rotation {

    int BinarySearch(int elements[],int search_element,int array_size){
        int temp=-1;
        int first=0,last=array_size-1;




        return temp;
    }

    public static void main(String[] args) {
        BS_5_Rotation object =new BS_5_Rotation();
        Scanner scan=new Scanner(System.in);
        try{
            System.out.println("enter the number of elements");
            int n=scan.nextInt();
            System.out.println("enter the sorted array already present in rotated form");
            int elements[]=new int[n];
            for(int i=0;i<n;i++){
                elements[i]=scan.nextInt(); //NO REPEATED ELEMENT
            }
            System.out.println("enter the element to be searched");
            int search_element=scan.nextInt();
            int temp=object.BinarySearch(elements,search_element,n);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
