package lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestAfterLast4 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}},
                {new int[]{1, 3, 6, 9, 4, 3, 6, 4, 8, 9}, new int[]{8, 9}}
        });
    }

    private int[] in;
    private int[] out;

    public TestAfterLast4(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }

    private NewArray nArr;

    @Before
    public void startTest() {
        nArr = new NewArray();
    }

    @Test
    public void testAfterLast4() {
        Assert.assertArrayEquals(out, nArr.afterLast4(in));
    }

    @Test(expected = RuntimeException.class)
    public void testAfterLast4Exc() {
        nArr.afterLast4(new int[]{8, 2, 1, 0, 9, 8, 3, 1, 7});
    }
}

