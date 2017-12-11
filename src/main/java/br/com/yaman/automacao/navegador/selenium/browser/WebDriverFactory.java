package br.com.yaman.automacao.navegador.selenium.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.yaman.automacao.navegador.utils.Navegador;

/**
 * 
 * Prop�sito da classe: Encapsular metodos de fun��es espec�ficas da Fabrica de WebDriver
 *
 * @since 10 de Dez de 2017 06:46:12
 * @author Daniel Simi�o<BR>
 *         DesafioYaman<BR>
 * 
 */
public class WebDriverFactory {

	final static long TIME_OUT = 30;

	private static WebDriverFactory instance = null;
	protected WebDriver webDriver;
	protected WebDriverWait webDriverWait;
	public WebDriverFactory() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * Prop�sito do M�todo: responsavel por instanciar o webDriver para o navegador
	 *
	 * @since 10 de Dez de 2017 06:50:53
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public WebDriverFactory setWebDriver(Navegador navegador) {

		switch (navegador) {
		case FIREFOX:
			webDriver = getFirefoxDriver();
			break;
		case CHROME:
			webDriver = getChromeDriver();
			break;
		case IE:
			webDriver = new InternetExplorerDriver();
		default:
			break;
		}
		
		return this;
	}

	/**
	 * 
	 * Prop�sito do M�todo: retornar a inst�ncia do WebDriver corrente
	 *
	 * @since 10 de Dez de 2017 06:52:12
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public WebDriver getWebDriver() {
		return this.webDriver;
	}

	/**
	 * 
	 * Prop�sito do M�todo: retornar a inst�ncia do WebDriver corrente por singleton
	 *
	 * @since 10 de Dez de 2017 06:50:53
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public static WebDriverFactory getInstance() {
		if (instance == null) {
			instance = new WebDriverFactory();
		}
		return instance;
	}

	/**
	 * 
	 * Prop�sito do M�todo: retornar a inst�ncia do WebDriver FireFox
	 *
	 * @since 10 de Dez de 2017 06:54:31
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	private WebDriver getFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\drivers\\geckodriver.exe");
		WebDriver fireFoxWebDriver = new FirefoxDriver();
		fireFoxWebDriver.manage().window().maximize();
		return fireFoxWebDriver;
	}

	/**
	 * 
	 * Prop�sito do M�todo: retornar a inst�ncia do WebDriver Chrome
	 *
	 * @since 10 de Dez de 2017 06:59:53
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	private WebDriver getChromeDriver() {
		try {
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
			WebDriver chromeWebDriver = new ChromeDriver();
			chromeWebDriver.manage().window().maximize();
			return chromeWebDriver;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

}
