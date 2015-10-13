package controlador;


import persistencia.Perfil;
import persistencia.PerfilDAO;
import spark.ModelAndView;
import spark.Request;
import spark.TemplateViewRoute;


public class SalvaControlador implements TemplateViewRoute{ 

	private PerfilDAO dao = new PerfilDAO();


	@Override
	public ModelAndView handle(Request req, spark.Response resp) {
		Perfil perfil = new Perfil();
		perfil.setNome(req.queryMap("nome").value());
		perfil.setPeso(req.queryMap("peso").doubleValue());
		perfil.setAltura(req.queryMap("altura").doubleValue());
		dao.save(perfil);	
		resp.redirect("/lista");
		return null;
	}


}
