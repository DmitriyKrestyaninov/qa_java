import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import com.example.Feline;
import com.example.Lion;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    private final String sexLionPassed;
    private final boolean expectedHasMane;
    @Mock
    private static Feline feline;
    @Mock
    private static Lion lion;

    public LionTest(String sexLionPassed, boolean expectedHasMane) {
        this.expectedHasMane = expectedHasMane;
        this.sexLionPassed = sexLionPassed;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters(name = "{index}:returnHasManeToGenderLion{0}={1}")
    public static Object[][] getDataForLionTest() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManeCheckReturnSexTest() throws Exception {
        Lion lion = new Lion(sexLionPassed, feline);
        Assert.assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    public void lionConstructorThrowsExceptionWhenInitialisedWithWrongSexTest() throws Exception {
        Assert.assertThrows("Используйте допустимые значения пола животного - самец или самка", Exception.class, () -> new Lion("Олень", feline));
    }

    @Test
    public void getKittensCheckCallGetKittensTest() throws Exception {
        Lion lion = new Lion(sexLionPassed, feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void getFoodsPredatorTest() throws Exception {
        List<String> testStrings = List.of("string1", "string2", "string3");
        Mockito.doReturn(testStrings).when(feline).getFood(Mockito.anyString());
        Assert.assertEquals(testStrings, new Lion(sexLionPassed, feline).getFood());
    }
}
