package ft_melina;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SurvivalTwister {
    private static String[] REFUGIOS = {"Subterráneo", "Montaña", "Bosque"};
    private static String[] SUMINISTROS_CLAVE = {
            "Manta térmica", "Encendedor", "Comida enlatada",
            "Botiquín básico", "Kit de primeros auxilios", "Linterna",
            "Radio", "Filtro de agua", "Cobija", "Herramientas"
    };

    // Acertijos lógicos mejorados
    private static String[][] ACERTIJOS_LOGICOS = {
            {"Soy más alto que un edificio pero más liviano que una pluma, ¿qué soy?", "1) El humo", "2) Una nube", "3) El viento", "2"},
            {"Si me nombras, desaparezco. ¿Qué soy?", "1) El viento", "2) El silencio", "3) La sombra", "2"},
            {"Tengo ciudades, pero no casas; montañas, pero no árboles; agua, pero no peces. ¿Qué soy?", "1) Un mapa", "2) Un sueño", "3) Una pintura", "1"},
            {"Cuanto más quitas, más grande me hago. ¿Qué soy?", "1) Un agujero", "2) Una sombra", "3) El tiempo", "1"},
            {"Me ves una vez por minuto, dos veces en un momento, pero nunca en cien años. ¿Qué soy?", "1) La letra 'm'", "2) El sol", "3) La luna", "1"}
    };

    private static int MAX_SUMINISTROS = 5;

    public static void main(String[] args) {
        // Solicitar el nombre del usuario
        String nombreUsuario = JOptionPane.showInputDialog(null, "Por favor, introduce tu nombre:", "Bienvenido a Survival Twister", JOptionPane.QUESTION_MESSAGE);

        if (nombreUsuario != null && !nombreUsuario.isEmpty()) {
            jugar(nombreUsuario);
        } else {
            JOptionPane.showMessageDialog(null, "Debes ingresar un nombre para jugar.");
        }
    }

    private static void jugar(String nombreUsuario) {
        // Selección de refugio por el usuario
        String refugioSeleccionado = seleccionarRefugio();

        // Simular recolección de suministros por el usuario
        String[] inventarioUsuario = recolectarSuministros();

        // Evaluar si el refugio es seguro
        evaluarRefugio(nombreUsuario, inventarioUsuario);
    }

    // Método para seleccionar el refugio
    private static String seleccionarRefugio() {
        String seleccion = (String) JOptionPane.showInputDialog(null,
                "Elige un refugio para sobrevivir:",
                "Selección de Refugio",
                JOptionPane.QUESTION_MESSAGE,
                null,
                REFUGIOS,
                REFUGIOS[0]);

        if (seleccion == null || seleccion.isEmpty()) {
            seleccion = "Subterráneo"; // Opción predeterminada si el usuario no elige
        }

        JOptionPane.showMessageDialog(null, "Has elegido el refugio: " + seleccion);
        return seleccion;
    }

    // Método para recolectar los suministros basado en acertijos
    private static String[] recolectarSuministros() {
        String[] suministrosRecolectados = new String[MAX_SUMINISTROS];
        int cantidadSuministros = 0;
        Random random = new Random();

        // Crear una lista de acertijos disponibles
        List<int[]> acertijosDisponibles = new ArrayList<>();
        for (int i = 0; i < ACERTIJOS_LOGICOS.length; i++) {
            acertijosDisponibles.add(new int[]{i});
        }

        while (cantidadSuministros < MAX_SUMINISTROS && !acertijosDisponibles.isEmpty()) {
            // Seleccionar un suministro
            String suministroSeleccionado = (String) JOptionPane.showInputDialog(null,
                    "Selecciona un suministro (" + (cantidadSuministros + 1) + "/" + MAX_SUMINISTROS + "):",
                    "Recolección de Suministros",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    SUMINISTROS_CLAVE,
                    SUMINISTROS_CLAVE[0]);

            // Si el jugador ha seleccionado un suministro, realizar un acertijo
            if (suministroSeleccionado != null && !contieneSuministro(suministrosRecolectados, suministroSeleccionado)) {
                // Seleccionar un acertijo aleatorio de la lista de acertijos disponibles
                int indiceAcertijo = random.nextInt(acertijosDisponibles.size());
                int[] acertijoSeleccionado = acertijosDisponibles.get(indiceAcertijo);
                acertijosDisponibles.remove(indiceAcertijo); // Eliminar el acertijo para que no se repita

                String[] acertijo = ACERTIJOS_LOGICOS[acertijoSeleccionado[0]];
                String respuestaUsuario = JOptionPane.showInputDialog(null, acertijo[0] + "\n" + acertijo[1] + "\n" + acertijo[2] + "\n" + acertijo[3], "Acertijo Lógico", JOptionPane.QUESTION_MESSAGE);

                // Si la respuesta es correcta, se agrega el suministro
                if (respuestaUsuario != null && respuestaUsuario.equals(acertijo[4])) {
                    suministrosRecolectados[cantidadSuministros++] = suministroSeleccionado;
                    JOptionPane.showMessageDialog(null, "¡Correcto! Has agregado '" + suministroSeleccionado + "' a tu inventario.");
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrecto. No puedes agregar '" + suministroSeleccionado + "' a tu inventario.");
                }
            } else if (suministroSeleccionado == null) {
                break; // Si el jugador cancela, termina la selección
            }
        }

        JOptionPane.showMessageDialog(null, "Has recolectado los siguientes suministros: " + String.join(", ", suministrosRecolectados));
        return suministrosRecolectados;
    }

    // Método para evaluar si el refugio es seguro comparando los suministros
    private static void evaluarRefugio(String nombreUsuario, String[] inventarioUsuario) {
        Random random = new Random();
        String suministroClaveNecesario = SUMINISTROS_CLAVE[random.nextInt(SUMINISTROS_CLAVE.length)];
        boolean esSeguro = contieneSuministro(inventarioUsuario, suministroClaveNecesario);
        String mensajeFinal = esSeguro ?
                "¡Felicidades, " + nombreUsuario + "! Has recolectado el suministro clave '" + suministroClaveNecesario + "' y sobreviviste." :
                "Lo sentimos, " + nombreUsuario + ". No recolectaste el suministro clave '" + suministroClaveNecesario + "'. No sobreviviste al twister Camarada 😿.";
        JOptionPane.showMessageDialog(null, mensajeFinal);
    }

    // Método para verificar si el suministro ya está en el inventario
    private static boolean contieneSuministro(String[] suministros, String suministro) {
        for (String s : suministros) {
            if (s != null && s.equals(suministro)) {
                return true;
            }
        }
        return false;
    }
}
