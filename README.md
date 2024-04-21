# Sprint_4

## Способ запуска:

### браузеры (chrome/firefox)

Через консоль, командой -  mvn clean test -Dbrowser=<выбрать браузер>


Через Intelij Idea - в классе BeforeAfterForTest в в методе  init() меняем дифолтное значение на нужный браузер
```
 @Before
    public void init() {
        webDriver = WebDriverFactory.getWebDriver(System.getProperty("browser", "chrome"));
    }
```

Для windows 11 FirefoxDriver создавать без WebDriverManager.

```
public class WebDriverFactory {
    public static WebDriver getWebDriver(String browserType) {
        if (browserType.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    }
}
```
### В Chrome браузере
Тесты "headerOrderTest" и "centerOrderTest" не проходят из за бага.