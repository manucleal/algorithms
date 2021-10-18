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
		System.out.println("######### FIN PRUEBA REGISTRO #########");
		System.out.println();
		System.out.println("######### INICIO PRUEBA BUSCAR OBRERO #########");
		System.out.println();
		
		Retorno pruebaBuscarObrero = pruebaObrero.buscarObrero("4.765.333-1");
		
		System.out.println(pruebaBuscarObrero.resultado);
		System.out.println(pruebaBuscarObrero.valorEntero);
		System.out.println(pruebaBuscarObrero.valorString);
		
		System.out.println();
		System.out.println("######### FIN PRUEBA BUSCAR OBRERO #########");
		System.out.println();
		
		System.out.println();
		System.out.println("######### INICIO PRUEBA LISTAR OBREROS CRECIENTE #########");
		System.out.println();
		
		Retorno pruebaListarObrerosCreciente = pruebaObrero.listarObreros();
		System.out.println(pruebaListarObrerosCreciente.valorString);
		
		System.out.println();
		System.out.println("######### FIN PRUEBA LISTAR OBREROS CRECIENTE #########");
		System.out.println();
		
	}

}
