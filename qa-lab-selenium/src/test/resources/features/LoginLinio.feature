Feature: Login Linio

  @StepLinio
  Scenario: Login correcto
    Given estoy en la pagina de login de Linio
    When ingreso con el usuario "carotasayco@gmail.com"
    And ingreso la contraseña "Carolina01"
    And clic en el boton ingresar
    Then se valida nombre de usuario "Angie"
    When ingreso a la seccion de Mejores Calificados
    And selecciono un producto
    And agrego el producto al carrito de compras
    Then se valida el mensaje "Tu producto se agregó al carrito"
