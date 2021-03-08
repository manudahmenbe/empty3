package test3;

import one.empty3.library.*;
import org.junit.Test;
import java.awt.Color;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue; 
public class TestMethodesCouleur extends TestCase {
    @Test
    public void testColorIdent() {
        assertTrue(
         new Color(
          Lumiere.getInt(
           Lumiere.getRgb(
            Color.WHITE
           )
          )
         ).equals(
          Color.WHITE
          )
         );
    }
}
