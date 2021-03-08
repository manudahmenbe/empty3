package test3;

import one.empty3.library.*;
import org.junit.Test;
public class TestMethodesCouleur extends TestCase {
    @Test
    public void testColorIdent() {
        Lumiere.getRgb(Color.WHITE);
    }
}
