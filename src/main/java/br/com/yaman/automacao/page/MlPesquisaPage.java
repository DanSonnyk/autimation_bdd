package br.com.yaman.automacao.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import br.com.yaman.automacao.navegador.selenium.command.CommandWeb;
import br.com.yaman.automacao.navegador.selenium.searchElement.SearchElement;

/**
 * 
 * Prop�sito da classe: Encapsular metodos de captura de Elementos na tela Inicial Mercado Livre
 *
 * @since 10 de Dez de 2017 13:37:49
 * @author Daniel Simi�o<BR>
 *         DesafioYaman<BR>
 * 
 */
public class MlPesquisaPage {
	CommandWeb command;
	SearchElement searchElement;

	public MlPesquisaPage(CommandWeb command, SearchElement searchElement) {
		this.command = command;
		this.searchElement = searchElement;
	}

	public final String valueItemPesquisado = ".//*[@id='inner-main']/aside/div[1]/h1";
	public final String mensagemRetornoNegativo = "*//h3[contains(text(),'N�o h� an�ncios que coincidam com a sua busca.')]";
	public final String listaDeResultadosPesquisa = ".//*[@id='searchResults']";
	public final String nomeProdutoDaLista = "//*[@id=\"searchResults\"]/li[1]/div/div[2]/div/h2/a/span";
	public final String contItensLista = "//*[@id='searchResults']/li";
	public final String paginacaoElements = "//*[@id=\"results-section\"]//li[@class='pagination__page']/a";

	
	/**
	 * 
	 * Prop�sito do M�todo: retorna o elemento que evidencia qual item foi pesquisado para confirma��o de sucesso na pesquisa
	 *
	 * @since 10 de Dez de 2017 13:38:19
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public WebElement getItemPesquisado() {
		return searchElement.getWebElement(valueItemPesquisado);
	}

	/**
	 * 
	 * Prop�sito do M�todo: retorna o elemento que evidencia qual que a pesquisa n�o retornou resultados
	 *
	 * @since 10 de Dez de 2017 13:46:34
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public WebElement getMensagemRetornoNegativo() {
		return searchElement.getWebElement(mensagemRetornoNegativo);
	}

	/**
	 * Devolve Lista de objetos do tipo ItemPesquisadoBean contendo os dados dos
	 * items retornados na tela ap�s pesquisa
	 * 
	 * @return List<ItemPesquisadoBean>
	 */
	public List<ItemPesquisadoBean> getListItensPesquisadosValues() {
		List<ItemPesquisadoBean> listaItens = new ArrayList<ItemPesquisadoBean>();
		int quantItens = searchElement.getListWebElements(contItensLista).size();

		for (int i = 1; i <= quantItens; i++) {
			ItemPesquisadoBean item = new ItemPesquisadoBean();
			item.setNome(getNomeItemOnList(i));
			item.setValor(getValorItemOnList(i));
			item.setPosicao(i);

			listaItens.add(item);
		}
		return listaItens;
	}

	/**
	 * 
	 * Prop�sito do M�todo: retorna uma lista de elementos retornados na pesquisa realizada
	 *
	 * @since 10 de Dez de 2017 13:50:37
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public List<WebElement> getListItensPesquisadosElements() {
		return searchElement.getListWebElements(contItensLista);
	}

	/**
	 * 
	 * Prop�sito do M�todo: retorna o nome de um elemento retornado na pesquisa
	 *
	 * @since 10 de Dez de 2017 13:55:19
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	private String getNomeItemOnList(int posit) {
		return searchElement.getWebElement(
				"//*[@id='searchResults']/li[" + posit + "]//h2[@class='item__title list-view-item-title']/span")
				.getText();
	}

	/**
	 * 
	 * Prop�sito do M�todo: retorna o nome de um elemento retornado na pesquisa
	 *
	 * @since 10 de Dez de 2017 13:59:53
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	private String getValorItemOnList(int posit) {
		return searchElement.getWebElement("//*[@id='searchResults']/li[" + posit + "]//span[@class='price-symbol']")
				.getText()
				+ " "
				+ searchElement
						.getWebElement("//*[@id='searchResults']/li[" + posit + "]//span[@class='price-fraction']")
						.getText();
	}


	/**
	 * 
	 * Prop�sito do M�todo: retorna o elemento de uma pagina do container de pagina��o da pesquisa
	 *
	 * @since 10 de Dez de 2017 15:12:28
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public WebElement getPaginacaoElement(String pagina) {
		List<WebElement> itensPaginacao = searchElement.getListWebElements(paginacaoElements);
		for (WebElement webElement : itensPaginacao) {
			if (webElement.getText().equals(pagina)) {
				return webElement;
			}
		}
		return null;
	}

}
