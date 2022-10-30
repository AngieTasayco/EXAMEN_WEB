package com.nttdata.stepsdefinitions;


import com.nttdata.steps.LoginLinioSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginLinioSD {

    private WebDriver driver;
    private Scenario scenario;

    private LoginLinioSteps LoginLinioSteps(WebDriver driver){
        return new LoginLinioSteps(driver);
    }

    private LoginLinioSteps loginLinioSteps;

    @Before(order = 0)
    public void setUp(){
        //setUp
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }
    @Given("estoy en la pagina de login de Linio")
    public void estoyEnLaPaginaDeLoginDeLinio() {
        loginLinioSteps =new LoginLinioSteps(driver);
        driver.get("https://www.linio.com.pe/account/login");
        screenShot();
    }

    @When("ingreso con el usuario {string}")
    public void ingresoConElUsuario(String usuario) {
        loginLinioSteps.typeUser(usuario);
        screenShot();
    }

    @And("ingreso la contraseña {string}")
    public void ingresoLaContraseña(String pass) {
        loginLinioSteps.typePassword(pass);
        screenShot();
    }

    @And("clic en el boton ingresar")
    public void clicEnElBotonIngresar() {
        loginLinioSteps.login();
        screenShot();
    }



    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }


    @Then("se valida nombre de usuario {string}")
    public void seValidaNombreDeUsuario(String usuario) {
        String nombre=LoginLinioSteps(driver).getUsuario();
        loginLinioSteps.ValidarUsuario(nombre,usuario);
        screenShot();
    }

    @When("ingreso a la seccion de Mejores Calificados")
    public void ingresoALaSeccionDeMejoresCalificados() {
        loginLinioSteps.IrMejorCalificados();
        screenShot();
    }

    @And("selecciono un producto")
    public void seleccionoUnProducto() {
        loginLinioSteps.SeleccionarProducto();
        screenShot();
    }

    @And("agrego el producto al carrito de compras")
    public void agregoElProductoAlCarritoDeCompras() {
        loginLinioSteps.AgregarProductoCarrito();
        screenShot();
    }

    @Then("se valida el mensaje {string}")
    public void seValidaElMensaje(String mensaje) {
        String mensajeEsperado=LoginLinioSteps(driver).getUsuario();
        loginLinioSteps.ValidarConfirmacionCarrito(mensaje,mensajeEsperado);
        screenShot();
    }
}
