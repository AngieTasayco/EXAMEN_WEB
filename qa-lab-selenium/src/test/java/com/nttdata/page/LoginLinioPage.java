package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginLinioPage {

    //Localizadores de elementos
    public static By userInput = By.id("login_form_email");
    public static By passInput = By.id("login_form_password");
    public static By loginButton = By.xpath("/html/body/div[1]/main/div/div/div[2]/div[1]/form/button");
    public static By nombreUsuario=By.xpath("/html/body/header/nav/div/div[4]/div[2]/a");
    public static By mejorCalificado=By.xpath("/html/body/div[3]/main/div[1]/div[1]/div[1]/a[4]/span[2]");
    public static By producto =By.xpath("/html/body/div[3]/main/div/div[8]/div[2]/div/div[1]/a[1]/div[1]/figure/picture/img");
    public static By carrito= By.id("buy-now");


}
