import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import com.example.Feline;

import java.util.List;

@RunWith(Parameterized.class)
public class FelineTest {
    private final int kittensCountPassed;
    private final int kittensCountExpected;

    public FelineTest(int kittensCountPassed, int kittensCountExpected) {
        this.kittensCountPassed = kittensCountPassed;
        this.kittensCountExpected = kittensCountExpected;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Spy
    private static Feline feline;

    @Parameterized.Parameters(name = "{index}:returnCountKitten{0}={1}")
    public static Object[][] getDataForKittenCount() {
        return new Object[][]{
                {1, 1},
                {3, 3},
                {10, 10},
                {-5, -5}
        };
    }

    @Test
    public void getKittensTest() {
        Assert.assertEquals(kittensCountExpected, feline.getKittens(kittensCountPassed));
    }

    @Test
    public void getFamilyTest() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensCheckCallGetKittensTest() {
        feline.getKittens();
        Mockito.verify(feline).getKittens(1);
    }

    @Test
    public void eatMeatReturnListFoodsPredatorTest() throws Exception {
        List<String> testStrings = List.of("string1", "string2", "string3");
        Mockito.doReturn(testStrings).when(feline).getFood(Mockito.anyString());
        Assert.assertEquals(testStrings, feline.eatMeat());
    }
}





