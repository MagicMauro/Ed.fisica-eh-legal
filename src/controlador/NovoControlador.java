package controlador;

import java.util.HashMap;

import javax.xml.ws.Response;

import spark.ModelAndView;
import spark.Request;
import spark.TemplateViewRoute;

public class NovoControlador implements TemplateViewRoute {

	
	public ModelAndView handle(Request req, spark.Response resp) {
		HashMap mapa = new HashMap();
		return new ModelAndView(mapa, "usuario.html");
	}

}

