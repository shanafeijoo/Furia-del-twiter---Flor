/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ft_florencia;

import java.util.Random;
import javax.swing.JOptionPane;

public class JuegoTwister {

    public static String[] refugios = {"Subterráneo", "En las Montañas", "En el Bosque"};
    public static String[] suministros_clave = {
        "Manta termica", "Encendedor", "Comida enlatada", "Botiquin basico", "Kit de primeros auxilios", "Linterna", "Radio", "Filtro de agua", "Cobija", "Herramientas"};
    public static String[] inventario_usuario = new String[5];
    public static int cantidadSuministros = 0;
    public static Random random = new Random();
    public static int furia_del_twister;
    public static boolean es_seguro = false;
    public static int diasSuperados = 0;
    public static final int diasNecesarios = 5;

    public static void mostrarMenu() {
        boolean opcionValida = false;

        while (!opcionValida) {
            String menu = "Seleccione donde quieres refugiarte:\n";
            for (int i = 0; i < refugios.length; i++) {
                menu += (i + 1) + ". " + refugios[i] + "\n";
            }

            String opcionStr = JOptionPane.showInputDialog(menu);

            if (opcionStr.equals("0")) {
                
            } else if (opcionStr.equals("1") || opcionStr.equals("2") || opcionStr.equals("3")) {
                JOptionPane.showMessageDialog(null, "Has seleccionado el refugio: " + refugios[Integer.parseInt(opcionStr) - 1]);
                opcionValida = true;
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida. Intenta nuevamente.");
            }
        }
    }

