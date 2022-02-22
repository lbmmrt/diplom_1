import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Database;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;

    @Test
    public void getName() {
        bun = new Bun("red bun", 300);
        String actual = bun.getName();
        String expected = "red bun";
        assertEquals(expected, actual);
    }

    @Test
    public void getPrice() {
        bun = new Bun("black bun", 100);
        float actual = bun.getPrice();
        float expected = 100f;
        Assert.assertEquals(expected, actual, 0.0);
    }
}
