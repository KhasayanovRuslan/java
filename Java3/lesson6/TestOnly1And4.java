package lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestOnly1And4 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 4, 1, 4, 1, 4, 1, 1, 1, 4, 4}, true},
                {new int[]{1, 4, 1, 4, 1, 4, 1, 1, 1, 4, 3}, false},
                {new int[]{1, 1, 1, 1, 1, 1, 1, 1}, false},
                {new int[]{4, 4, 4, 4, 4, 4, 4, 4}, false}
        });
    }
    private int[] in;
    private boolean out;

    public TestOnly1And4(int[] in, boolean out) {
        this.in = in;
        this.out = out;
    }

    private CheckArray cArr;

    @Before
    public void startTest() {
        cArr = new CheckArray();
    }

    @Test
    public void testOnly1And4() {
        Assert.assertEquals(cArr.Only1And4(in), out);
    }
}