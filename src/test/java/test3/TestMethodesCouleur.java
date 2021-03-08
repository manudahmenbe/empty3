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
        Color col1 =  new Color(           Lumiere.getInt(            Lumiere.getRgb(             col            )           )          );
        Color col2 =  Lumiere.getColorD(Lumiere.getDoubles(col.getRGB()))       ;
            System.out.println("col"+col+"\ncol1 "+col1+"\ncol2"+col2);
            assertTrue(col1.
         equals(
          col
         )
        );
        assertTrue(
          col2 .equals(col)
        );          
       }
    }
}
