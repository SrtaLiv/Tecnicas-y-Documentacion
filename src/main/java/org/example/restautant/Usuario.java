package org.example.restautant;
import java.util.Date;

public class Usuario {
static int nextID;
int id;
String nombreYApellido;
int tipoUsuario;
float saldoCuenta;
Date ultimaRecarga;
String email;
public Usuario(String nombreYApellido, int tipoUsuario, float saldoCuenta,String email) {
	super();
	this.nombreYApellido = nombreYApellido;
	this.tipoUsuario = tipoUsuario;
	this.saldoCuenta = saldoCuenta;
	this.email=email;
}

public void cargarCredito(float cuanto) {
	saldoCuenta+=cuanto;
	
}
float descontarSaldo(float cuanto) throws SinSaldoException {
	if((saldoCuenta-cuanto)<0) throw new SinSaldoException();
	else
		saldoCuenta-= cuanto;
	return saldoCuenta;
	
}
float getSaldo() {
	return saldoCuenta;
}

	public static int getNextID() {
		return nextID;
	}

	public static void setNextID(int nextID) {
		Usuario.nextID = nextID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public float getSaldoCuenta() {
		return saldoCuenta;
	}

	public void setSaldoCuenta(float saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}

	public Date getUltimaRecarga() {
		return ultimaRecarga;
	}

	public void setUltimaRecarga(Date ultimaRecarga) {
		this.ultimaRecarga = ultimaRecarga;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
