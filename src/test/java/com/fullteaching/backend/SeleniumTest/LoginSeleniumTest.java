package com.fullteaching.backend.SeleniumTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSeleniumTest {

    private WebDriver driver;

    @BeforeEach
    public void beforeEach() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\test\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void afterEach() {
        driver.close();
        driver.quit();
    }

    private void login(String email, String senha) {
        WebElement botaoLogin = driver.findElement(By.cssSelector("#navigation-bar > div > ul > li:nth-child(2) > a"));
        WebElement emailUsuario = driver.findElement(By.cssSelector("#email"));
        WebElement senhaUsuario = driver.findElement(By.cssSelector("#password"));
        WebElement submit = driver.findElement(By.cssSelector("#log-in-btn"));
        botaoLogin.click();
        emailUsuario.click();
        emailUsuario.sendKeys(email);
        senhaUsuario.click();
        senhaUsuario.sendKeys(senha);
        submit.click();
    }

    @Test
    public void testeLoginSucedido() throws InterruptedException {
        driver.get("https://localhost:5000/");
        Thread.sleep(5000);
        this.login("teacher@gmail.com", "pass");
        Thread.sleep(5000);
        assertEquals("https://localhost:5000/courses", driver.getCurrentUrl());
    }

    @Test
    public void testeLoginFalha() throws InterruptedException {
        driver.get("https://localhost:5000/");
        Thread.sleep(3000);
        this.login("email@email.com", "123");
        Thread.sleep(7000);
        assertFalse("https://localhost:5000/courses".equals(driver.getCurrentUrl()));
    }

    @Test
    public void logout() throws InterruptedException {
        driver.get("https://localhost:5000/");
        Thread.sleep(5000);
        this.login("teacher@gmail.com", "pass");
        Thread.sleep(5000);
        driver.findElement(By.id("arrow-drop-down")).click();
        driver.findElement(By.id("logout-button")).click();

    }

}