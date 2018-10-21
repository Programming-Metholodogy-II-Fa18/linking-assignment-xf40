public class BST {
    private class Node{
        int key;
        int value;
        Node left;
        Node right;

        public Node() {
            left = null;
            right = null;
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

        public Node(int key, int value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    private Node head;
    private int size;

    public BST() {
        this.head = null;
        size = 0;
    }
    public void put(int key)
    {
        put(head, key, key);
    }

    private void put(Node node, int key, int value)
    {
        if(node == null)
        {
            node  = new Node(key, value);
        }else
        {
            if(key > node.key)
            {
                put(node.right, key, value);
                size++;
            }
            else if(key < node.key)
            {
                put(node.left, key, value);
                size++;
            }
            else
                node.value = value;
        }
    }

    public int search(int key)
    {
        int cnt = 0;
        Node temp = head;
        while(temp != null)
        {
            if(key > temp.key)
                temp = temp.right;
            else if(key < temp.key)
                temp = temp.left;
            else
                return temp.value;
            cnt++;
        }
        System.out.println("total number of comparisons" + cnt);
        System.out.println("Value not found!");
        return 0;
    }

    public int returnSize()
    {
        return this.size;
    }

    int[] sortedTree() {
        int[] a = new int[returnSize()];
        if(head == null)
            return null;
        inOrder(head, a, 0);
        return a;
    }

    int inOrder(Node node, int[] a, int i)
    {
        if(node.left != null)
        {
            i = inOrder(node.left, a, i);
        }
        a[i++] = node.key;
        if(node.right != null)
        {
            i = inOrder(node.right, a, i);
        }
        return i;
    }

    public BST balanceTreeOne()
    {
        BST bst = new BST();
        int[] v = sortedTree();
        buildBST(bst, v, 0, v.length-1);
        return bst;
    }

    public void buildBST(BST bst, int[] v, int begin, int end) {
        if(begin > end)
            return;
        if(begin == end)
            bst.put(v[begin]);
        else if(begin + 1 == end)
        {
            bst.put(v[begin]);
            bst.put(v[end]);
        }else
        {
            int middle = (begin+end)/2;
            bst.put(v[middle]);
            buildBST(bst, v, begin, middle - 1);
            buildBST(bst, v, middle+1, end);
        }
    }

    public Node rotateRight(Node h) {
        Node x = h.left;
        Node x_right = x.right;
        x.right = h;
        h.left = x_right;
        return x;
    }

    public Node rotateLeft(Node h) {
        Node x = h.right;
        Node x_left = x.left;
        x.left = h;
        h.right = x_left;
        return x;
    }

    public void transformToList() {
        Node temp = head;
        while(temp.left != null)
        {
            temp = rotateRight(temp);
        }
        while(temp != null)
        {
            while(temp.left != null)
            {
                temp = rotateRight(temp);
            }
            temp = temp.right;
        }
    }

    public void balanceTreeTwo()
    {
        transformToList();
        int N = size;
        int M = N + 1 - (int)Math.pow(2, Math.floor(Math.log(2)/Math.log(N)));
        int cnt = 1;
        Node temp = head;
        while(cnt < M*2)
        {
            if(cnt%2 == 1)
            {
                rotateLeft(temp);
                temp = temp.right;
                cnt++;
            }
        }
        int K = (int)Math.floor(Math.log(2)/Math.log(N)) - 1;
        for(int i = 0; i < K; i++)
        {
            rotateLeft(head);
        }
    }


}
