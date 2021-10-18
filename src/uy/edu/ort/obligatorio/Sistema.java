package uy.edu.ort.obligatorio;

import uy.edu.ort.obligatorio.Retorno.Resultado;
import uy.edu.ort.obligatorio.ab.AbbObrero;
import uy.edu.ort.obligatorio.grafo.Grafo;
import uy.edu.ort.obligatorio.obrero.Obrero;

public class Sistema implements ISistema {
	
	private Grafo mapa;
	
	private AbbObrero obreros;
	
	public Grafo getMapa() {
		return mapa;
	}

	public void setMapa(Grafo mapa) {
		this.mapa = mapa;
	}
	
	public void setObreros(AbbObrero obreros) {
		this.obreros = obreros;
	}

	@Override
	public Retorno inicializarSistema(int maxPuntos) {
		if(maxPuntos <= 0) {
			return new Retorno(Resultado.ERROR_1); 
		}
		this.setMapa(new Grafo(maxPuntos));
		this.setObreros(new AbbObrero(null));
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno destruirSistema() {
		this.setMapa(null);
		this.setObreros(null);
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno registrarObrero(String cedula, String nombre) {
		if(!isValidCedula(cedula)) {
			return new Retorno(Resultado.ERROR_1);
		}
		if(this.buscarObrero(cedula).resultado.equals(Resultado.OK)) {
			return new Retorno(Resultado.ERROR_2);
		}
		obreros.insertar(new Obrero(cedula, nombre));
		return new Retorno(Resultado.OK);
	}
	
	private boolean isValidCedula(String cedula) {
		return true;
	}

	@Override
	public Retorno buscarObrero(String cedula) {
		if(!isValidCedula(cedula)) {
			return new Retorno(Resultado.ERROR_1);
		}
		return obreros.pertenece(cedula);
	}

	@Override
	public Retorno listarObreros() {
		return new Retorno(Resultado.OK, 0 , this.obreros.listarAsc());
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
