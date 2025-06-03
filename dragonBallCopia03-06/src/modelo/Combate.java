package modelo;

import java.util.Scanner;

public class Combate {

	private Protagonista protagonista;
	private PersonajeCombatiente enemigo;
	private CondicionAtmosferica condicionAtmos;
	private TipoTerreno terreno;
	private MomentoDia momentoDia;

	// Constructor
	public Combate(Protagonista protagonista, PersonajeCombatiente enemigo, Juego juego) {
		this.protagonista = protagonista;
		this.enemigo = enemigo;
		this.condicionAtmos = juego.getCondicionesAtmosfericas().get((int)(Math.random() * juego.getCondicionesAtmosfericas().size()));
		this.terreno = juego.getTiposTerreno().get((int)(Math.random() * juego.getTiposTerreno().size()));
		this.momentoDia = juego.getMomentosDia().get((int)(Math.random() * juego.getMomentosDia().size()));
		}

	private int calcularBonusAtaque() {
		return condicionAtmos.getBonusAtaque() + terreno.getBonusAtaque() + momentoDia.getBonusAtaque();
	}

	private int calcularBonusDefensa() {
		return condicionAtmos.getBonusDefensa() + terreno.getBonusDefensa() + momentoDia.getBonusDefensa();
	}

	public String determinarTipoImpacto() {
		int random = (int) (Math.random() * 100) + 1;

		if (random <= 60) {
			return "total";
		} else if (random <= 90) {
			return "parcial";
		} else {
			return "fallo";
		}
	}

	private int obtenerDanhoPorImpacto(Ataque ataque) {
		String tipoImpacto = determinarTipoImpacto();

		switch (tipoImpacto.toLowerCase()) {
		case "total":
			return ataque.getDanho_total();
		case "parcial":
			return ataque.getDanho_parcial();
		case "fallo":
			return ataque.getDanho_fallo();
		default:
			System.out.println("Tipo de impacto inválido");
			return 0;
		}
	}

	private Ataque elegirAtaqueJugador() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Elige un ataque");

		for (int i = 0; i < protagonista.getAtaque().size(); i++) {
			Ataque ataque = protagonista.getAtaque().get(i);
			System.out.println(i + ". " + ataque.getNombre());
		}

		int eleccion = -1;
		boolean valido = false;

		if (sc.hasNextInt()) {
			eleccion = sc.nextInt();
			sc.nextLine();

			if (eleccion >= 0 && eleccion < protagonista.getAtaque().size()) {
				valido = true;
			} else {
				System.out.println("Número fuera de rango.");
			}

		} else {
			System.out.println("Entrada inválida. Intenta de nuevo.");
			sc.nextLine();
		}

		return protagonista.getAtaque().get(eleccion);
	}

	// ENEMIGO HACE ATAQUE RANDOM
	private Ataque elegirAtaqueAleatorio(PersonajeCombatiente enemigo) {
		int numAtaques = enemigo.getAtaque().size();
		int random = (int) (Math.random() * numAtaques);
		return enemigo.getAtaque().get(random);
	}

	// CALCULAR DAÑO +/- BONUS
	public int calcularDanhoTotal(Ataque ataque) {
		int danhoBase = obtenerDanhoPorImpacto(ataque);
		int bonusAtaque = calcularBonusAtaque();
		int danhoFinal = danhoBase + bonusAtaque;

		System.out.println("Daño base: " + danhoBase + " | Bonus ataque: " + bonusAtaque);
		System.out.println("Daño final infligido: " + Math.max(1, danhoFinal));

		return Math.max(1, danhoFinal);
	}

	public void testCalculoDanhoJugador() {
		Ataque ataqueElegido = elegirAtaqueJugador();
		int danhoFinal = calcularDanhoTotal(ataqueElegido);

		System.out.println("=== Resultado de prueba ===");
		System.out.println("Ataque usado: " + ataqueElegido.getNombre());
		System.out.println("Daño final calculado: " + danhoFinal);
	}

	// CALCULAR ATAQUE - DEFENSA
	private int calcularDanhoNeto(int danhoBase, int bonusAtaque, int bonusDefensa) {
		int danhoNeto = danhoBase + bonusAtaque - bonusDefensa;
		if (danhoNeto < 0) {
			return 0;
		} else {
			return danhoNeto;
		}

	}

	// RESTAR VIDA
	private void restarVida(PersonajeCombatiente defensor, int danho) {
		int vidaActual = defensor.getVida();
		int vidaRestante;

		if (vidaActual - danho < 0) {
			vidaRestante = 0;
		} else {
			vidaRestante = vidaActual - danho;
		}

		defensor.setVida(vidaRestante);
		System.out.println(defensor.getNombre() + " ha recibido " + danho + " de daño. Vida restante: " + vidaRestante);
	}

	// ATACA EL RPOTAGONISTA
	public void turnoProtagonista() {
		System.out.println("\n Es tu turno ---");
		System.out.println("Vida actual del enemigo: " + enemigo.getVida());

		Ataque ataque = elegirAtaqueJugador();

		int danhoBase = obtenerDanhoPorImpacto(ataque);

		int bonusAtaque = calcularBonusAtaque();

		int bonusDefensa = calcularBonusDefensa();

		int danhoFinal = calcularDanhoNeto(danhoBase, bonusAtaque, bonusDefensa);

		restarVida(enemigo, danhoFinal);
	}

	// ATACA EL ENEMIGO(AUTOMÁTICO)
	public void turnoEnemigo() {
		System.out.println("\n--- Turno de " + enemigo.getNombre() + " ---");
		System.out.println("Vida actual del jugador: " + protagonista.getVida());

		Ataque ataque = elegirAtaqueAleatorio(enemigo);

		int danhoBase = obtenerDanhoPorImpacto(ataque);

		int bonusAtaque = calcularBonusAtaque();
		int bonusDefensa = calcularBonusDefensa();

		int danhoFinal = calcularDanhoNeto(danhoBase, bonusAtaque, bonusDefensa);

		restarVida(protagonista, danhoFinal);
	}

	// IMPRIMIR VIDA AMBOS
	private void imprimirVida() {
		System.out.println("\n====== ESTADO ACTUAL ======");
		System.out.println(protagonista.getNombre() + " - Vida: " + protagonista.getVida());
		System.out.println(enemigo.getNombre() + " - Vida: " + enemigo.getVida());
		System.out.println("===========================\n");
	}

	// MÉTODO PARA COMPROBAR VIDAS
	private boolean finCombate() {
		if (protagonista.getVida() <= 1) {
			return true;
		}
		if (enemigo.getVida() <= 1) {
			return true;
		}
		return false;
	}

	// COMBATE
	public void combatir() {
		System.out.println("¡Comienza el combate!/n" + "Entorno: " + condicionAtmos.getNombre() + ", "
				+ terreno.getNombre() + ", " + momentoDia.getNombre());
		while (!finCombate()) {
			imprimirVida();
			// Turno del jugador
			turnoProtagonista();
			// Solo se ejecuta el turno del enemigo si aún sigue el combate
			if (!finCombate()) {
				turnoEnemigo();
			}
		}
		if (protagonista.getVida() <= 0) {
			System.out.println(enemigo.getNombre() + " te ha derrotado");
		} else {
			System.out.println("Has derrotado a " + enemigo.getNombre());
		}

	}

}
