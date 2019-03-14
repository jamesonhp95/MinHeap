/*
Author: Jameson Price
This is a Java implementation of a MinHeap.
 */
public class MinHeap<E extends Comparable<? super E>> {

    private E[] mHeap;
    private int mSize;
    private int n;

    public MinHeap(E[] h, int num, int max)
    { mHeap = h;  n = num;  mSize = max; buildheap(); }

    /**
     * @return current size of the heap
     */
    public int heapsize() { return n; }

    /**
     * Checks if the provided position is a leaf node.
     * @param pos position in heap.
     * @return true if the position is a leaf node, false otherwise.
     */
    public boolean isLeaf(int pos)
    { return (pos >= n/2) && (pos < n); }

    /**
     * @param pos the position in the heap.
     * @return the left child of the provided position.
     */
    public int leftchild(int pos) {
        assert pos < n/2 : "Position has no left child";
        return 2*pos + 1;
    }

    /**
     * @param pos the position in the heap.
     * @return the right child of the provided position.
     */
    public int rightchild(int pos) {
        assert pos < (n - 1) / 2 : "Position has no right child";
        return 2 * pos + 2;
    }

    /**
     * @param pos the position in the heap.
     * @return the parent of the provided position.
     */
    public int parent(int pos) {
        assert pos > 0 : "Position has no parent";
        return (pos-1)/2;
    }

    /**
     * Utilizes siftdown method to Heapify contents of the MinHeap.
     */
    public void buildheap()
    {
        for (int i=n/2-1; i>=0; i--)
        {
            siftdown(i);
        }
    }

    /**
     * This method puts the passed in positions element in the right place within the heap.
     * @param pos of the heap.
     */
    private void siftdown(int pos) {
        assert (pos >= 0) && (pos < n) : "Illegal heap position";
        while (!isLeaf(pos)) {
            int j = leftchild(pos);
            if ((j<(n-1)) && (mHeap[j].compareTo(mHeap[j+1]) > 0))
                j++; // j is now index of child with greater value
            if (mHeap[pos].compareTo(mHeap[j]) <= 0)
                return;
            swap(mHeap, pos, j);
            pos = j;  // Move down
        }
    }

    /**
     * This method removes the minimum element from the heap, then performs siftdown to keep
     * the integrity of the MinHeap.
     * @return the minimum object within the MinHeap
     */
    public E removemin() {
        assert n > 0 : "Removing from empty heap";
        swap(mHeap, 0, --n);
        if (n != 0)
            siftdown(0);
        return mHeap[n];
    }

    /** Swaps two Objects in an array
     @param A The array
     @param p1 Index of one Object in A
     @param p2 Index of another Object A
     */
    public static <E> void swap(E[] A, int p1, int p2) {
        E temp = A[p1];
        A[p1] = A[p2];
        A[p2] = temp;
    }
}
