package controlador;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class NewDeleteController implements TemplateViewRoute {

	public ModelAndView handle(Request req, Response resp) {
		return new ModelAndView(null, "Remove.html");
	}

}
