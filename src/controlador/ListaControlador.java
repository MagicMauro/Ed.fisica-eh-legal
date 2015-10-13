
package controlador;

import java.util.ArrayList;
import java.util.HashMap;

import persistencia.Perfil;
import persistencia.PerfilDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ListaControlador implements TemplateViewRoute{
		PerfilDAO dao = new PerfilDAO();

	public ModelAndView handle(Request arg0, Response arg1) {
		ArrayList<Perfil> perfil = dao.findAll();
		HashMap mapa = new HashMap();
		System.out.println(perfil);
		mapa.put("usuarios", perfil);		
		return new ModelAndView(mapa, "usuarios_lista.html");
	}
	 
 }