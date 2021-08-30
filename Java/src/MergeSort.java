import java.util.Arrays;

/**
 * A class that implements the merge sorting algorithm.
 *
 * This algorithm divides an array recursively into 2 arrays evenly,
 * until each array contains only 1 element. These chunks of array will
 * be merged with a methode called {@code merge()}.
 *
 * The implementation of this algorithm is based on the article from
 * GeeksforGeeks
 *
 * @author clarissong
 * @since 29.08.2021 19:30
 */
public class MergeSort {

    /**
     * Sorts the elements in the given array (ascending).
     *
     * @param array
     *            an array contains element to be sorted
     *
     * @param leftIndex
     *            an index for the left part of the array
     *
     * @param rightIndex
     *            an index for the right part of the array
     *
     * @return an array with sorted elements
     */
    public int[] mergeAndSort(int[] array, int leftIndex, int rightIndex) {

        if(rightIndex > leftIndex) {

            //find the middle index of the array
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

            //devide the array
            int[] leftPart = mergeAndSort(array, leftIndex, middleIndex);
            int[] rightPart = mergeAndSort(array, middleIndex + 1, rightIndex);

            //merge the array again, but this time sorted
            array = merge(leftPart, rightPart);
        }

        //break statement : leftIndex == rightIndex --> only 1 element in an array
        else {
            return new int[]{array[leftIndex]};
        }

        return array;
    }

    /**
     * Merges the arrays that are divided into chunks
     *
     * @param leftPart
     *            the first half of the given array in the method {@code mergeAndSort()}
     *
     * @param rightPart
     *            the other half of the given array in the method {@code mergeAndSort()}
     *
     * @return the merged array
     */
    public int[] merge(int[] leftPart, int[] rightPart) {

        int[] merged = new int[leftPart.length + rightPart.length];

        //vars
        int indexLeftPart = 0;
        int indexRightPart = 0;
        int indexMergedArray = 0;

        while (indexMergedArray < merged.length) {

            //the leftPart array is always sorted
            if(indexRightPart == rightPart.length) {
                for(int i = indexLeftPart; i < leftPart.length; i++) {
                    merged[indexMergedArray] = leftPart[i];
                    indexMergedArray++;
                }
            }

            //the rightPart array is always sorted
            else if(indexLeftPart == leftPart.length) {
                for(int j = indexRightPart; j < rightPart.length; j++) {
                    merged[indexMergedArray] = rightPart[j];
                    indexMergedArray++;
                }
            }

            //comparison
            else {
                if (leftPart[indexLeftPart] < rightPart[indexRightPart]) {
                    merged[indexMergedArray] = leftPart[indexLeftPart];
                    indexLeftPart++;
                } else {
                    merged[indexMergedArray] = rightPart[indexRightPart];
                    indexRightPart++;
                }
            }

            indexMergedArray++;
        }

        return merged;
    }

    /**
     * Calls the method {@code mergeAndSort()}. The purpose of this method is that
     * the method call in the main method will be more elegant
     *
     * @param array
     *            an array contains elements to be sorted
     *
     * @return an array with sorted elements
     */
    private int[] mergeSort(int[] array) {
        return mergeAndSort(array, 0, array.length - 1);
    }

    /**
     * Main method. You can use this example for testing.
     */

    public static void main(String[] args) {
        MergeSort test = new MergeSort();
        int[] array = {-1,2,-3,4,-5,6};
        int[] array2 = {-1,2,-3,0,4,-5,6};
        System.out.println(Arrays.toString(test.mergeSort(array)));
        System.out.println(Arrays.toString(test.mergeSort(array2)));
    }
}
