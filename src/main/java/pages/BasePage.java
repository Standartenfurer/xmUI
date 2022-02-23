package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;

public abstract class BasePage<T extends BasePage<T>> extends LoadableComponent {

    public T click(WebElement element) {

        return (T) this;
    }

    public T click(List<WebElement> list, int index) {

        return (T) this;
    }

    public T scroll(int times, String direction) {

        return (T) this;
    }

    public T scrollTo(WebElement element, int times, String direction) {

        return (T) this;
    }

    private void scrollUp(int times) {

    }

    private void scrollDown(int times) {

    }

}
