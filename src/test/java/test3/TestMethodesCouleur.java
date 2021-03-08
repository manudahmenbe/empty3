package test3;
import one.empty3.library.core.lighting.Colors;
import one.empty3.library.*;
import org.junit.Test;
import java.awt.Color;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue; 
public class TestMethodesCouleur {
    @Test
    public void testColorIdent() {
       for(int c=0; c<5; c++) {
        Color col = Colors.random();
        assertTrue(
         new Color(
          Lumiere.getInt(
           Lumiere.getRgb(
            col
           )
          )
         ).equals(
          col
         )
        );
        assertTrue(
         Lumiere.getColorD(Lumiere.getDoubles(col.getRGB()))
         .equals(col));
        );          
       }
    }
}
