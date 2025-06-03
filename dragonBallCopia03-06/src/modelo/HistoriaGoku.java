package modelo;

import java.util.Scanner;
import java.sql.SQLException; // Necesario para manejar excepciones de la BDD

public class HistoriaGoku {

    private Protagonista protagonista;
    private Juego juego; // Para acceder a enemigos, secundarios, entorno, etc.
    private Scanner sc = new Scanner(System.in);
    private Partida partidaActual; // Para actualizar la puntuación y el final de la partida

    public HistoriaGoku(Protagonista protagonista, Juego juego, Partida partidaActual) {
        this.protagonista = protagonista;
        this.juego = juego;
        this.partidaActual = partidaActual;
    }

    public void iniciar() throws SQLException { // Agregamos throws SQLException
        System.out.println("🌟 Comienza la historia de Goku...\n");
        escenaMontajeDeEntrenamiento();
        decisionDeEntrenamiento();
        escenaPrimerEncuentro();
        escenaCombateRaditz();
        // ... más escenas y decisiones
        finalDeLaHistoria();
    }

    private void escenaMontajeDeEntrenamiento() {
        System.out.println("🌄 Goku se levanta al amanecer, listo para su riguroso entrenamiento. Sabe que el camino para proteger la Tierra es largo y lleno de desafíos. Pasa días y noches perfeccionando sus técnicas y aumentando su fuerza Ki.");
        System.out.println("💥 Después de un arduo entrenamiento, Goku siente un aumento en su poder.");
        protagonista.setVida(protagonista.getVida() + 20); // Goku gana vida por entrenar
        partidaActual.sumarPuntos(50); // Gana puntos por el entrenamiento
        System.out.println("¡Goku ha aumentado su vida a " + protagonista.getVida() + "!");
        System.out.println("Puntuación actual: " + partidaActual.getPuntuacion());
        System.out.println("----------------------------------------------\n");
    }

    private void decisionDeEntrenamiento() {
        System.out.println("🤔 Sientes que podrías entrenar aún más, pero tu cuerpo ya está cansado.");
        System.out.println("¿Qué decides hacer?");
        System.out.println("1. Seguir entrenando hasta el límite (riesgo de agotamiento, pero mayor recompensa)");
        System.out.println("2. Descansar y reponer fuerzas");

        String eleccion = "";
        while (!eleccion.equals("1") && !eleccion.equals("2")) {
            System.out.print("Tu elección: ");
            eleccion = sc.nextLine();
            if (!eleccion.equals("1") && !eleccion.equals("2")) {
                System.out.println("Opción no válida. Por favor, introduce 1 o 2.");
            }
        }

        if (eleccion.equals("1")) {
            System.out.println("\n💪 Decides seguir entrenando, llevando tu cuerpo al límite. Es un entrenamiento brutal, pero sientes un gran salto en tu poder.");
            protagonista.setVida(protagonista.getVida() + 30); // Mayor recompensa
            partidaActual.sumarPuntos(100);
            System.out.println("¡Goku ha aumentado su vida a " + protagonista.getVida() + " y ha ganado 100 puntos!");
            System.out.println("Puntuación actual: " + partidaActual.getPuntuacion());
        } else {
            System.out.println("\n😴 Decides descansar. Es importante reponer energías para lo que venga.");
            protagonista.setVida(protagonista.getVida() + 10); // Menor recompensa, pero sin riesgo
            partidaActual.sumarPuntos(25);
            System.out.println("¡Goku ha recuperado vida y ahora tiene " + protagonista.getVida() + " puntos de vida!");
            System.out.println("Puntuación actual: " + partidaActual.getPuntuacion());
        }
        System.out.println("----------------------------------------------\n");
    }

