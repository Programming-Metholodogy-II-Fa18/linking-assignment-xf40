
public class Sorting1 {
    public static void Problem1Sort(int[] a, int arraySize)
    {

        int digit = 0;  //the max bit
        for(int i = 0; i < arraySize; i++)
        {
            while(a[i] > Math.pow(10, digit))
            {
                digit++;
            }
        }

        int flag = 1;  //current bit
        for(int j = 1; j <= digit; j++)
        {
            int[] bucket = new int[10];
            for(int i = 0; i < arraySize; i++)
            {
                bucket[(a[i]/flag)%10]++;
            }

            int[] beginIndex =  new int[10];  //the begin index for the element in bucket
            for(int i = 1; i < 10; i++)
            {
                beginIndex[i] = beginIndex[i-1] + bucket[i -1];
            }


            int[] tmp = new int[arraySize];
            for(int i = 0; i < arraySize; i++)
            {
                int index = (a[i]/flag)%10;
                tmp[beginIndex[index]++] = a[i];
            }

            for(int i = 0; i < arraySize; i++)
            {
                a[i] = tmp[i];
            }
            flag = flag*10;
        }
    }


}
