package test3;

import one.empty3.library.*;
import org.junit.Test;
import java awt.Color;

public class TestMethodesCouleur extends TestCase {
    @Test
    public void testColorIdent() {
        assertTrue(new Color(Lumiere.getInt(Lumiere.getRgb(Color.WHITE))).equals(Color.WHITE));
    }
}
