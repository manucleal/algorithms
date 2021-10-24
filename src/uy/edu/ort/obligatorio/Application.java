package uy.edu.ort.obligatorio;

public class Application {

	public static void main(String[] args) {
		Sistema pruebaObrero = new Sistema();
		pruebaObrero.inicializarSistema(1);
		
		System.out.println("######### INICIO PRUEBA REGISTAR OBRERO #########");
		System.out.println();
		
		Retorno p1 = pruebaObrero.registrarObrero("4.765.789-1", "Fausto Perillo");
		Retorno p2 = pruebaObrero.registrarObrero("4.690.278-1", "Emanuel Coitiño");
		Retorno p5 = pruebaObrero.registrarObrero("4.690.278-1", "Emanuel Coitiño");
		Retorno p3 = pruebaObrero.registrarObrero("4.868.467-1", "Pablo Ingold");
		Retorno p4 = pruebaObrero.registrarObrero("4.765.789-1", "Pablo Ingold");
		Retorno p6 = pruebaObrero.registrarObrero("4.765.333-1", "Fernanda Serna");
		
		System.out.println(p1.resultado);
		System.out.println(p2.resultado);
		System.out.println(p5.resultado);
		System.out.println(p3.resultado);
		System.out.println(p4.resultado);
		System.out.println(p6.resultado);
		
		System.out.println();
		System.out.println("######### INICIO PRUEBA BUSCAR OBRERO #########");
		System.out.println();
		
		Retorno pruebaBuscarObrero = pruebaObrero.buscarObrero("4.765.333-1");
		
		System.out.println(pruebaBuscarObrero.resultado);
		System.out.println(pruebaBuscarObrero.valorEntero);
		System.out.println(pruebaBuscarObrero.valorString);	
		
		System.out.println();
		System.out.println("######### INICIO PRUEBA LISTAR OBREROS CRECIENTE #########");
		System.out.println();
		
		Retorno pruebaListarObrerosCreciente = pruebaObrero.listarObreros();
		System.out.println(pruebaListarObrerosCreciente.valorString);
		
		System.out.println();
		System.out.println("######### INICIO PRUEBA REGISTRAR POSTES #########");
		System.out.println();
		
		Sistema pruebaMapa = new Sistema();
		pruebaMapa.inicializarSistema(4);
		
		Retorno prubaMapa1 = pruebaMapa.registrarPoste(333, 222, "A");
		Retorno prubaMapa7 = pruebaMapa.registrarPoste(333, 222, "A");
		Retorno prubaMapa2 = pruebaMapa.registrarPoste(444, 555, "B");
		Retorno prubaMapa3 = pruebaMapa.registrarPoste(111, 989, "C");
		Retorno prubaMapa4 = pruebaMapa.registrarPoste(544, 888, "D");
		Retorno prubaMapa5 = pruebaMapa.registrarPoste(544, 888, "H");
		
		System.out.println(prubaMapa1.resultado);
		System.out.println(prubaMapa7.resultado);
		System.out.println(prubaMapa2.resultado);
		System.out.println(prubaMapa3.resultado);
		System.out.println(prubaMapa4.resultado);
		System.out.println(prubaMapa5.resultado);
		
//		Grafo g = new Grafo(8, false);		
//		g.agregarVertice("A");
//		g.agregarVertice("B");
//		g.agregarVertice("C");
//		g.agregarVertice("D");
//		g.agregarVertice("E");
//		g.agregarVertice("F");
//		g.agregarVertice("G");
//		g.agregarVertice("H");
//	
//		g.agregarArista("A", "C", 2);
//		g.agregarArista("C", "F", 4);
//		g.agregarArista("A", "D", 2);
//		g.agregarArista("D", "F", 9);
//		g.agregarArista("F", "G", 3);
//		g.agregarArista("D", "H", 8);
//		g.agregarArista("H", "B", 1);		
//		g.agregarArista("G", "H", 7);
//		g.agregarArista("G", "E", 2);
//		g.agregarArista("E", "B", 4);
//		
//		int pruebaDijkstra = g.dijkstra("D", "C");
//		System.out.println(pruebaDijkstra);
		
	}

}
