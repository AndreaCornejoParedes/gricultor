package Default;

import java.util.Date;

public abstract class Comprobante {
	private String numeroComprobante;
	private Date fechaEmision;
	private String tipoDoc;
	private Double MontoTotal;
	public Comprobante() {
		this.numeroComprobante= "0";
		this.fechaEmision 	= null;
		this.tipoDoc = "1";
		this.MontoTotal = 0.0;
	}
	
	public String getNumeroComprobante() {
		return numeroComprobante;
	}

	public void setNumeroComprobante(String numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public Double getMontoTotal() {
		return MontoTotal;
	}

	public void setMontoTotal(Double montoTotal) {
		MontoTotal = montoTotal;
	}

	public abstract void agregarComprobante();
	public abstract void EliminarComprobante();
	
	public String toString() {
		return "=========== Comprobante ===========" +
				"\nNro:	" + this.getNumeroComprobante()+
				"\nFecha de emision: "+this.fechaEmision.toString()+
				"\nTipo documento: "+this.getTipoDoc() + 
				"\nMonto total: "+this.getMontoTotal();
		
	}
}