    public static void recolectarSuministros() {
        while (cantidadSuministros < inventario_usuario.length) {
            String listaSuministros = "Lista de suministros disponibles:\n";
            for (int i = 0; i < suministros_clave.length; i++) {
                listaSuministros += (i + 1) + ". " + suministros_clave[i] + "\n";
            }

            String inventarioActual = "Inventario actual:\n";
            for (int i = 0; i < cantidadSuministros; i++) {
                inventarioActual += "- " + inventario_usuario[i] + "\n";
            }

            String mensaje = listaSuministros + "\n" + inventarioActual;
            String suministroSeleccionadoStr = JOptionPane.showInputDialog(mensaje + "Ingresa el número del suministro que deseas recolectar (o 0 para terminar):");
            int suministroSeleccionado = Integer.parseInt(suministroSeleccionadoStr);

            if (suministroSeleccionado == 0) {
                break;
            }

            if (suministroSeleccionado >= 1 && suministroSeleccionado <= suministros_clave.length) {
                inventario_usuario[cantidadSuministros] = suministros_clave[suministroSeleccionado - 1];
                cantidadSuministros++;
                JOptionPane.showMessageDialog(null, "Suministro recolectado: " + suministros_clave[suministroSeleccionado - 1]);

                if (cantidadSuministros == inventario_usuario.length) {
                    JOptionPane.showMessageDialog(null, "¡Tu inventario está lleno! Puedes descartar un suministro que no necesites. Si prefieres no descartar nada, selecciona 0 para continuar.");
                    descartarSuministro();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida. Intenta nuevamente.");
            }
        }

        String inventarioFinal = "Inventario del usuario:\n";
        for (int i = 0; i < cantidadSuministros; i++) {
            inventarioFinal += "- " + inventario_usuario[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, inventarioFinal);

        verificarVictoria();
    }

    public static void verificarVictoria() {
        if (diasSuperados >= diasNecesarios) {
            JOptionPane.showMessageDialog(null, "¡Felicidades! Has sobrevivido " + diasSuperados + " días y has ganado el juego.");
        }
    }

    public static void descartarSuministro() {
        while (true) {
            String inventarioActual = "Inventario actual:\n";
            for (int i = 0; i < cantidadSuministros; i++) {
                inventarioActual += (i + 1) + ". " + inventario_usuario[i] + "\n";
            }
            String suministroADescartarStr = JOptionPane.showInputDialog(inventarioActual + "Ingresa el número del suministro que deseas descartar (0 para cancelar):");
            int suministroADescartar = Integer.parseInt(suministroADescartarStr);

            if (suministroADescartar == 0) {
                JOptionPane.showMessageDialog(null, "Cancelaste la acción de descartar.");
                break;
            }

            if (suministroADescartar >= 1 && suministroADescartar <= cantidadSuministros) {
                JOptionPane.showMessageDialog(null, "Has descartado: " + inventario_usuario[suministroADescartar - 1]);

                for (int i = suministroADescartar - 1; i < cantidadSuministros - 1; i++) {
                    inventario_usuario[i] = inventario_usuario[i + 1];
                }
                cantidadSuministros--;
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida. Intenta nuevamente.");
            }
        }
    }

    public static void elegirSuministroClave() {
        furia_del_twister = random.nextInt(suministros_clave.length);
        JOptionPane.showMessageDialog(null, "El suministro clave es: " + suministros_clave[furia_del_twister]);
    }

    public static void evaluarRefugio() {
        if (es_seguro) {
            JOptionPane.showMessageDialog(null, "Has sobrevivido al Twister! El refugio resistió.");
            JOptionPane.showMessageDialog(null, "Felicidades, has ganado con el suministro clave: " + suministros_clave[furia_del_twister] + "!");
        } else {
            JOptionPane.showMessageDialog(null, "El refugio no resistió el Twister, te faltó " + suministros_clave[furia_del_twister] + ". Game Over, camarada.");
        }
    }

    public static void fortalecerRefugio() {
        String decisionStr = JOptionPane.showInputDialog("¿Quieres fortalecer el refugio usando el suministro clave? (1: Sí, 2: No):");
        int decision = Integer.parseInt(decisionStr);

        if (decision == 1) {
            boolean tieneSuministro = false;

            for (int i = 0; i < cantidadSuministros; i++) {
                if (inventario_usuario[i].equals(suministros_clave[furia_del_twister])) {
                    tieneSuministro = true;

                    // Eliminar el suministro clave del inventario
                    for (int j = i; j < cantidadSuministros - 1; j++) {
                        inventario_usuario[j] = inventario_usuario[j + 1];
                    }
                    cantidadSuministros--;
                    // Incrementar el contador de días solo si el refugio fue fortalecido
                    diasSuperados++;
                    JOptionPane.showMessageDialog(null, "Días superados: " + diasSuperados);
                    break; // Salir del bucle si ya lo encontró
                }
            }

            if (tieneSuministro) {
                JOptionPane.showMessageDialog(null, "El refugio ha sido fortalecido.");
                es_seguro = true; // Fortalecemos el refugio
            } else {
                JOptionPane.showMessageDialog(null, "No tienes el suministro clave para fortalecer el refugio.");
                es_seguro = false; // El refugio no se fortalece
            }
        } else {
            JOptionPane.showMessageDialog(null, "Has decidido no fortalecer el refugio.");
            recolectarSuministros(); // Continuar recolectando suministros
        }
    }

    public static void misionCientificoDesesperado() {
        JOptionPane.showMessageDialog(null, "Mientras buscas refugio, te encuentras con un científico desesperado.\n"
                + "Te dice: '¡Necesito tu ayuda! He descubierto algo sobre los twisters, pero me falta una pieza clave.'\n"
                + "'Necesito una muestra de ADN especial que está en una zona devastada.'");

        String decision = JOptionPane.showInputDialog("¿Aceptas la misión de recolectar la muestra de ADN? (1: Sí, 2: No):");

        if (decision.equals("1")) {
            JOptionPane.showMessageDialog(null, "Has aceptado ayudar al científico. Recolectas la muestra de ADN en un lugar peligroso.");
            // Simular éxito o fracaso en la misión
            if (random.nextBoolean()) {
                JOptionPane.showMessageDialog(null, "¡Misión completada! Has entregado la muestra de ADN al científico.");
            } else {
                JOptionPane.showMessageDialog(null, "Fallaste en recolectar la muestra, el área era demasiado peligrosa.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Has decidido no ayudar al científico. Continúas con tu propio camino.");
        }
    }

    public static void main(String[] args) {
        // Historia del juego
        JOptionPane.showMessageDialog(null, "Eres Alex, un médico de renombre en un mundo antes del caos, antes de que la naturaleza se volviera implacable.");
        JOptionPane.showMessageDialog(null, "El cambio comenzó de forma súbita: tornados, tormentas eléctricas, y un apocalipsis climático que acabó con ciudades enteras en cuestión de semanas.");
        JOptionPane.showMessageDialog(null, "La humanidad, tan poderosa y orgullosa, fue llevada de rodillas. Tú perdiste a tu familia en medio de este desastre.");
        JOptionPane.showMessageDialog(null, "El hogar que tanto protegiste fue devastado por la furia de un 'twister', uno de esos tornados que se formaban de la nada y destruían todo a su paso.");
        JOptionPane.showMessageDialog(null, "Con el dolor en tu corazón, te has convertido en un nómada solitario, moviéndote de un refugio a otro, buscando no solo sobrevivir, sino encontrar una razón para seguir adelante.");
        JOptionPane.showMessageDialog(null, "La sensación de desolación te acompaña mientras intentas establecerte en refugios temporales, siempre enfrentándote a la decisión de recolectar suministros esenciales para mantenerte vivo.");
        mostrarMenu();

        JOptionPane.showMessageDialog(null, "Tu primer desafío llega cuando te das cuenta de que necesitarás más que solo un refugio: debes recolectar suministros esenciales que te permitan enfrentar la tormenta y los peligros de la noche");

        recolectarSuministros();

        misionCientificoDesesperado();

        elegirSuministroClave();

        fortalecerRefugio();
       
        evaluarRefugio();
    }
}