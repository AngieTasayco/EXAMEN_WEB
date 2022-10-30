package com.nttdata.steps;

import com.nttdata.page.LoginLinioPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginLinioSteps {

    private WebDriver driver;

    //constructor
    public LoginLinioSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(LoginLinioPage.userInput);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLinioPage.loginButton));


    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(LoginLinioPage.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        this.driver.findElement(LoginLinioPage.loginButton).click();
    }
    public String getUsuario(){
        return this.driver.findElement(LoginLinioPage.nombreUsuario).getText();
    }
    public void ValidarUsuario(String nombre, String usuario){
        Assertions.assertEquals(nombre,usuario);
    }

    public void IrMejorCalificados(){
        this.driver.findElement(LoginLinioPage.mejorCalificado).click();
    }
    public void SeleccionarProducto(){
        this.driver.findElement(LoginLinioPage.producto).click();
    }

    public void AgregarProductoCarrito(){
        this.driver.findElement(LoginLinioPage.carrito).click();
    }

    public void ValidarConfirmacionCarrito(String mensaje,String mensajeEsperado){
        Assertions.assertEquals(mensaje,mensajeEsperado);
    }
}
