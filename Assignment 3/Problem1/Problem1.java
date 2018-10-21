public class DaryHeap {
    private int d;
    private int[] data;
    private  int initSize = 10;
    private int size;
    public DaryHeap(int d)
    {
        this.d = d;
        data = new int[initSize];
        size = 0;
    }

    public void insert(int k)
    {
        if(size == initSize)
        {
            doubleArray();
        }
        data[size++] = k;
        swim(size-1);
    }

    public int delMax()
    {
        int largestValue = data[0];
        swap(0, size-1);
        size--;
        sink(0);
        return largestValue;
    }

    public int[] daryHeapsort()
    {
        int[] sortedArray = new int[size];
        for(int i = 0; i < size; i++)
        {
            sortedArray[i] = delMax();
        }
        return sortedArray;
    }



    private void doubleArray()
    {
        initSize = initSize*2;
        int[] newData = new int[initSize];
        for(int i = 0; i < size; i++)
        {
            newData[i] = data[i];
        }
        data = newData;
    }


    private void swim(int  k)
    {
        while (k > 0 && data[k] > data[parent(k)])
        {
            swap(data[k], data[parent(k)]);
            k = parent(k);
        }
    }

    private int parent(int index)
    {
        return (index - 1)/d;
    }

    private int leftChild(int index)
    {
        return index*d + 1;
    }

    private void swap(int i, int j)
    {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void sink(int k)
    {
        while (leftChild(k) < size )
        {
            int i = findMax(k);
            if(data[i] > data[k])
            {
                swap(k, i);
                k = i;
            }else
            {
                break;
            }
        }
    }

    private int findMax(int k)
    {
        int maxValue = data[k];
        int maxIndex = k;
        for(int i = leftChild(k); i < size && i < leftChild(k)+d; i++)
        {
            if(data[i] > maxValue)
            {
                maxIndex = i;
                maxValue = data[i];
            }
        }
        return maxIndex;
    }




}