    private void escenaPrimerEncuentro() {
        System.out.println("🚀 De repente, un objeto desconocido se aproxima a la Tierra a gran velocidad. ¡Es una nave espacial!");
        System.out.println("Un misterioso guerrero Saiyajin emerge de ella. Su nombre es Raditz y ha venido a buscar a su hermano...");
        System.out.println("¡Y ese hermano eres tú, Kakarotto!");
        System.out.println("Raditz te exige unirte a él para conquistar planetas. ¿Qué haces?");
        System.out.println("1. Negarte rotundamente y proteger la Tierra.");
        System.out.println("2. Simular que aceptas para infiltrarte en sus planes.");

        String eleccion = "";
        while (!eleccion.equals("1") && !eleccion.equals("2")) {
            System.out.print("Tu elección: ");
            eleccion = sc.nextLine();
            if (!eleccion.equals("1") && !eleccion.equals("2")) {
                System.out.println("Opción no válida. Por favor, introduce 1 o 2.");
            }
        }

        if (eleccion.equals("1")) {
            System.out.println("\n✊ Goku: ¡Nunca me uniré a ti para hacer el mal! ¡Protegeré la Tierra a toda costa!");
            // Esto podría llevar a un combate más difícil o inmediato
        } else {
            System.out.println("\n😈 Goku (fingiendo): Entendido, hermano. Me uniré a ti. Solo dame un momento para despedirme...");
            System.out.println("Raditz, desconfiado pero arrogante, te da un corto plazo. Usas este tiempo para preparar un plan.");
            partidaActual.sumarPuntos(50); // Puntos por estrategia
            System.out.println("Puntuación actual: " + partidaActual.getPuntuacion());
            // Esto podría darte alguna ventaja en el siguiente combate, como vida extra o un bonus de ataque.
        }
        System.out.println("----------------------------------------------\n");
    }

    private void escenaCombateRaditz() throws SQLException {
        System.out.println("💥 ¡Raditz se impacienta y ataca! ¡Prepárate para tu primer gran combate!");
        PersonajeCombatiente raditz = juego.buscarEnemigoPorNombre("Raditz"); // Asegúrate de que "Raditz" exista en tu BDD
        if (raditz != null) {
            System.out.println("¡Te enfrentas a " + raditz.getNombre() + "!");
            Combate combate = new Combate(protagonista, raditz, juego);
            combate.combatir();

            if (protagonista.getVida() > 0) {
                System.out.println("🎉 ¡Has derrotado a Raditz! La Tierra está a salvo, por ahora...");
                partidaActual.sumarPuntos(200); // Puntos por ganar combate
                System.out.println("Puntuación actual: " + partidaActual.getPuntuacion());
                // Podrías añadir lógica para la muerte de Goku y un final de partida aquí
            } else {
                System.out.println("💀 Goku ha caído ante Raditz... El futuro de la Tierra es incierto.");
                partidaActual.setFinalPartida("Derrota");
                // Aquí podrías implementar un método para guardar la partida y salir.
                return; // Termina la historia si Goku muere
            }
        } else {
            System.out.println("Error: No se encontró a Raditz en la base de datos de enemigos. Asegúrate de que el nombre coincida.");
            // Manejar el error, quizás terminar la historia o cargar un enemigo por defecto.
        }
        System.out.println("----------------------------------------------\n");
    }

    // Aquí irían más escenas, siguiendo la trama de Dragon Ball Z:
    // - Entrenamiento con Kaiosama
    // - Llegada de Nappa y Vegeta
    // - Viaje a Namek
    // - Freezer, etc.

    private void finalDeLaHistoria() {
        System.out.println("✨ Después de innumerables batallas y sacrificios, Goku ha alcanzado su máximo poder y ha protegido la Tierra y el universo de innumerables amenazas.");
        System.out.println("¡La historia de Goku concluye, pero su leyenda perdurará para siempre!");
        partidaActual.setFinalPartida("Victoria");
        partidaActual.sumarPuntos(500); // Puntos extra por completar la historia
        System.out.println("Puntuación final de la partida: " + partidaActual.getPuntuacion());
        // Aquí podrías guardar la partida en la BDD a través de DaoPartida
    }
}