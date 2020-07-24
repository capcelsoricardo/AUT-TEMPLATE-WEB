package curso.treinamento.steps;

import org.testng.Assert;

import curso.treinamento.pages.HomePage;
import curso.treinamento.pages.MenuPage;
import curso.treinamento.setup.Hooks;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;


public class VisualizacaoMenuSteps {
	
	HomePage homePage = new HomePage(Hooks.getDriver());
	MenuPage menuPage = new MenuPage(Hooks.getDriver());
	
	@Dado("que eu esteja na tela Home")
	public void que_eu_esteja_na_tela_Home() {
	    Assert.assertTrue(homePage.validar_pagina(), "Página Home NÃO foi apresentada.");
	}
	
	@Quando("acesso o menu General")
	public void acesso_o_menu_General() {
		menuPage.clicar_menu_general();		
	}

	@Quando("acesso o menu Cars")
	public void acesso_o_menu_Cars() {		
		menuPage.clicar_menu_cars();	    
	}

	@Então("são apresentados os itens do menu Cars {string}, {string} e {string}")
	public void sao_apresentados_os_itens(String subMenuCars, String subMenuExtras, String subMenuSettings) {
		
		Assert.assertTrue(menuPage.validar_submenu_cars(subMenuCars), "Submenu "+ subMenuCars + " NÃO apresentado.");
		Assert.assertTrue(menuPage.validar_submenu_cars(subMenuExtras), "Submenu "+ subMenuExtras + " NÃO apresentado.");
		Assert.assertTrue(menuPage.validar_submenu_cars(subMenuSettings), "Submenu "+ subMenuSettings + " NÃO apresentado.");
	}
	
	@Quando("acesso o menu Accounts")
	public void acesso_o_menu_Accounts() {		
		menuPage.clicar_menu_accounts();	 		
	}

	@Então("são apresentados os itens do menu Accounts {string}, {string}, {string} e {string}")
	public void sao_apresentados_os_itens(String subMenuAdmins, String subMenuSuppliers, String subMenuCustomers, String subMenuGuestCustomers) {
		
		Assert.assertTrue(menuPage.validar_submenu_accounts(subMenuAdmins), "Submenu "+ subMenuAdmins + " NÃO apresentado.");
		Assert.assertTrue(menuPage.validar_submenu_accounts(subMenuSuppliers), "Submenu "+ subMenuSuppliers + " NÃO apresentado.");
		Assert.assertTrue(menuPage.validar_submenu_accounts(subMenuCustomers), "Submenu "+ subMenuCustomers + " NÃO apresentado.");
		Assert.assertTrue(menuPage.validar_submenu_accounts(subMenuGuestCustomers), "Submenu "+ subMenuGuestCustomers + " NÃO apresentado.");
	} 	
	
	@Quando("acesso o menu Tours")
	public void acesso_o_menu_Tours() {		
		menuPage.clicar_menu_tours();
	}

	@Então("são apresentados os itens do menu Tours {string}, {string}, {string}, {string} e {string}")
	public void sao_apresentados_os_itens(String subMenuTours, String subMenuAddNew, String subMenuExtras, String subMenuReviews, String subMenuSettings) {
		
		Assert.assertTrue(menuPage.validar_submenu_tours(subMenuTours), "Submenu "+ subMenuTours + " NÃO apresentado.");
		Assert.assertTrue(menuPage.validar_submenu_tours(subMenuAddNew), "Submenu "+ subMenuAddNew + " NÃO apresentado.");
		Assert.assertTrue(menuPage.validar_submenu_tours(subMenuExtras), "Submenu "+ subMenuExtras + " NÃO apresentado.");
		Assert.assertTrue(menuPage.validar_submenu_tours(subMenuReviews), "Submenu "+ subMenuReviews + " NÃO apresentado.");
		Assert.assertTrue(menuPage.validar_submenu_tours(subMenuSettings), "Submenu "+ subMenuSettings + " NÃO apresentado.");
	}	
	
	@Quando("acesso o menu Travelhope Hotels")
	public void acesso_o_menu_travelhope_hotels() {
		menuPage.clicar_menu_travelhope_hotels();	    
	}

	@Então("são apresentados os itens do menu Travelhope Hotels {string} e {string}")
	public void são_apresentados_os_itens_do_menu_travelhope_hotels(String subMenuBookings, String subMenuSettings) {
		
		Assert.assertTrue(menuPage.validar_submenu_travelhope_hotels(subMenuBookings), "Submenu "+ subMenuBookings + " NÃO apresentado.");
		Assert.assertTrue(menuPage.validar_submenu_travelhope_hotels(subMenuSettings), "Submenu "+ subMenuSettings + " NÃO apresentado.");
		
	}
}
