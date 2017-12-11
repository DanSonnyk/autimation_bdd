package br.com.yaman.automacao.navegador.selenium.searchElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * 
 * Prop�sito da classe: Encapsular metodos de fun��es espec�ficas par busca de elementos no navegador
 *
 * @since 10 de Dez de 2017 10:46:12
 * @author Daniel Simi�o<BR>
 *         DesafioYaman<BR>
 * 
 */
public class SearchElement{
	protected WebDriver webDriver;
	
	public SearchElement(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	/**
	 * 
	 * Prop�sito do M�todo: retornar um WebELement com base no Xpath passado por par�metro
	 *
	 * @since 10 de Dez de 2017 10:52:46
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public WebElement getWebElement(String xpath) {
		return webDriver.findElement(By.xpath(xpath));
	}
	
	/**
	 * 
	 * Prop�sito do M�todo: retornar uma lista de WebELements com base no Xpath passado por par�metro
	 *
	 * @since 10 de Dez de 2017 10:55:28
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public List<WebElement> getListWebElements(String xpath) {
		return webDriver.findElements(By.xpath(xpath));
	}
	
	/**
	 * 
	 * Prop�sito do M�todo: rolar a pagina at� o elemento passado por par�metro
	 *
	 * @since 10 de Dez de 2017 10:55:28
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public void rollToElement(WebElement element) {
		((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
