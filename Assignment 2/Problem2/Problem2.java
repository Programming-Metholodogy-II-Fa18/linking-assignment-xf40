
public class Sorting2 {
    public static void mergeSort(int[] a, int arraySize)
    {
        MergeSort(a, 0, arraySize-1);
    }

    public static void MergeSort(int[] a, int low, int high)
    {
        int mid = (low + high)/2;
        if(low < high)
        {
            MergeSort(a, low, mid);
            MergeSort(a, mid+1, high);
            merge(a, low, mid, high);
        }
    }

    private static void merge(int[] a, int low, int mid, int high)
    {
        int i = low;
        int j = mid+1;

        while(i <= mid && j <= high)
        {
            if(a[i] < a[j])
            {
                i++;
            }
            else
            {
                int temp = a[j];
                for(int l = j - 1; l >= i ; l--)
                {
                   a[l+1] = a[l];
                }
                a[i] = temp;
                i++;
                j++;
                mid++;
            }
        }

    }



}
