//SEARCHING AN ELEMENT IN SORTED CIRCULARLY ROTATED ARRAY
//USING BINARY SEARCH IN BIG O(log n) COMPLEXITY

package BinarySearch_With_Iteration;
import java.util.Scanner;

public class BS_5_Rotation {

    int BinarySearch(int elements[],int search_element,int array_size){
        int temp=-1;
        int first=0,last=array_size-1;
        while (first<=last){
            int mid=(first+last)/2;
            if(elements[mid]==search_element){
                temp=mid;
                break;
            }
            else if (elements[mid]<=elements[last]){
                if(search_element>elements[mid] && search_element<=elements[last]){
                    first=mid+1;
                }
                else{
                    last=mid-1;
                }
            }
            else if(elements[first]<=elements[mid]){
                if(search_element>=elements[first] && search_element<elements[mid]){
                    last=mid-1;
                }
                else{
                    first=mid+1;
                }
            }
        }
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
            if (temp == -1) {
                System.out.println("element is not present");
            } else {
                System.out.println("element is present at position "+(temp+1));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

