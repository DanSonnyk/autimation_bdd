package br.com.yaman.automacao.page;

import org.openqa.selenium.WebElement;

import br.com.yaman.automacao.navegador.selenium.command.CommandWeb;
import br.com.yaman.automacao.navegador.selenium.searchElement.SearchElement;

/**
 * 
 * Prop�sito da classe: Encapsular metodos de fun��es espec�ficas par busca de elementos no navegador
 *
 * @since 10 de Dez de 2017 11:20:36
 * @author Daniel Simi�o<BR>
 *         DesafioYaman<BR>
 * 
 */
public class MlPaginaInicialPage {
	CommandWeb command;
	SearchElement searchElement;

	public MlPaginaInicialPage(CommandWeb command, SearchElement searchElement) {
		this.command = command;
		this.searchElement = searchElement;
	}
	
	public final String carrinhoDeComprasXp = "//*[@id='nav-cart']/i";
	public final String inputBuscaXp = "html/body/header/div/form/input";
	public final String buttonPesquisar = "html/body/header/div/form/button[3]";
	
	/**
	 * 
	 * Prop�sito do M�todo: retorna o elemento 'Carrinho de compras ' na tela
	 *
	 * @since 10 de Dez de 2017 11:27:39
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public WebElement getCarrinhoDeCompras() {
		return searchElement.getWebElement(carrinhoDeComprasXp);
	}

	/**
	 * 
	 * Prop�sito do M�todo: retorna o elemento 'Input de busca principal' na tela
	 *
	 * @since 10 de Dez de 2017 11:29:27
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public WebElement getInputBusca() {
		return searchElement.getWebElement(inputBuscaXp);
	}
	
	/**
	 * 
	 * Prop�sito do M�todo: retorna o elemento 'botao lupa de pesquisa' na tela
	 *
	 * @since 10 de Dez de 2017 11:33:19
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public WebElement getLupaPesquisar() {
		return searchElement.getWebElement(buttonPesquisar);
	}		
}
