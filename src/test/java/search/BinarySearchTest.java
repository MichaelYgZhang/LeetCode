package search;

import org.junit.Test;

import static com.search.BinarySearch.binarySearch;

public class BinarySearchTest {

    @Test
    public void binarySearchTest() {
        int[] ary = {1, 2, 3, 4};
        assert null == binarySearch(6, ary);
    }
}
