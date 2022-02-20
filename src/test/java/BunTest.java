import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;

    Database database = new Database();

    @Test
    public void getName() {
        bun = database.availableBuns().get(0);
        String actual = bun.getName();
        String expected = "black bun";
        assertEquals(expected, actual);
    }

    @Test
    public void getPrice() {
        bun = database.availableBuns().get(1);
        float actual = bun.getPrice();
        float expected = 200f;
        Assert.assertEquals(expected, actual, 0.0);
    }
}
