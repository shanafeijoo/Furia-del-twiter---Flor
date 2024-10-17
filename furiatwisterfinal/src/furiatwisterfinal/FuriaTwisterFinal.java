/*
 * Matías K
 */
package furiatwisterfinal;


import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FuriaTwisterFinal {

    public static void main(String[] args) {
        System.out.println("MK");
        Scanner input = new Scanner(System.in);
        String[] refugios = {"Cueva", "Montaña", "Bosque"};
        String inventarioUsu[] = new String[5];
        String[] suministros_clave = {"Piel de Oso - Reduce el daño durante 2 turnos",
            "Piedra para hacer fuego - Aumenta el daño del próximo ataque",
            "Comida - Recupera entre 10 y 15 puntos de vida",
            "Kit de primeros auxilios - Recupera 30 puntos de vida",
            "Antorcha - Aumenta el daño en el siguiente turno",
            "Halcón mensajero - Inflige 10 puntos de daño extra",
            "Recipiente para agua - Recupera 10 puntos de vida",
            "Herramientas - Reduce el daño del próximo ataque"};
        Random furiaDelTwister = new Random();
        String[] armeria = {"Espada", "Hacha", "Martillo", "Arco y flecha", "Cetro Magico",};
        String armeriaUsu;
        String[] razas = {"Humano", "Orco", "Enano", "Elfo", "Druida"};
        String refugioUsu;
        boolean esSeguro;
        int respuesta = 0, contador = 0;
        String razaUsu;

        // Paso 1: Cargar las imágenes de los avatares
        ImageIcon humanoIcon = new ImageIcon(FuriaTwisterFinal.class.getResource("/images/humano.png"));
        ImageIcon orcoIcon = new ImageIcon(FuriaTwisterFinal.class.getResource("/images/orco.png"));
        ImageIcon enanoIcon = new ImageIcon(FuriaTwisterFinal.class.getResource("/images/enano.png"));
        ImageIcon elfoIcon = new ImageIcon(FuriaTwisterFinal.class.getResource("/images/elfo.png"));
        ImageIcon druidaIcon = new ImageIcon(FuriaTwisterFinal.class.getResource("/images/druida.png"));
        ImageIcon twisterIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/twister.png"));
        ImageIcon victoriaIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/victoria.png"));
        ImageIcon derrotaIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/derrota.png"));
        ImageIcon refugiosIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/refugios.png"));
        ImageIcon personajesIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/personajes.png"));
        ImageIcon pantallainicioIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/pantallainicio.png"));
        ImageIcon ciudadIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/ciudad.png"));
        ImageIcon tiendaIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/tienda.png"));
        ImageIcon arreglandoRegufioIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/arreglandorefugio.png"));
        ImageIcon twisterSeAcerca = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/twisteracercandose.png"));
        ImageIcon armeriaIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/armeria.png"));
        ImageIcon ataqueResiste = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/ataquetwisterresiste.png"));
        ImageIcon ataqueNoResiste = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/twisterdestruyendo.png"));
        ImageIcon preparandoBatalla = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/preparandobatalla.png"));

        //Empieza el juego
        JOptionPane.showMessageDialog(null,
                "¡Bienvenido, valiente aventurero, a la batalla definitiva por la supervivencia!\n"
                + "El Twister del Apocalipsis ha arrasado el mundo, y solo los más fuertes y astutos podrán resistir.\n"
                + "Tu viaje comienza aquí, en esta lucha por la vida contra una furia indomable. ¿Estás listo para enfrentar el desafío?",
                "Bienvenida a la Aventura: Sobreviviendo el Twister",
                JOptionPane.INFORMATION_MESSAGE,
                pantallainicioIcon);

//Creacion del personaje
        razaUsu = MetodosTwisterFinal.seleccionarRaza(razas);

//Metodo para poner la imagen en las preguntas
        ImageIcon avatarSeleccionado = MetodosTwisterFinal.obtenerAvatarPorRaza(razaUsu);

        String nombreUsu = (String) JOptionPane.showInputDialog(
                null,
                "Antes de comenzar tu travesía, debes inscribir tu nombre en los registros de los héroes.\n"
                + "¿Cuál es el nombre del valiente que se enfrentará al Twister?",
                "Creación de Personaje",
                JOptionPane.QUESTION_MESSAGE,
                avatarSeleccionado, // Mostrar el avatar del usuario en la pregunta
                null,
                null);

        // Pregunta de la altura con el avatar seleccionado
        String alturaUsu = (String) JOptionPane.showInputDialog(
                null,
                "Los héroes que enfrentan al Twister deben ser conocidos por su estatura y fortaleza.\n"
                + "¿Qué altura tiene el valiente que desafiará la tormenta?",
                "Información del Héroe",
                JOptionPane.QUESTION_MESSAGE,
                avatarSeleccionado, // Mostrar el avatar del usuario en la pregunta
                null,
                null);

        // Pregunta de la edad con el avatar seleccionado
        String edadUsu = (String) JOptionPane.showInputDialog(
                null,
                "Cada héroe que enfrenta el Twister tiene una historia marcada por los años.\n"
                + "¿Cuál es la edad del valiente que se atreve a desafiar la tormenta?",
                "Información del Héroe",
                JOptionPane.QUESTION_MESSAGE,
                avatarSeleccionado, // Mostrar el avatar del usuario en la pregunta
                null,
                null);

        String ciudadOrigin = (String) JOptionPane.showInputDialog(
                null,
                "Tu lugar de origen es parte de tu legado. Las tierras de las que provienes te han moldeado para esta batalla.\n"
                + "Por último, ¿de qué ciudad proviene el héroe que enfrentará al Twister?",
                "Ciudad de Origen del Héroe",
                JOptionPane.QUESTION_MESSAGE,
                ciudadIcon, // Mostrar el avatar del usuario en la pregunta
                null, // No se ofrece una lista de opciones
                null // No hay valor inicial seleccionado
        );

// Se muestra el perfil del usuario    
        MetodosTwisterFinal.mostrarPerfil(nombreUsu, alturaUsu, edadUsu, ciudadOrigin, razaUsu);

//Se muestra el lore del juego
        MetodosTwisterFinal.mostrarHistoria();

        //el usuario seleccion el refugio
        JOptionPane.showMessageDialog(null,
                "El Twister se aproxima rápidamente y no hay tiempo que perder. Deberás escoger entre los siguientes 3 refugios disponibles.\n"
                + "Cada uno ofrece una oportunidad diferente de supervivencia, pero también desafíos únicos.\n"
                + "Elige sabiamente, ya que tu vida puede depender de esta decisión.",
                "Selección de Refugio",
                JOptionPane.INFORMATION_MESSAGE,
                refugiosIcon);

        refugioUsu = MetodosTwisterFinal.seleccionRefugio(refugios);

        MetodosTwisterFinal.mostrarRefugio(refugioUsu);

        //elige los suministros que quiere
        JOptionPane.showMessageDialog(null,
                "La supervivencia está en los detalles. Puedes seleccionar hasta 5 suministros esenciales para resistir la tormenta.\n"
                + "Elige sabiamente, pues lo que dejes atrás podría marcar la diferencia entre la vida y la muerte.\n"
                + "Si crees estar listo, puedes continuar sin más, pero ¿estás realmente preparado?",
                "Selección de Suministros",
                JOptionPane.INFORMATION_MESSAGE,
                tiendaIcon);

        inventarioUsu = MetodosTwisterFinal.seleccionSuministros(suministros_clave);

        //Elige las armas
        JOptionPane.showMessageDialog(null,
                "La batalla que se avecina es implacable. Escoge bien tu arma, pues solo puedes llevar una.\n"
                + "El destino de tu lucha dependerá de esta elección. El arma correcta puede marcar la diferencia entre la victoria y la derrota.",
                "Selección de Arma",
                JOptionPane.INFORMATION_MESSAGE,
                armeriaIcon);

        armeriaUsu = MetodosTwisterFinal.seleccionArmas(armeria);

        MetodosTwisterFinal.mostrarAfinidadArma(razaUsu, armeriaUsu);

        //Muestro el inventario al usuario
        MetodosTwisterFinal.mostrarInventario(inventarioUsu, refugioUsu);

        //Fortalecer el refugio
        JOptionPane.showMessageDialog(null,
                "El viento se intensifica y las primeras señales del Twister comienzan a aparecer en el horizonte.\n"
                + "La tormenta se aproxima rápidamente, y es crucial verificar si tu refugio resistirá su furia.\n"
                + "Prepárate, tu seguridad depende de esta evaluación.",
                "Verificación de Refugio",
                JOptionPane.INFORMATION_MESSAGE,
                arreglandoRegufioIcon);

        esSeguro = MetodosTwisterFinal.fortalecerElRefugio(suministros_clave, inventarioUsu, furiaDelTwister, refugioUsu);

        JOptionPane.showMessageDialog(null,
                "El Twister se abalanza sobre tu refugio con una furia descomunal. Los vientos aúllan como bestias salvajes y la tierra tiembla bajo su poder.\n"
                + "Las paredes crujen y el cielo se oscurece, anunciando que la tormenta ha llegado a su máximo esplendor...\n"
                + "¡El ataque del Twister ha comenzado!",
                "Ataque del Twister",
                JOptionPane.INFORMATION_MESSAGE,
                twisterSeAcerca);

        // Verificar si el refugio es seguro y mostrar el mensaje correspondiente
        if (esSeguro) {
            JOptionPane.showMessageDialog(null,
                    "Tu refugio ha resistido los embates del Twister. Las paredes se mantienen firmes mientras los vientos aúllan afuera.\n"
                    + "Gracias a tu preparación, tienes una oportunidad real de enfrentarte a la tormenta y salir victorioso.\n"
                    + "¡Ahora, es el momento de demostrar tu valentía!",
                    "Refugio Seguro",
                    JOptionPane.INFORMATION_MESSAGE,
                    ataqueResiste);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Tu refugio tiembla bajo la fuerza devastadora del Twister. Las paredes crujen y el viento penetra las grietas.\n"
                    + "Con un refugio tan frágil, la batalla que te espera será brutal. Debes estar listo para luchar con todo lo que tienes.\n"
                    + "Prepárate, será una batalla difícil, pero no imposible.",
                    "Refugio Débil",
                    JOptionPane.WARNING_MESSAGE,
                    ataqueNoResiste);
        }

        //Pelea contra el Twister
        JOptionPane.showMessageDialog(null,
                "Ha llegado la hora de la batalla final contra el Twister. Esta no es una simple tormenta...\n"
                + "Muchos héroes han caído intentando detenerlo, pero tú tienes la oportunidad de cambiar el destino.\n"
                + "Prepárate, guerrero, porque solo uno sobrevivirá a esta tormenta.",
                "Batalla Final",
                JOptionPane.INFORMATION_MESSAGE,
                preparandoBatalla);

        if (esSeguro) {
            JOptionPane.showMessageDialog(null,
                    "El Twister está ante ti, sus vientos aúllan, pero tu refugio te ha protegido bien. Ahora es tu oportunidad.\n"
                    + "El Twister tiene 140 puntos de vida. Tienes 12 turnos para derrotarlo antes de que desate su furia definitiva.\n"
                    + "Tu fuerza y preparación serán la clave para sobrevivir.",
                    "Encuentro con el Twister",
                    JOptionPane.INFORMATION_MESSAGE,
                    twisterIcon);

        } else {
            JOptionPane.showMessageDialog(null,
                    "El Twister ha encontrado tu refugio vulnerable. Sus vientos rugen con una fuerza devastadora.\n"
                    + "El Twister tiene 180 puntos de vida. Tienes 12 turnos para derrotarlo antes de que todo quede arrasado.\n"
                    + "La tormenta es más fuerte de lo que imaginabas, pero la lucha no ha terminado. ¡Es hora de pelear por tu vida!",
                    "Encuentro con el Twister",
                    JOptionPane.INFORMATION_MESSAGE,
                    twisterIcon);

        }

        boolean resultadoPelea = MetodosTwisterFinal.pelearContraTwister(furiaDelTwister, esSeguro, razaUsu, armeriaUsu, inventarioUsu);

        if (resultadoPelea) {
            JOptionPane.showMessageDialog(null,
                    "¡Has vencido al Twister!, " + nombreUsu + ".\n"
                    + "El mundo recuerda tu nombre, y las tierras devastadas comienzan a sanar bajo tu legado.\n"
                    + "El grande quedará en la historia como un héroe que desafió a la tormenta.",
                    "Victoria",
                    JOptionPane.INFORMATION_MESSAGE,
                    victoriaIcon);

        } else {
            JOptionPane.showMessageDialog(null,
                    "El Twister ha consumido todo a su paso...\n"
                    + "Tu nombre se perderá en el viento, y el mundo seguirá en sombras hasta que otro héroe se levante.",
                    "Derrota",
                    JOptionPane.ERROR_MESSAGE,
                    derrotaIcon);

        }

    }

}
