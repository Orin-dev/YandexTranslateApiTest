import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.orindev.bostongenetest.yandextranslateapitest.Main;

public class MainClassTest extends Main {
    @Test
    @Ignore
    public void WhenTryingToTranslatePhrase_ThenGotCorrectTranslation() {
       String string = MainClassTest.translateToRussian("to be or not to be", "Your api key"); //Для запуска заменить на Ваш ключ и убрать аннотацию @Ignore
       Assert.assertEquals(string, "быть или не быть");
    }
}
