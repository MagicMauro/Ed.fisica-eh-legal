package controlador;


import persistencia.Perfil;
import persistencia.PerfilDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class RemoveController implements TemplateViewRoute{
	private PerfilDAO dao = new PerfilDAO();
		
	public ModelAndView handle(Request req, Response resp) {
		Perfil perfil = new Perfil();
		perfil.setNumero(req.queryMap("numero").integerValue());
		dao.delete(perfil);
		resp.redirect("/lista");
		return null;
	}

	

}
