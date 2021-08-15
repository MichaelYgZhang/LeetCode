package search;

import org.junit.Test;

import static com.search.BinarySearch.binarySearch;

public class BinarySearchTest {

    int[] list = {1, 2, 3, 4};

    @Test
    public void binarySearchTest() {
        assert 1 == binarySearch(2, list);
    }

    @Test
    public void binarySearchTestIsNull() {
        assert null == binarySearch(5, list);
    }
}
