package modelo;

public class Entorno {

	private CondicionAtmosferica condicionAtmosferica;
	private TipoTerreno tipoTerreno;
	private MomentoDia momentoDia;
	
	
	public Entorno(CondicionAtmosferica condicionAtmosferica, TipoTerreno tipoTerreno, MomentoDia momentoDia) {
		this.condicionAtmosferica = condicionAtmosferica;
		this.tipoTerreno = tipoTerreno;
		this.momentoDia = momentoDia;
	}
	
	//MÉTODOS PARA CALCULAR LAS BONIFICACIONES/PENALIZACIONES TOTALES
}
