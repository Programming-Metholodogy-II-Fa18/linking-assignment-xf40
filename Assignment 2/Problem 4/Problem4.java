import java.util.Arrays;

public class Sorting4 {
    public static void Problem4A(int[] a, int arraySize)
    {
        Arrays.sort(a);
        if(arraySize%2 == 0)
        {
            int[] temp1 = Arrays.copyOf(a,arraySize/2);
            int[] temp2 = Arrays.copyOfRange(a, arraySize/2 , arraySize );
            for(int i = 0; i <  arraySize/2; i++)
            {
                a[2*i] = temp2[i];
                a[2*i + 1] = temp1[i];
            }

        }else
        {
            int[] temp1 = Arrays.copyOf(a, arraySize/2);
            int[] temp2 = Arrays.copyOfRange(a, arraySize/2, arraySize );
            for(int i = 0; i <  arraySize/2; i++)
            {
                a[2*i] = temp2[i];
                a[2*i + 1] = temp1[i];
            }

        }
    }

}
