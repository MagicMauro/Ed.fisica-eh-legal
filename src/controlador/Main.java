
package controlador;


import spark.Route;
import spark.Spark;
import spark.TemplateViewRoute;
import spark.template.mustache.MustacheTemplateEngine;


public class Main {	
	public static void main(String[] args) {
	

		// psrecisa de um package publico (pub)
		// onde ficam os css, js, imgs, conteúdo fixo
		Spark.staticFileLocation("/publico");
		
		// precisa de um package apresentacao (views)
		// onde ficam os HTML's
		MustacheTemplateEngine engine = 
				new MustacheTemplateEngine("apresentacao");
		
		
		NovoControlador novoControlador = 	new NovoControlador();
		
		// abrir o form
		Spark.get("/novo", novoControlador, engine);
		
		SalvaControlador salvaControlador =
				new SalvaControlador();
		
		// submissão do form
		Spark.post("/salva", salvaControlador, engine);
		
		ListaControlador listaControlador =
				new ListaControlador();
		
		Spark.get("/lista", listaControlador, engine);

		NewDeleteController novodeletaControlador = new NewDeleteController();
		RemoveController deletaControlador = new RemoveController();

		
		
		Spark.get("/novodeleta", novodeletaControlador, engine);
		Spark.post("/deleta", deletaControlador, engine);
	
	}
	
	}
