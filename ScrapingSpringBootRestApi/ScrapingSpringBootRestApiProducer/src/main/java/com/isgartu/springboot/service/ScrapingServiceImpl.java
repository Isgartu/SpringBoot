package com.isgartu.springboot.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.isgartu.springboot.model.Web;

@Service("scrapingService")
public class ScrapingServiceImpl implements ScrapingService {

	public static final Logger logger = LoggerFactory.getLogger(ScrapingServiceImpl.class);

	
	@Override
	public List<Web> getByUrl(String url) {
		List<Web> web = new ArrayList<Web>();
		
		// Compruebo si me da un 200 al hacer la petición
		if (getStatusConnectionCode(url) == 200) {

			// Obtengo el HTML de la web en un objeto Document
			Document document = getHtmlDocument(url);

			// Busco todas las historias de meneame que estan dentro de:
			Elements entradas = document.select("article.news-item.entrada");
			logger.info("Número de entradas en la página 1 de noticias de programacion de softzone: "
					+ entradas.size() + "\n");

			// Paseo cada una de las entradas
			for (Element elem : entradas) {
				String titulo = elem.getElementsByClass("entry-title").text();
				String description = elem.getElementsByClass("entry-summary").text();
				String link = elem.getElementsByTag("a").last().attr("href");
				String fecha = elem.getElementsByClass("news-timebadge").text();

				web.add(new Web(titulo,description,link,fecha));
				
				logger.info("Titulo: " + titulo + "\n Descripcion: " + description + "\n link: "
						+ link.toString() + "\n Fecha: " + fecha + "\n\n");

				// Con el método "text()" obtengo el contenido que hay dentro de las etiquetas HTML
				// Con el método "toString()" obtengo todo el HTML con etiquetas incluidas
			}
		}
		return web;
	}

	/**
	 * Con esta método compruebo el Status code de la respuesta que recibo al hacer
	 * la petición EJM: 200 OK 300 Multiple Choices 301 Moved Permanently 305 Use
	 * Proxy 400 Bad Request 403 Forbidden 404 Not Found 500 Internal Server Error
	 * 502 Bad Gateway 503 Service Unavailable
	 * 
	 * @param url
	 * @return Status Code
	 */
	public static int getStatusConnectionCode(String url) {

		Response response = null;

		try {
			response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
		} catch (IOException ex) {
			logger.info("Excepción al obtener el Status Code: " + ex.getMessage());
		}
		return response.statusCode();
	}

	/**
	 * Con este método devuelvo un objeto de la clase Document con el contenido del
	 * HTML de la web que me permitirá parsearlo con los métodos de la librelia
	 * JSoup
	 * 
	 * @param url
	 * @return Documento con el HTML
	 */
	public static Document getHtmlDocument(String url) {

		Document doc = null;

		try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
		} catch (IOException ex) {
			logger.info("Excepción al obtener el HTML de la página" + ex.getMessage());
		}

		return doc;

	}
}
