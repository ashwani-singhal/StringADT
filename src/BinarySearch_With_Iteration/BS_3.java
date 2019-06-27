// TO COUNT THE OCCURRENCE OF A NUMBER IN SORTED ARRAY USING BINARY SEARCH
// IN BIG O(log n) TIME COMPLEXITY

package BinarySearch_With_Iteration;
import java.util.Scanner;

public class BS_3 {

    int BinarySearch_Counter(int elements[],int count_element,int choice){
        int low=0,high=elements.length-1;
        int temp=-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(count_element==elements[mid]){
                temp=mid;
                if (choice==1){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else if (count_element<elements[mid]){
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        BS_3 object=new BS_3();
        Scanner scan=new Scanner(System.in);
        try{
            System.out.println("enter the number of elements");
            int n=scan.nextInt();
            System.out.println("enter the "+n+" elements in sorted form");
            int elements[]=new int[n];
            for(int i=0;i<n;i++){
                elements[i]=scan.nextInt();
            }
            System.out.println("enter the number of which count we have to find");
            int count_element=scan.nextInt();

            int count1=object.BinarySearch_Counter(elements,count_element,1);
            if(count1==-1){
                System.out.println("Sorry!,element is not present in the numbers we have");
            }
            else{
                int count2= object.BinarySearch_Counter(elements,count_element,2);
                System.out.println("count of element present in the given numbers is: "+(count2-count1+1));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

