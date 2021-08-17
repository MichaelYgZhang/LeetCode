package sort;

import com.sort.SelectSort;
import org.junit.Test;

public class SelectSortTest {


    private int[] array = {1, 3, 2, 6, 5};

    @Test
    public void selectSortTest() {
        SelectSort.selectSort(array);
        assert 2 == array[1];
    }
}
