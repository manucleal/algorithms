package uy.edu.ort.obligatorio;

public class Application {

	public static void main(String[] args) {
		manualTest();
	}
	
	private static void manualTest() {
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
		
		System.out.println("######### INICIO PRUEBA REGISTRAR TRAMOS #########");
		
		prubaMapa1 = pruebaMapa.registrarTramo(333, 222, 444, 555, 100); // De A a B
		prubaMapa7 = pruebaMapa.registrarTramo(544, 888, 333, 222, 150); // De D a A
		prubaMapa2 = pruebaMapa.registrarTramo(444, 555, 111, 989, 130); // De B a C
		prubaMapa3 = pruebaMapa.registrarTramo(111, 989, 544, 888, 50); // De C a D
		prubaMapa4 = pruebaMapa.registrarTramo(544, 888, 333, 222, 200); // De D a A
		
		System.out.println(prubaMapa1.resultado);
		System.out.println(prubaMapa7.resultado);
		System.out.println(prubaMapa2.resultado);
		System.out.println(prubaMapa3.resultado);
		System.out.println(prubaMapa4.resultado);
		System.out.println(prubaMapa5.resultado);
		
//		int pruebaDijkstra = g.dijkstra("D", "C");
//		System.out.println(pruebaDijkstra);
	}
}
