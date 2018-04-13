import org.junit.Assert;
import org.junit.Test;
import ru.orindev.bostongenetest.yandextranslateapitest.Main;

/**
 * Created by Orin on 13.04.2018.
 */
public class MainClassTest extends Main {
    @Test
    public void WhenTryingToTranslatePhrase_ThenGotCorrectTranslation() {
       String string = MainClassTest.translateToRussian("to be or not to be");
       Assert.assertEquals(string, "быть или не быть");
    }
}
