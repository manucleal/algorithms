package uy.edu.ort.obligatorio;

import uy.edu.ort.obligatorio.ISistema.Estado;

public class Application {

	public static void main(String[] args) {
		// manualTestConDebug();
		manualTest();
	}
	
	private static void manualTestConDebug() {
		Sistema pruebaObrero = new Sistema();
		pruebaObrero.inicializarSistema(1);
		
		System.out.println("######### INICIO PRUEBA REGISTAR OBRERO #########");
		System.out.println();
		
		Retorno p1 = pruebaObrero.registrarObrero("765.789-0", "Fausto Perillo");
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
		
		Retorno pruebaMapa1 = pruebaMapa.registrarPoste(333, 222, "A");
		Retorno pruebaMapa7 = pruebaMapa.registrarPoste(333, 222, "A");
		Retorno pruebaMapa2 = pruebaMapa.registrarPoste(444, 555, "B");
		Retorno pruebaMapa3 = pruebaMapa.registrarPoste(111, 989, "C");
		Retorno pruebaMapa4 = pruebaMapa.registrarPoste(544, 888, "D");
		Retorno pruebaMapa5 = pruebaMapa.registrarPoste(544, 888, "H");
		
		System.out.println(pruebaMapa1.resultado);
		System.out.println(pruebaMapa7.resultado);
		System.out.println(pruebaMapa2.resultado);
		System.out.println(pruebaMapa3.resultado);
		System.out.println(pruebaMapa4.resultado);
		System.out.println(pruebaMapa5.resultado);
		
		System.out.println();
		System.out.println("######### INICIO PRUEBA REGISTRAR TRAMOS #########");
		System.out.println();

		pruebaMapa1 = pruebaMapa.registrarTramo(333, 222, 444, 555, 100); // De A a B
		pruebaMapa7 = pruebaMapa.registrarTramo(544, 888, 333, 222, 150); // De D a A
		pruebaMapa2 = pruebaMapa.registrarTramo(444, 555, 111, 989, 130); // De B a C
		pruebaMapa3 = pruebaMapa.registrarTramo(111, 989, 544, 888, 50); // De C a D
		pruebaMapa4 = pruebaMapa.registrarTramo(544, 888, 333, 222, 200); // De D a A ERROR
		
		System.out.println(pruebaMapa1.resultado);
		System.out.println(pruebaMapa7.resultado);
		System.out.println(pruebaMapa2.resultado);
		System.out.println(pruebaMapa3.resultado);
		System.out.println(pruebaMapa4.resultado);
		
		System.out.println();
		System.out.println("######### INICIO PRUEBA CUADRILLA DE AUDITORIA #########");
		System.out.println();
		
		Retorno priebaCuadrilla = pruebaMapa.cuadrillaAuditoria(333, 222, 1);
		System.out.println(priebaCuadrilla.valorString);
		

		System.out.println();
		System.out.println("######### INICIO PRUEBA CUADRILLA DE AUDITORIA #########");
		System.out.println();
		
		
		Retorno pruebaDijkstra = pruebaMapa.caminoMinimoEnBuenEstado(333, 222, 111, 989);
		System.out.println(pruebaDijkstra.resultado);
		System.out.println(pruebaDijkstra.valorEntero);
		System.out.println(pruebaDijkstra.valorString);
		
		System.out.println("Camino entre A y D");
		pruebaDijkstra = pruebaMapa.caminoMinimoEnBuenEstado(333, 222, 544, 888);
		System.out.println(pruebaDijkstra.resultado);
		System.out.println(pruebaDijkstra.valorEntero);
		System.out.println(pruebaDijkstra.valorString);
		
		Retorno pruebaMalEstado = pruebaMapa.actualizarTramo(333, 222, 544, 888, 150, Estado.MALO);
		System.out.println(pruebaMalEstado.resultado);
		
		System.out.println("Repito camino entre A y D");
		pruebaDijkstra = pruebaMapa.caminoMinimoEnBuenEstado(333, 222, 544, 888);
		System.out.println(pruebaDijkstra.resultado);
		System.out.println(pruebaDijkstra.valorEntero);
		System.out.println(pruebaDijkstra.valorString);
	}
	
	private static void manualTest() {
		Sistema pruebaObrero = new Sistema();
		pruebaObrero.inicializarSistema(1);
		
		pruebaObrero.registrarObrero("765.789-0", "Fausto Perillo");
		pruebaObrero.registrarObrero("4.690.278-1", "Emanuel Coitiño");
		pruebaObrero.registrarObrero("4.690.278-1", "Emanuel Coitiño");
		pruebaObrero.registrarObrero("4.868.467-1", "Pablo Ingold");
		pruebaObrero.registrarObrero("4.765.789-1", "Pablo Ingold");
		pruebaObrero.registrarObrero("4.765.333-1", "Fernanda Serna");
		
		pruebaObrero.buscarObrero("4.765.333-1");
		
		pruebaObrero.listarObreros();
		
		Sistema pruebaMapa = new Sistema();
		pruebaMapa.inicializarSistema(4);
		
		pruebaMapa.registrarPoste(333, 222, "A");
		pruebaMapa.registrarPoste(333, 222, "A");
		pruebaMapa.registrarPoste(444, 555, "B");
		pruebaMapa.registrarPoste(111, 989, "C");
		pruebaMapa.registrarPoste(544, 888, "D");
		pruebaMapa.registrarPoste(544, 888, "H");

		pruebaMapa.registrarTramo(333, 222, 444, 555, 100); // De A a B
		pruebaMapa.registrarTramo(544, 888, 333, 222, 150); // De D a A
		pruebaMapa.registrarTramo(444, 555, 111, 989, 130); // De B a C
		pruebaMapa.registrarTramo(111, 989, 544, 888, 50); // De C a D
		pruebaMapa.registrarTramo(544, 888, 333, 222, 200); // De D a A ERROR
		
		pruebaMapa.cuadrillaAuditoria(333, 222, 1);
		
		
		pruebaMapa.caminoMinimoEnBuenEstado(333, 222, 111, 989);
		pruebaMapa.caminoMinimoEnBuenEstado(333, 222, 544, 888);
		
		pruebaMapa.actualizarTramo(333, 222, 544, 888, 150, Estado.MALO);
		pruebaMapa.caminoMinimoEnBuenEstado(333, 222, 544, 888);
	}
}
