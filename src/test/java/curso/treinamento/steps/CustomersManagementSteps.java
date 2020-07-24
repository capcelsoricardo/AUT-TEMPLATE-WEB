package curso.treinamento.steps;

import org.testng.Assert;

import curso.treinamento.pages.AddCustomerPage;
import curso.treinamento.pages.CustomersManagementPage;
import curso.treinamento.pages.MenuPage;
import curso.treinamento.setup.Hooks;
import curso.treinamento.utils.Helper;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.cucumber.datatable.DataTable;


public class CustomersManagementSteps {
	
	MenuPage menuPage = new MenuPage(Hooks.getDriver());
	CustomersManagementPage customersManagementPage = new CustomersManagementPage(Hooks.getDriver());
	AddCustomerPage addCustomerPage = new AddCustomerPage(Hooks.getDriver());
	Helper helper = new Helper();
				
	@Dado("que eu esteja na tela Customers Management")
	public void que_eu_esteja_na_tela_Customers_Management() {		
		menuPage.clicar_submenu("ACCOUNTS", "Customers");
		Assert.assertTrue(customersManagementPage.validar_pagina(), "Página Customers Management NÃO apresentada.");
	}

	@Quando("incluo um customer")
	public void incluo_um_customer(DataTable dataTable) {
		customersManagementPage.clicar_btn_add();
					
		Assert.assertTrue(addCustomerPage.validar_pagina(), "Página Add Admin NÃO apresentada.");
		
		Helper.create_datatable(dataTable);
		
		addCustomerPage.preencher_first_name(Helper.dataTable.get(0).get("First Name"));
		addCustomerPage.preencher_last_name(Helper.dataTable.get(0).get("Last Name"));
		addCustomerPage.preencher_email(Helper.dataTable.get(0).get("Email"));
		addCustomerPage.preencher_password(Helper.dataTable.get(0).get("Password"));
		addCustomerPage.preencher_mobile_number(Helper.dataTable.get(0).get("Mobile Number"));
		addCustomerPage.selecionar_country(Helper.dataTable.get(0).get("Country"));
		addCustomerPage.preencher_adress1(Helper.dataTable.get(0).get("Address 1"));
		addCustomerPage.preencher_adress2(Helper.dataTable.get(0).get("Address 2"));
		addCustomerPage.selecionar_status(Helper.dataTable.get(0).get("Status"));
		addCustomerPage.clicar_btn_submit();
	}

	@Então("customer cadastrado com sucesso")
	public void customer_cadastrado_com_sucesso() {
		Assert.assertTrue(customersManagementPage.validar_email_na_tabela(Helper.dataTable.get(0).get("Email")), "Usuário não cadastrado com sucesso.");
	}

	@Quando("altero informações do customer")
	public void altero_informacoes_do_customer(DataTable dataTable) {		
		Helper.create_datatable(dataTable);
		
		Assert.assertTrue(customersManagementPage.validar_email_na_tabela(Helper.dataTable.get(0).get("Email Antigo")), "E-mail " + Helper.dataTable.get(0).get("Email Antigo") + " não encontrado para alteração.");

		customersManagementPage.clicar_btn_editar(Helper.dataTable.get(0).get("Email Antigo"));
		
		addCustomerPage.preencher_first_name(Helper.dataTable.get(0).get("First Name"));
		addCustomerPage.preencher_last_name(Helper.dataTable.get(0).get("Last Name"));
		addCustomerPage.preencher_email(Helper.dataTable.get(0).get("Email Novo"));
		addCustomerPage.preencher_password(Helper.dataTable.get(0).get("Password"));
		addCustomerPage.preencher_mobile_number(Helper.dataTable.get(0).get("Mobile Number"));
		addCustomerPage.selecionar_country(Helper.dataTable.get(0).get("Country"));
		addCustomerPage.preencher_adress1(Helper.dataTable.get(0).get("Address 1"));
		addCustomerPage.preencher_adress2(Helper.dataTable.get(0).get("Address 2"));
		addCustomerPage.selecionar_status(Helper.dataTable.get(0).get("Status"));		
		addCustomerPage.clicar_btn_submit();
	}

	@Então("informações do customer alterada com sucesso")
	public void informacoes_do_customer_alterada_com_sucesso() {				
		Assert.assertTrue(addCustomerPage.validar_mensagem_alteracao(), "Mensagem de alteração não apresentada.");		
		Assert.assertTrue(customersManagementPage.validar_email_na_tabela(Helper.dataTable.get(0).get("Email Novo")), "O customer " + Helper.dataTable.get(0).get("Email Antigo")  + " não foi alterado para " + Helper.dataTable.get(0).get("Email Novo"));	
	}

	@Quando("excluo o customer {string}")
	public void excluo_o_customer(String email) {
		customersManagementPage.clicar_btn_excluir(email);
		
		System.out.println("Foi apresentado um pop-up com a mensagem: " + Hooks.getDriver().switchTo().alert().getText());
		
		Hooks.getDriver().switchTo().alert().accept();
	}

	@Então("customer {string} excluido com sucesso")
	public void customer_excluido_com_sucesso(String email) {
		Assert.assertFalse(customersManagementPage.validar_email_na_tabela(email), "Customer " + email + " não excluido!");
	}		
}
