package br.com.yaman.automacao.navegador.selenium.command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.yaman.automacao.navegador.utils.Sites;

/**
 * 
 * Prop�sito da classe: Encapsular metodos de fun��es espec�ficas da Fabrica de WebDriver
 *
 * @since 10 de Dez de 2017 10:26:13
 * @author Daniel Simi�o<BR>
 *         DesafioYaman<BR>
 * 
 */
public class CommandWeb {
	
	protected WebDriver webDriver;
	private String path = Paths.get("").toAbsolutePath().toString() + "//Evidences//";
	
	public CommandWeb(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	/**
	 * 
	 * Prop�sito do M�todo: acessar uma URL passada por par�metro
	 *
	 * @since 10 de Dez de 2017 07:12:53
	 * @author Daniel Simi�o<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public void goToSite(Sites site) {
		webDriver.get(site.getDescricao());
	}

	/**
	 * 
	 * Prop�sito do M�todo: tirar um print da pagina atual no navegador
	 *
	 * @since 10 de Dez de 2017 07:12:45
	 * 
	 */
	public void screenShot() {
		File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(path+getFileName()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * Prop�sito do M�todo: Evidencia um elemento no navegador passado por par�metro
	 *
	 * @since 10 de Dez de 2017 07:18:45
	 * 
	 */
	public void hightLight(WebElement element) {
		 ((JavascriptExecutor)webDriver).executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	
	/**
	 * 
	 * Prop�sito do M�todo: tirar um print da pagina atual no navegador evidenciando o elemento passado por par�metro
	 *
	 * @since 10 de Dez de 2017 07:22:45
	 * 
	 */
	public void screenShot(WebElement element) {
	    ((JavascriptExecutor)webDriver).executeScript("arguments[0].style.border='3px solid red'", element);
		File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File(path+getFileName(element.getTagName())+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Prop�sito do M�todo: realiza a��o de click no elemento passado por par�metro
	 *
	 * @since 10 de Dez de 2017 07:25:34
	 * 
	 */
	public void click(WebElement element) {
		element.click();
	}

	/**
	 * 
	 * Prop�sito do M�todo: realiza a��o de imputar um valor no elemento passado por par�metro
	 *
	 * @since 10 de Dez de 2017 07:25:34
	 * 
	 */
	public void inputValue(WebElement element, String value) {
		element.sendKeys(value);
	}


	private String getFileName(String nameTest) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
		Date date = new Date();
		return dateFormat.format(date) + "_" + nameTest + ".png";
		}
	
	private String getFileName() throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
		Date date = new Date();
		return dateFormat.format(date) +".png";
		}

}
