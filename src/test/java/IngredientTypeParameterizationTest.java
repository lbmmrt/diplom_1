import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizationTest {

    private final IngredientType actual;
    private final IngredientType expected;

    public IngredientTypeParameterizationTest(IngredientType actual, IngredientType expected) {
        this.actual = actual;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getEnum() {
        return new Object[][]{
                {SAUCE, SAUCE},
                {FILLING, FILLING},
        };
    }

    @Test
    public void checkEnumIngredientType() {
        assertEquals(IngredientType.valueOf(String.valueOf(actual)), expected);
    }
}
