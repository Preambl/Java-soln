import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//to input an array of 6 numbers and reverse the array, find sum and perform bubble sort if sum is even and quick sort if sum is odd
public class ArrayOp 
{
    public void quicksort(int arr[],int low,int high)
    {
        if(low<high)
        {
            int p=partition(arr,low,high);
            quicksort(arr,low,p-1);
            quicksort(arr,p+1,high);
        }
    }
    int partition(int arr[],int low,int high)
    {
        int pivot=arr[high];
        int i=low-1;
        int temp=0;
        for(int j=low;j<high;j++)
        {
            if(arr[j]<pivot)
            {
                i++;
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return(i+1);
    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));       
        int[] numbers = new int[6];   
        ArrayOp obj=new ArrayOp();  
        System.out.println("Enter 6 numbers:");
        for (int i = 0; i < numbers.length; i++) 
        {
            numbers[i] = Integer.parseInt(reader.readLine());
        }           
        System.out.println("Numbers entered:");
        for (int number : numbers) 
        {
            System.out.println(number);
        }
        int temp=0;
        for (int i=0;i<(numbers.length/2);i++)
        {
            temp=numbers[i];
            numbers[i]=numbers[numbers.length-i-1];
            numbers[numbers.length-i-1]=temp;
        }
        System.out.println("Reverse is:\n");
        for (int number : numbers) 
        {
            System.out.println(number);
        }
        int c=0,s=0,index=0,j=0;
        for (int i=0;i<numbers.length;i++)
        {
            if(i%2==0)
            {
                s=s+numbers[i];
            }
        }
        System.out.println("Sum is:"+s);
        if(s%2==0)
        c=0;
        else
        c=1;
        switch(c)
        {
            case 0: for(int i=0;i<numbers.length-1;i++)
                    {
                        for(j=0;j<numbers.length-i-1;j++)
                        {
                            if(numbers[j]>numbers[j+1])
                            {
                                temp=numbers[j];
                                numbers[j]=numbers[j+1];
                                numbers[j+1]=temp;
                            }
                        }
                    }
                    System.out.println("Bubble sort:\n");
                    for (int number : numbers) 
                    {
                        System.out.println(number);
                    }
                    break;
            case 1: obj.quicksort(numbers, 0, numbers.length-1);
                    System.out.println("Quick sort:\n");
                    for (int number : numbers) 
                    {
                        System.out.println(number);
                    }
                    break;
            default: System.out.println("Wrong");
        }
    }
}
