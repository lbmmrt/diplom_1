import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizationTest {

    private final String expected;
    private final IngredientType actual;

    public IngredientTypeParameterizationTest(String expected, IngredientType actual) {
        this.actual = actual;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] setIngredient() {
        return new Object[][]{
                {"SAUCE", SAUCE},
                {"FILLING", FILLING},
        };
    }

    @Test
    public void checkEnumIngredientType() {
        assertEquals(expected, String.valueOf(actual));
    }
}
