import com.example.Feline;
import com.example.Cat;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    private Feline feline;
    @Spy
    private Predator predator;
    @Test
    public void getSoundReturnMeowhTest(){
        Cat cat = new Cat(feline);
        Assert.assertEquals("Мяу",cat.getSound());
    }

    @Test
    public void getFoodsPredatorCheckTest() throws Exception{
        Cat cat = new Cat(feline);
        List <String> testStrings = List.of("string1", "string2", "string3");
        Mockito.doReturn(testStrings).when(feline).eatMeat();
        Assert.assertEquals(testStrings, cat.getFood());

    }

}
