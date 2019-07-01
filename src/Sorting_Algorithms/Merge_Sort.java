package Sorting_Algorithms;

import java.util.Scanner;

public class Merge_Sort {

    void Sorted_Array(int elements[]){
        if(elements.length<2){
            return ;
        }
        else {
            int size=elements.length;
            int mid=size/2,left=mid,right=size-mid;
            int leftArray[]=new int[left];
            int rightArray[]=new int[right];
            for (int i=0;i<mid;i++){
                leftArray[i]=elements[i];
            }
            for (int i=mid;i<size;i++){
                rightArray[i-mid]=elements[i];
            }
            Sorted_Array(leftArray);
            Sorted_Array(rightArray);
            Merge_Arrays(leftArray,rightArray,elements);
        }
    }


    void Merge_Arrays(int[] leftArray,int[] rightArray,int[] elements){
        int leftArray_size=leftArray.length;  //size of left array
        int rightArray_size=rightArray.length;   //size of right array
        int i=0,j=0,k=0;
        while (i<leftArray_size && j<rightArray_size){
            if(leftArray[i]<=rightArray[j]){
                elements[k]=leftArray[i];
                i++;
            }
            else {
                elements[k]=rightArray[j];
                j++;
            }
            k++;
        }
        while (i<leftArray_size){
            elements[k]=leftArray[i];
            i++;
            k++;
        }
        while (j<rightArray_size){
            elements[k]=rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Merge_Sort object=new Merge_Sort();
        Scanner scan=new Scanner(System.in);
        try {
            System.out.println("enter the number of elements");
            int n=scan.nextInt();
            System.out.println("enter the "+n+" elements to be sorted");
            int elements[]=new int[n];
            for(int i=0;i<n;i++){
                elements[i]=scan.nextInt();
            }
            object.Sorted_Array(elements);
            System.out.println("sorted array is:-");
            for(int i=0;i<n;i++){
                System.out.print(elements[i]+" ");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
