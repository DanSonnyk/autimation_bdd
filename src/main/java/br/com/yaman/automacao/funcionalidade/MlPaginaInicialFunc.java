package br.com.yaman.automacao.funcionalidade;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.yaman.automacao.navegador.selenium.browser.WebDriverFactory;
import br.com.yaman.automacao.navegador.selenium.command.CommandWeb;
import br.com.yaman.automacao.navegador.selenium.searchElement.SearchElement;
import br.com.yaman.automacao.navegador.utils.Navegador;
import br.com.yaman.automacao.navegador.utils.Sites;
import br.com.yaman.automacao.page.ItemPesquisadoBean;
import br.com.yaman.automacao.page.MlPaginaInicialPage;
import br.com.yaman.automacao.page.MlPesquisaPage;
import br.com.yaman.automacao.utils.LoggerUtils;
import cucumber.api.DataTable;

/**
 * 
 * Prop�sito da classe: Encapsular metodos de fun��es espec�ficas da tela Pagina
 * Inicial do Mercado Livre
 *
 * @since 10 de Dez de 2017 08:19:27
 * @author Daniel Simi�o<BR>
 *         DesafioYaman<BR>
 * 
 */

public class MlPaginaInicialFunc {
	LoggerUtils logger = new LoggerUtils(MlPaginaInicialFunc.class);

	WebDriverFactory webDriverFactory = new WebDriverFactory();
	protected WebDriver webDriver = webDriverFactory.setWebDriver(Navegador.CHROME).getWebDriver();

	CommandWeb command = new CommandWeb(webDriver);
	SearchElement searchElement = new SearchElement(webDriver);

	MlPaginaInicialPage mlPaginaInicialPage = new MlPaginaInicialPage(command, searchElement);
	MlPesquisaPage mlPesquisaPage = new MlPesquisaPage(command, searchElement);

	/**
	 * 
	 * Prop�sito do M�todo: Acessar pagina inicial Mercado Livre
	 *
	 * @since 10 de Dez de 2017 08:30:32
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public void acessaPaginaInicialMl() {
		command.goToSite(Sites.MERCADOLIVRE);
		command.hightLight(mlPaginaInicialPage.getInputBusca());
	}

	/**
	 * 
	 * Prop�sito do M�todo: Realizar pesquisa simples inserindo um valor passado por
	 * par�metro no imput principal da tela inicial Mercado Livre
	 *
	 * @since 10 de Dez de 2017 08:35:23
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public void realizaPesquisaSimples(DataTable dataTable) {
		String itemPesquisado = null;
		for (Map<String, String> map : dataTable.asMaps(String.class, String.class)) {
			itemPesquisado = map.get("itemPesquisado");
		}

		command.inputValue(mlPaginaInicialPage.getInputBusca(), itemPesquisado);
		command.hightLight(mlPaginaInicialPage.getInputBusca());
		command.click(mlPaginaInicialPage.getLupaPesquisar());

		if (mlPesquisaPage.getItemPesquisado().getText().contains(itemPesquisado.toLowerCase())) {
			command.hightLight(mlPesquisaPage.getItemPesquisado());
			logger.info("Pesquisa realizada com sucesso...");
		} else {
			logger.info("Pesquisa realizada n�o retornou itens para verifica��o...");
			throw new RuntimeException();
		}
	}

	/**
	 * 
	 * Prop�sito do M�todo: Imprime no console o Nome e o Valor dos 5 Primeiros
	 * resultados de uma pesquisa realizada na pagina inicial Mercado Livre
	 *
	 * @since 10 de Dez de 2017 08:36:32
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public void imprimirDadosCincoPrimeirosResultados() {
		List<ItemPesquisadoBean> listaItens = mlPesquisaPage.getListItensPesquisadosValues();

		if (listaItens.size() < 5) {
			logger.info("\n A pesquisa retornou menos de 5 resultados! \n");
		}

		for (int i = 0; i < 5; i++) {
			logger.info("\n" + "**********************************[Item - " + listaItens.get(i).getPosicao()
					+ " ]***********************************\n"
					+ "*                                                                              *\n"
					+ "*  Nome do produto: " + listaItens.get(i).getNome() + "\n" + "*  Valor do produto: "
					+ listaItens.get(i).getValor() + "                                                  *\n"
					+ "*                                                                              *\n"
					+ "********************************************************************************");
		}
		webDriver.quit();
	}

	/**
	* 
	* Prop�sito do M�todo: Realiza pagina��o par a uma pagina passada por par�metro da feature
	*
	* @since 10 de Dez de 2017 08:40:32
	* @author Daniel Simi�o<BR>
	*         DesafioYaman<BR>
	* @param 
	* 
	*/
	public void paginarTo(DataTable dataTable) {
		String numPagina = null;
		for (Map<String, String> map : dataTable.asMaps(String.class, String.class)) {
			numPagina = map.get("paginacao");
		}
		paginaPesquisa(numPagina);

	}

	/**
	* 
	* Prop�sito do M�todo: Realiza a pagina��o de uma pesquisa realizada acessando a pagina passada por par�metro
	*
	* @since 10 de Dez de 2017 08:45:44
	* @author Daniel Simi�o<BR>
	*         DesafioYaman<BR>
	* 
	*/
	private void paginaPesquisa(String numPagina) {
		mlPesquisaPage.getPaginacaoElement(numPagina).click();
	}

	/**
	* 
	* Prop�sito do M�todo: Evidencia com HighLight um WebElement passado por par�metro
	*
	* @since 10 de Dez de 2017 08:50:32
	* @author Daniel Simi�o<BR>
	*         DesafioYaman<BR>
	* 
	*/
	public void evidenciaPenultimoAnuncio() {
		List<WebElement> listaItens = mlPesquisaPage.getListItensPesquisadosElements();
		WebElement penultimoItem = listaItens.get(listaItens.size() - 2);
		searchElement.rollToElement(penultimoItem);
		command.screenShot(penultimoItem);
		webDriver.quit();
	}
}
