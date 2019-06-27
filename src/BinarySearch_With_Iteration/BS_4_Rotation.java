//TO FIND HOW MANY TIMES A SORTED ARRAY WITH NO REPEATED ELEMENT IS ROTATED THROUGH BINARY SEARCH
//IT HAS Big O(log n) TIME COMPLEXITY

package BinarySearch_With_Iteration;
import java.util.Scanner;

public class BS_4_Rotation {

    int NumberOfRotations(int elements[],int array_size){
        int count=-1;
        int first=0,last=array_size-1;
        while (first<=last){
            if(elements[0]<elements[array_size-1]){
                break;
            }
            int mid=(first+last)/2;
            int previous=mid-1,next=mid+1;
            if (elements[previous]>elements[mid] && elements[next]>elements[mid]){
                count=mid;
                break;
            }
            else if (elements[previous]<elements[mid]){
                if(elements[first]>elements[last]){
                    first=mid+1;
                }
                else {
                    last=mid-1;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        BS_4_Rotation object=new BS_4_Rotation();
        Scanner scan=new Scanner(System.in);
        try{
            System.out.println("enter the number of elements");
            int n=scan.nextInt();
            System.out.println("enter the sorted array already present in rotated form");
            int elements[]=new int[n];
            for(int i=0;i<n;i++){
                elements[i]=scan.nextInt(); //NO REPEATED ELEMENT
            }
            int temp=object.NumberOfRotations(elements,n);
            if (temp == -1) {
                System.out.println("array is not rotated");
            } else {
                System.out.println("array is rotated " + temp+" times");
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

