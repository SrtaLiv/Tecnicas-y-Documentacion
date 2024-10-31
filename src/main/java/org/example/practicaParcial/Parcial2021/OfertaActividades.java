package org.example.practicaParcial.Parcial2021;

import java.util.ArrayList;

public class OfertaActividades {
	static ArrayList<Actividad> nomina;
	
	static void NuevaActividad(Actividad act) {
		if(nomina==null) nomina = new ArrayList<Actividad>();
		if(nomina.indexOf(act)<0) nomina.add(act);
	}
	
	static void BorrarActividad(Actividad act) {
		
		if(nomina.indexOf(act)<0) nomina.remove(act);
	}
	
	static int CantidadActividades() {
		return nomina.size();
	}

	static ArrayList<Actividad>  GetNomina() {
	return nomina;
	}
	
}