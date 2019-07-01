package Sorting_Algorithms;
import java.util.Scanner;

public class Selection_Sort {
    int[] Sorted_array(int elements[],int size){
        for (int i=0;i<size;i++){
            for (int j=i+1;j<size;j++){
                if(elements[i]>elements[j]){
                    int temp=elements[i];
                    elements[i]=elements[j];
                    elements[j]=temp;
                }
            }
        }
        return elements;
    }


    public static void main(String[] args) {
        Selection_Sort object=new Selection_Sort();
        Scanner scan=new Scanner(System.in);
        try{
            System.out.println("enter the number of elements");
            int n=scan.nextInt();
            System.out.println("enter the "+n+" elements to be sorted");
            int elements[]=new int[n];
            for(int i=0;i<n;i++){
                elements[i]=scan.nextInt();
            }
            int result[]=object.Sorted_array(elements,n);
            System.out.println("sorted array is:-");
            for(int i=0;i<n;i++){
                System.out.print(result[i]+" ");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
