import java.util.Arrays;

/**
 * Created by Lucas Wilson on 4/17/2017.
 */
public class main {


    public static void main(String[] args){
        testMergesort();
    }

    public static void testMergesort(){
        int[] arr1= {1,2,3,4,5,6,7,8};
        int[] arr2= {};
        int[] arr3= {8,7,6,5,4,3,2,1};
        int[] passArr={1,2,3,4,5,6,7,8};
//test sorted
        mergesort(arr1);
        if (Arrays.equals(arr1,passArr))
            System.out.println("arr1 mergesort pass");
        else
            System.out.println("arr1 mergesort fail");
//test empty
        mergesort(arr2);
        if (Arrays.equals(arr2,new int []{}))
            System.out.println("arr2 mergesort pass");
        else
            System.out.println("arr2 mergesort fail");
//test unsorted
        mergesort(arr3);
        if (Arrays.equals(arr3,passArr))
            System.out.println("arr3 mergesort pass");
        else
            System.out.println("arr3 mergesort fail");


    }

    public static void mergesort(int[] arr){
        int size=arr.length;
        if(size<2){
            return;
        }
        int[] leftSide= new int[size/2];
        int[] rightSide=new int[size-leftSide.length];
        int middle= size/2;

        for(int i=0;i<middle;i++){
            leftSide[i]=arr[i];
        }

        for(int i=middle;i<size;i++){
            rightSide[i-middle]=arr[i];
        }
        mergesort(leftSide);
        mergesort(rightSide);
        Compare(leftSide,rightSide,arr);

    }

    private static void Compare(int[] leftSide,int []rightSide,int[] change){
        int leftSize=leftSide.length;
        int rightSize=rightSide.length;

        int i=0;
        int j=0;
        int k=0;

        //do comparisons
        while(j<leftSize&&k<rightSize){
            if(leftSide[j]<rightSide[k]){
                change[i++]=leftSide[j++];
            }else{
                change[i++]=rightSide[k++];
            }
        }
        //fill in the rest of the array
        while(j<leftSize){
            change[i++]=leftSide[j++];
        }
        //fill in the rest of the array
        while(k<rightSize){
            change[i++]=rightSide[k++];
        }
    }
}
