package uy.edu.ort.obligatorio;

import uy.edu.ort.obligatorio.Retorno.Resultado;
import uy.edu.ort.obligatorio.obrero.Obrero;
import uy.edu.ort.obligatorio.ab.AbbObrero;
import uy.edu.ort.obligatorio.mapa.Mapa;

public class Sistema implements ISistema {
	
	private Mapa mapa;
	
	private AbbObrero obreros;
	
	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
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
		this.setMapa(new Mapa(maxPuntos));
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
		if(this.mapa.esLleno()) {
			return new Retorno(Resultado.ERROR_1);
		}
		if(this.mapa.existePoste(coordX, coordY)) {
			return new Retorno(Resultado.ERROR_2);
		}
		this.mapa.agregarPoste(coordX, coordY, nombre);
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno registrarTramo(double coordXi, double coordYi, double coordXf, double coordYf, double metros) {
		if (metros <= 0) {
			return new Retorno(Resultado.ERROR_1);
		}
		if (!this.mapa.existePoste(coordXi, coordYi) || !this.mapa.existePoste(coordXf, coordYf)) {
			return new Retorno(Resultado.ERROR_2);
		}
		if (this.mapa.existeTramo(coordXi, coordYi, coordXf, coordYf)) {
			return new Retorno(Resultado.ERROR_3);
		}
		this.mapa.agregarTramo(coordXi, coordYi, coordXf, coordYf, metros);
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno actualizarTramo(double coordXi, double coordYi, double coordXf, double coordYf, double metros,
			Estado estado) {
		if (metros <= 0 || estado == null) {
			return new Retorno(Resultado.ERROR_1);
		}
		if (!this.mapa.existePoste(coordXi, coordYi) || !this.mapa.existePoste(coordXf, coordYf)) {
			return new Retorno(Resultado.ERROR_2);
		}
		if (!this.mapa.existeTramo(coordXi, coordYi, coordXf, coordYf)) {
			return new Retorno(Resultado.ERROR_3);
		}
		this.mapa.actualizarTramo(coordXi, coordYi, coordXf, coordYf, metros, estado);
		return new Retorno(Resultado.OK);
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
