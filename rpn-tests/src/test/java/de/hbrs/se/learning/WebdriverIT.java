package de.hbrs.se.learning;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


public class WebdriverIT extends AbstractWebdriverIT {

    @Test
    public void simpleOperationTest() {
        driver.findElement(By.id("expression")).clear();
        driver.findElement(By.id("expression")).sendKeys("3 2 +");
        driver.findElement(By.id("submit")).click();
        Assert.assertThat(driver.findElement(By.id("result")).getText(), CoreMatchers.is(CoreMatchers.equalTo("5.0")));
        Assert.assertThat(driver.findElement(By.id("oldExpression")).getText(), CoreMatchers.is(CoreMatchers.equalTo("3 2 +")));
    }

    @Test
    public void simpleFailureTest() {
        driver.findElement(By.id("expression")).clear();
        driver.findElement(By.id("expression")).sendKeys("error!");
        driver.findElement(By.id("submit")).click();
        Assert.assertThat(driver.findElement(By.id("errorMessage")).getText(), CoreMatchers.is(CoreMatchers.equalTo("Error: Unknown string: error!")));
    }

}
