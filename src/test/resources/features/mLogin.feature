#language: en

Feature: The user logs in

  Background: open de page magneto
    Given the user enter the page magneto

  Scenario: login
    When the user enter esteban.comfama@magneto365.com and DivisionBell+
    Then the user sees Esteba magneto


  #Scenario Outline: login
   # When the user enter username and password
    #  | <username> | <password> |
    #Then the user sees <indicativo> magneto
    #Examples:
     #| username                       | password      | indicativo   |
     #| esteban.comfama@magneto365.com | DivisionBell+ | ¡Bienvenido! |
     #| esteban.comfama@magneto365.com | DivisionBell+ | El email o la contraseña son incorrectos |