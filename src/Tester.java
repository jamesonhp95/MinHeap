/*
Author: Jameson Price
 */
import java.util.ArrayList;

public class Tester {
    public static void main(String args[])
    {
        String[] A = {"zoo", "big", "bike", "good", "apple", "moon", "mud"};
        MinHeap myHeap = new MinHeap(A, 7, 7);

        ArrayList<String> sorted = new ArrayList<>();
        while(myHeap.heapsize()>0)
        {
            String cur = (String)myHeap.removemin();
            sorted.add(cur);
        }
        System.out.println(sorted);
        System.out.println();
        System.out.println("Time complexity analysis: ");
        System.out.println("Since we know that removing an element from a heap is O(logn), so long as we know the index of the object to be removed, " +
                        "it follows that since we know the minimum value in our MinHeap is the root, we know the index that we are trying to remove. Thus " +
                        "we can essentially replace the root object with the rightmost object on the bottom level of the tree, then we apply siftdown operation on " +
                        "the new root, but our number of elements becomes n-1. From here we now know that the time complexity for removing an object is O(logn), however " +
                        "we are doing this operation for each object in our MinHeap, so we have to consider that we are doing that remove operation n times where n is the number " +
                        "of objects in the heap. So we obtain a final time complexity of O(nlogn) for this sorting algorithm."
        );
    }
}
