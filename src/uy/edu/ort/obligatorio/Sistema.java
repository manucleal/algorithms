package uy.edu.ort.obligatorio;

import uy.edu.ort.obligatorio.Retorno.Resultado;

public class Sistema implements ISistema {

	@Override
	public Retorno inicializarSistema(int maxPuntos) {
		System.out.println( "----------------------------- Testeo --------------------------------");
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno destruirSistema() {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarObrero(String cedula, String nombre) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno buscarObrero(String cedula) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno listarObreros() {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarPoste(double coordX, double coordY, String nombre) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarTramo(double coordXi, double coordYi, double coordXf, double coordYf, double metros) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno actualizarTramo(double coordXi, double coordYi, double coordXf, double coordYf, double metros,
			Estado estado) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno cuadrillaAuditoria(double coordXi, double coordYi, int cantTramosMaximo) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno caminoMinimoEnBuenEstado(double coordXi, double coordYi, double coordXf, double coordYf) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

}
