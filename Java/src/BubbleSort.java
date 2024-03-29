import java.util.Arrays;

/**
 * A class that implements the bubble sorting algorithm.
 *
 * Bubble sorting is known as the simplest sorting algorithm. 2 neighbour elements
 * that are placed in wrong order will be swapped. This will be done repeatedly until
 * all elements are placed in the right order. At the end of the sorting, the algorithm
 * will iterate one more time to make sure that every element is placed in its order.
 * (Source : GeeksforGeeks)
 *
 * @author clarissong
 * @since 29.08.2021 19:20
 */
public class BubbleSort {

    /**
     * Sorts the elements in the given array (ascending).
     *
     * @param array
     *            an array contains element to be sorted
     *
     * @return an array with sorted elements
     */
    public int[] sortAscending(int[] array) {

        //vars
        int tmp;
        boolean sorted = false;
        boolean swapped = true;

        //as long as it's not sorted
        while(!sorted) {

            if(!swapped) {
                sorted = true;
            }

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {

                    //elements are not sorted for sure
                    sorted = false;

                    //swap the elements
                    tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                }
                else {
                    swapped = false;
                }
            }
        }

        //return the sorted elements
        return array;
    }

    /**
     * Sorts the elements in the given array (descending).
     *
     * @param array
     *            an array contains element to be sorted
     *
     * @return an array with sorted elements
     */
    public int[] sortDescending(int[] array) {

        //array for the inverted element
        int[] inverted = new int[array.length];

        //sort the element (ascending)
        array = sortAscending(array);

        //invert the elements
        int index = array.length - 1;
        for(int element : array) {
            inverted[index] = element;
            index--;
        }

        //return the sorted elements
        return inverted;
    }

    /**
     * Main method. You can use this example for testing.
     */
    public static void main(String[] args) {
        BubbleSort test = new BubbleSort();

        //Array that will be sorted
        int[] array = {5,6,5,-8,1}; //asc
        int[] array2 = {-1,2,-3,4,-5,6}; //desc

        //ascending
        System.out.println(Arrays.toString(test.sortAscending(array)));

        //descending
        System.out.println(Arrays.toString(test.sortDescending(array2)));
    }
}
