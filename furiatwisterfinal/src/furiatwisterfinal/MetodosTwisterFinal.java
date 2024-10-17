/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furiatwisterfinal;


import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MetodosTwisterFinal {

    public static String seleccionRefugio(String[] refugios) {
        // Usar JOptionPane para mostrar una lista de opciones de refugios
        ImageIcon refugiosIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/refugios.png"));

        String refugioUsu = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona un refugio:\n\n"
                + "Cueva: Un escondite natural, protegido de los vientos y tormentas.\n"
                + "En las Montañas: Elevado, frío y peligroso, pero con una vista estratégica sobre el terreno.\n"
                + "En el Bosque: Los árboles antiguos ofrecen protección, pero las criaturas acechan en la oscuridad.",
                "Selección de Refugio",
                JOptionPane.QUESTION_MESSAGE,
                refugiosIcon,
                refugios,
                refugios[0]
        );

        // Si el usuario selecciona un refugio, lo devolvemos. Si cancela, devolvemos null o un mensaje.
        if (refugioUsu != null) {
            return refugioUsu;
        } else {
            return "No se seleccionó ningún refugio";  // Esto es opcional, dependiendo de cómo prefieras manejarlo
        }
    }

// Metodo para elegir los suministros
    public static String[] seleccionSuministros(String[] suministros_clave) {
        ImageIcon tiendaIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/tienda.png"));
        String[] inventarioUsu = new String[5];
        int contador = 0;

        while (contador < inventarioUsu.length) {
            // Mostrar una lista desplegable con las opciones de suministros
            String suministroSeleccionado = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione un suministro:",
                    "Selección de Suministros",
                    JOptionPane.QUESTION_MESSAGE,
                    tiendaIcon,
                    suministros_clave,
                    suministros_clave[0] // Suministro seleccionado por defecto
            );

            if (suministroSeleccionado != null && !suministroSeleccionado.equals("Salir")) {
                inventarioUsu[contador] = suministroSeleccionado;
                contador++;
            } else {
                break; // Si el usuario selecciona "Salir" o cancela, salir del bucle
            }
        }

        return inventarioUsu;
    }

// Metodo para mostrar el inventario
    public static void mostrarInventario(String[] inventarioUsu, String refugioUsu) {
        // Inicializar una cadena para el mensaje
        ImageIcon inventarioIcon = new ImageIcon(FuriaTwisterFinal.class.getResource("/images/inventario.png"));

        String mensaje = "Seleccionaste los siguientes suministros para " + refugioUsu + ":\n\n";

        // Concatenar cada suministro al mensaje
        for (int i = 0; i < inventarioUsu.length; i++) {
            if (inventarioUsu[i] != null) {
                mensaje += (i + 1) + ". " + inventarioUsu[i] + "\n";
            }
        }

        // Mostrar el inventario en un JOptionPane
        JOptionPane.showMessageDialog(null, mensaje, "Inventario", JOptionPane.INFORMATION_MESSAGE,
                inventarioIcon);
    }

// Metodo para fortalecer el refugio
    public static boolean fortalecerElRefugio(String[] suministrosClave, String[] inventarioUsu, Random furiaTwister, String refugioUsu) {
        boolean esSeguro = false;
        int numAleatorio = furiaTwister.nextInt(suministrosClave.length);

        for (int i = 0; i < inventarioUsu.length; i++) {
            if (inventarioUsu[i] != null && refugioUsu.equalsIgnoreCase("Cueva") && inventarioUsu[i].equalsIgnoreCase("Comida - Recupera entre 10 y 15 puntos de vida") || inventarioUsu[i] != null && refugioUsu.equalsIgnoreCase("Montaña") && inventarioUsu[i].equalsIgnoreCase("Piel de Oso - Reduce el daño durante 2 turnos") || inventarioUsu[i] != null && refugioUsu.equalsIgnoreCase("Bosque") && inventarioUsu[i].equalsIgnoreCase("Piedra para hacer fuego - Aumenta el daño del próximo ataque")) {
                esSeguro = true;
            }
        }
        return esSeguro;
    }

// Metodo para elegir la raza del jugador
    public static String seleccionarRaza(String[] razas) {
        // Cargar las imágenes de los avatares
        ImageIcon humanoIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/humano.png"));
        ImageIcon orcoIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/orco.png"));
        ImageIcon enanoIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/enano.png"));
        ImageIcon elfoIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/elfo.png"));
        ImageIcon druidaIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/druida.png"));
        ImageIcon personajesIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/personajes.png"));

        String raza = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona tu raza:\n\n"
                + "Humano: Guerreros versátiles, capaces de adaptarse a cualquier situación.\n"
                + "Orco: Famosos por su fuerza bruta, los orcos han sobrevivido en las peores condiciones.\n"
                + "Enano: Maestros de la forja, con corazones tan duros como sus martillos.\n"
                + "Elfo: Elegantes y ágiles, los elfos tienen una conexión ancestral con la naturaleza.\n"
                + "Druida: Custodios de los antiguos secretos, los druidas manipulan los elementos a su favor.",
                "Razas",
                JOptionPane.QUESTION_MESSAGE,
                personajesIcon,
                razas,
                razas[0]);
        // Verificar si el jugador seleccionó una raza
        if (raza != null) {
            ImageIcon avatarIcon = null;

            // Asociar el avatar correcto según la raza seleccionada
            switch (raza) {
                case "Humano":
                    avatarIcon = humanoIcon;
                    break;
                case "Orco":
                    avatarIcon = orcoIcon;
                    break;
                case "Enano":
                    avatarIcon = enanoIcon;
                    break;
                case "Elfo":
                    avatarIcon = elfoIcon;
                    break;
                case "Druida":
                    avatarIcon = druidaIcon;
                    break;

            }
            // Mostrar el avatar con un mensaje de confirmación
            JOptionPane.showMessageDialog(
                    null,
                    "Has seleccionado la raza: " + raza,
                    "Avatar de Raza",
                    JOptionPane.INFORMATION_MESSAGE,
                    avatarIcon);
        }

        // Devolver la raza seleccionada para ser usada en otros métodos
        return raza;
    }

    // Método para mostrar el perfil del jugador con avatar
    public static void mostrarPerfil(String nombre, String altura, String edad, String ciudadOrigen, String razaSeleccionada) {
        ImageIcon avatarIcon = null;

        // Cargar el avatar correspondiente a la raza
        switch (razaSeleccionada) {
            case "Humano":
                avatarIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/humano.png"));
                break;
            case "Orco":
                avatarIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/orco.png"));
                break;
            case "Enano":
                avatarIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/enano.png"));
                break;
            case "Elfo":
                avatarIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/elfo.png"));
                break;
            case "Druida":
                avatarIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/druida.png"));
                break;
        }

        // Mostrar el perfil del jugador junto con el avatar
        JOptionPane.showMessageDialog(
                null,
                "Nombre: " + nombre + "\n"
                + "Edad: " + edad + " años\n"
                + "Altura: " + altura + " metros\n"
                + "Ciudad de origen: " + ciudadOrigen + "\n"
                + "Raza: " + razaSeleccionada,
                "Perfil del Jugador",
                JOptionPane.INFORMATION_MESSAGE,
                avatarIcon);
    }

// Lore
    public static void mostrarHistoria() {
        ImageIcon loreIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/lore.png"));

        JOptionPane.showMessageDialog(null, """
    En un mundo devastado por catástrofes, la naturaleza ha desencadenado
    su furia más oscura: el **Twister del Apocalipsis**. Ciudades han sido
    arrasadas, bosques han desaparecido y los supervivientes se han refugiado
    en los lugares más seguros que pudieron encontrar. Las antiguas razas —
    humanos, orcos, elfos, enanos y druidas— han unido fuerzas en una última
    batalla por la supervivencia.

    Eres un guerrero legendario de tu raza, llamado a enfrentar el Twister para
    salvar lo que queda de la civilización. Armado con los pocos suministros que
    lograste reunir y con las armas que heredaste de tus antepasados, debes
    fortalecer tu refugio y prepararte para la tormenta final.

    El **Twister** no solo es un fenómeno natural, sino una fuerza antigua que debe
    ser derrotada en combate. Solo aquellos suficientemente fuertes y bien
    preparados podrán sobrevivir.

    ¡Prepárate para la batalla!
    """,
                "HISTORIA", JOptionPane.INFORMATION_MESSAGE,
                loreIcon);

    }

// Elegir armas
    public static String seleccionArmas(String[] armeria) {
        ImageIcon armeriaIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/armeria.png"));
        String armaUsu = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona tu arma:\n\n"
                + "Espada: Forjada en las antiguas forjas humanas, símbolo de reyes y caballeros.\n"
                + "Hacha: El arma preferida de los orcos, diseñada para aplastar huesos y partir armaduras.\n"
                + "Martillo: Los enanos usan estos martillos para destruir no solo rocas, sino también a sus enemigos.\n"
                + "Arco y Flecha: Los elfos perfeccionaron el arte del tiro con arco, con flechas que nunca fallan.\n"
                + "Cetro Mágico: El arma de los druidas, infundida con la esencia de los antiguos árboles y la magia de la naturaleza.",
                "Armería",
                JOptionPane.QUESTION_MESSAGE,
                armeriaIcon,
                armeria,
                armeria[0]
        );
        return armaUsu;
    }

// Metodo para pelear contra el Twister
    public static boolean pelearContraTwister(Random furiaDelTwister, boolean esSeguro, String razaUsu, String armeriaUsu, String[] inventarioUsu) {
        int vidaTwister = esSeguro ? 140 : 180;  // La vida del Twister se aumenta (antes era 80 o 120)
        int vidaUsuario = 130;  // Vida del jugador
        int turnos = 12;  // Número de turnos disponibles
        boolean escudoActivo = false;  // Para manejar la defensa
        boolean objetoUsado = false;  // Controlar si ya se usó un objeto que afecta al turno actual
        int objetosUsados = 0;  // Contador para objetos usados
        int maxObjetos = 3;  // Máximo de 3 objetos permitidos por batalla
        int modificadorDaño = 0;  // Variable que guarda el incremento de daño por un objeto
        boolean ataqueEspecialUsado = false; // Controlar uso del ataque especial
        ImageIcon peleaTwister = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/peleatwister.png"));
        ImageIcon decisionPelea = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/atacardefenderobjeto.png"));
        ImageIcon ataquealTwister = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/ataquealtwister.png"));
        ImageIcon defensaContraTwister = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/defensacontratwister.png"));
        ImageIcon usarObjeto = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/usarobjeto.png"));
        ImageIcon pieldeOso = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/pieldeoso.png"));
        ImageIcon aguaIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/agua.png"));
        ImageIcon antorchaIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/antorcha.png"));
        ImageIcon comidaIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/comida.png"));
        ImageIcon herramientasIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/herramientas.png"));
        ImageIcon halconIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/halcon.png"));
        ImageIcon piedraFuego = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/piedrafuego.png"));
        ImageIcon primerosAuxilios = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/primerosauxilios.png"));
        ImageIcon teQuedanObjetos = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/tequedanobjetos.png"));
        ImageIcon noQuedanObjetos = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/noquedanobjetos.png"));
        ImageIcon twisterDerrotado = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/twisterderrotado.png"));
        ImageIcon heroeDerrotado = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/herorederrotado.png"));
        ImageIcon twisterSobrevive = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/twistersobrevive.png"));
        ImageIcon ataqueEspecial = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/ataqueespecial.png"));

        // Mensaje inicial del combate
        JOptionPane.showMessageDialog(null,
                "¡La batalla comienza! Prepárate para luchar por tu vida.",
                "Batalla contra el Twister", // Este es el título de la ventana
                JOptionPane.INFORMATION_MESSAGE,
                peleaTwister
        );

        // Ciclo para los turnos de combate
        for (int i = 0; i < turnos; i++) {
            objetoUsado = false;  // Reiniciar el estado del objeto al inicio de cada turno

            String[] opcionesCombate = ataqueEspecialUsado
                    ? new String[]{"Atacar", "Defender", "Usar objeto"}
                    : new String[]{"Atacar", "Defender", "Usar objeto", "Ataque Especial"};

            String accionUsu = (String) JOptionPane.showInputDialog(null,
                    "Turno " + (i + 1) + ": ¿Qué quieres hacer?\n"
                    + "Vida del Jugador: " + vidaUsuario + "\nVida del Twister: " + vidaTwister,
                    "Batalla contra el Twister",
                    JOptionPane.QUESTION_MESSAGE,
                    decisionPelea,
                    opcionesCombate,
                    opcionesCombate[0]);

            // Acción de atacar
            if (accionUsu.equals("Atacar")) {
                // Llamamos al nuevo método para calcular el daño base aleatorio (entre 1 y 20)
                int daño = calcularDañoJugador();

                // Aplicamos el modificador de daño si está activo (Antorcha o Piedra para hacer fuego)
                daño += modificadorDaño;  // Añadir el daño extra otorgado por los objetos
                modificadorDaño = 0;  // Reiniciar el modificador tras un ataque

                // Afinidad entre raza y arma
                if ((razaUsu.equalsIgnoreCase("Humano") && armeriaUsu.equalsIgnoreCase("Espada"))
                        || (razaUsu.equalsIgnoreCase("Orco") && armeriaUsu.equalsIgnoreCase("Hacha"))
                        || (razaUsu.equalsIgnoreCase("Enano") && armeriaUsu.equalsIgnoreCase("Martillo"))
                        || (razaUsu.equalsIgnoreCase("Elfo") && armeriaUsu.equalsIgnoreCase("Arco y Flecha"))
                        || (razaUsu.equalsIgnoreCase("Druida") && armeriaUsu.equalsIgnoreCase("Cetro Magico"))) {
                    daño *= 1.3;  // Si hay afinidad entre raza y arma, aumenta el daño en un 30%
                }

                vidaTwister -= daño;
                JOptionPane.showMessageDialog(null, "¡Has atacado al Twister y le has hecho " + daño + " puntos de daño!\n"
                        + "Vida del Twister: " + vidaTwister,
                        "Ataque", JOptionPane.INFORMATION_MESSAGE, ataquealTwister);

                // Acción de defender
            } else if (accionUsu.equals("Defender")) {
                escudoActivo = true;
                JOptionPane.showMessageDialog(null, "¡Te preparas para defender el próximo ataque del Twister!\n"
                        + "Vida del Jugador: " + vidaUsuario + "\nVida del Twister: " + vidaTwister,
                        "Defensa", JOptionPane.INFORMATION_MESSAGE, defensaContraTwister);

                // Acción de usar objeto
            } else if (accionUsu.equals("Usar objeto")) {
                if (objetosUsados < maxObjetos) {
                    String objetoElegido = (String) JOptionPane.showInputDialog(null,
                            "Selecciona el objeto que deseas usar:",
                            "Inventario de objetos",
                            JOptionPane.QUESTION_MESSAGE,
                            usarObjeto,
                            inventarioUsu, // Lista de objetos del inventario
                            inventarioUsu[0]);

                    // Dependiendo del objeto seleccionado, se aplican efectos
                    if (objetoElegido.equals("Piel de Oso - Reduce el daño durante 2 turnos")) {
                        escudoActivo = true;  // Reduce el daño durante 2 turnos
                        JOptionPane.showMessageDialog(null, "¡Has usado la piel de oso! Serás más resistente en los próximos 2 turnos.", "Objeto",
                                JOptionPane.INFORMATION_MESSAGE,
                                pieldeOso);
                    } else if (objetoElegido.equals("Piedra para hacer fuego - Aumenta el daño del próximo ataque")) {
                        modificadorDaño = 10;  // Aumenta el daño del próximo ataque
                        JOptionPane.showMessageDialog(null, "¡Has usado la piedra para hacer fuego! El daño de tu próximo ataque será mayor.", "Objeto",
                                JOptionPane.INFORMATION_MESSAGE,
                                piedraFuego);
                    } else if (objetoElegido.equals("Comida - Recupera entre 10 y 15 puntos de vida")) {
                        int vidaAntes = vidaUsuario;
                        int vidaRecuperada = furiaDelTwister.nextInt(6) + 10;
                        vidaUsuario = Math.min(vidaUsuario + vidaRecuperada, 100);
                        JOptionPane.showMessageDialog(null, "Tu vida antes: " + vidaAntes + "\nHas comido y recuperado " + vidaRecuperada + " puntos de vida.\nVida actual: " + vidaUsuario,
                                "Objeto", JOptionPane.INFORMATION_MESSAGE, comidaIcon);
                    } else if (objetoElegido.equals("Kit de primeros auxilios - Recupera 30 puntos de vida")) {
                        int vidaAntes = vidaUsuario;
                        vidaUsuario = Math.min(vidaUsuario + 30, 100);
                        JOptionPane.showMessageDialog(null, "Tu vida antes: " + vidaAntes + "\nHas usado un kit de primeros auxilios y recuperado 30 puntos de vida.\nVida actual: " + vidaUsuario,
                                "Objeto", JOptionPane.INFORMATION_MESSAGE, primerosAuxilios);
                    } else if (objetoElegido.equals("Antorcha - Aumenta el daño en el siguiente turno")) {
                        modificadorDaño = 15;  // Aumenta el daño en el siguiente turno
                        JOptionPane.showMessageDialog(null, "¡Has encendido una antorcha! Tus ataques harán más daño durante el próximo turno.", "Objeto",
                                JOptionPane.INFORMATION_MESSAGE,
                                antorchaIcon);
                    } else if (objetoElegido.equals("Halcón mensajero - Inflige 10 puntos de daño extra")) {
                        int dañoExtra = 10;  // Daño adicional infligido por el halcón
                        vidaTwister -= dañoExtra;
                        JOptionPane.showMessageDialog(null, "¡El halcón mensajero ha atacado al Twister e infligido 10 puntos de daño extra!", "Objeto",
                                JOptionPane.INFORMATION_MESSAGE,
                                halconIcon);
                    } else if (objetoElegido.equals("Recipiente para agua - Recupera 10 puntos de vida")) {
                        int vidaAntes = vidaUsuario;
                        vidaUsuario = Math.min(vidaUsuario + 10, 100);
                        JOptionPane.showMessageDialog(null, "Tu vida antes: " + vidaAntes + "\nHas bebido agua y recuperado 10 puntos de vida.\nVida actual: " + vidaUsuario,
                                "Objeto", JOptionPane.INFORMATION_MESSAGE, aguaIcon);
                    } else if (objetoElegido.equals("Herramientas - Reduce el daño del próximo ataque")) {
                        escudoActivo = true;  // Fortalece temporalmente el refugio
                        JOptionPane.showMessageDialog(null, "¡Has usado herramientas para mejorar tu defensa! Reducirás el daño del próximo ataque.", "Objeto",
                                JOptionPane.INFORMATION_MESSAGE,
                                herramientasIcon);
                    }

                    objetosUsados++;  // Incrementa el contador de objetos usados
                    JOptionPane.showMessageDialog(null, "¡Has usado un objeto! Te quedan " + (maxObjetos - objetosUsados) + " usos de objetos.", null,
                            JOptionPane.INFORMATION_MESSAGE,
                            teQuedanObjetos);
                } else {
                    JOptionPane.showMessageDialog(null, "¡Ya has usado el máximo número de objetos en esta batalla!", null,
                            JOptionPane.INFORMATION_MESSAGE,
                            noQuedanObjetos);
                }
            } else if (accionUsu.equals("Ataque Especial")) {
                int dañoEspecial = 0;

                // Daño especial por raza
                if (razaUsu.equalsIgnoreCase("Humano")) {
                    dañoEspecial = 40;  // ataque especial del Humano
                } else if (razaUsu.equalsIgnoreCase("Orco")) {
                    dañoEspecial = 50;  // ataque especial del Orco
                } else if (razaUsu.equalsIgnoreCase("Enano")) {
                    dañoEspecial = 45;  // ataque especial del Enano
                } else if (razaUsu.equalsIgnoreCase("Elfo")) {
                    dañoEspecial = 35;  // ataque especial del Elfo
                } else if (razaUsu.equalsIgnoreCase("Druida")) {
                    dañoEspecial = 30;  // ataque especial del Druida
                }

                vidaTwister -= dañoEspecial;
                ataqueEspecialUsado = true;  // Marcar el ataque especial como usado
                JOptionPane.showMessageDialog(null, "¡Has usado tu ataque especial e infligido " + dañoEspecial + " puntos de daño al Twister!\n"
                        + "Vida del Twister: " + vidaTwister, "Ataque Especial", JOptionPane.INFORMATION_MESSAGE,
                        ataqueEspecial);

            }

            // Comprobamos si el Twister ha sido derrotado
            if (vidaTwister <= 0) {
                JOptionPane.showMessageDialog(null, "¡Has derrotado al Twister!", "Victoria",
                        JOptionPane.INFORMATION_MESSAGE,
                        twisterDerrotado);
                return true;  // El jugador gana
            }

            // El Twister ataca al jugador
            int dañoTwister = furiaDelTwister.nextInt(15) + 5;  // Daño del Twister entre 5 y 20 puntos
            if (escudoActivo) {
                dañoTwister /= 2;  // Si el jugador está defendiendo, recibe la mitad del daño
                escudoActivo = false;  // El escudo dura un turno
            }
            vidaUsuario -= dañoTwister;
            JOptionPane.showMessageDialog(null, "El Twister te ataca y te hace " + dañoTwister + " puntos de daño.\n"
                    + "Vida del Jugador: " + vidaUsuario + "\nVida del Twister: " + vidaTwister,
                    "Defensa", JOptionPane.INFORMATION_MESSAGE, defensaContraTwister);

            // Comprobamos si el jugador ha sido derrotado
            if (vidaUsuario <= 0) {
                JOptionPane.showMessageDialog(null, "El Twister ha acabado contigo...", "Derrota",
                        JOptionPane.INFORMATION_MESSAGE,
                        heroeDerrotado);
                return false;  // El jugador pierde
            }
        }

        // Si se han terminado los turnos y ambos siguen con vida
        if (vidaTwister > 0) {
            JOptionPane.showMessageDialog(null, "El Twister ha sobrevivido a tu ataque, el caos continúa...", null,
                    JOptionPane.INFORMATION_MESSAGE,
                    twisterSobrevive);
            return false;  // El Twister gana
        }

        return true;  // El jugador gana si el Twister ha sido derrotado
    }

    /*public static boolean pelearContraTwister(Random furiaTwister, boolean esSeguro, String razaUsu, String armeriaUsu) {
        ImageIcon peleaTwister = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/peleatwister.png"));
        
        int vidaTwister;
        int turnos = 0;
        ImageIcon twisterIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/twister.png"));
        if (esSeguro) {
            vidaTwister = 80;
        } else {
            vidaTwister = 120;
        }

        while (vidaTwister > 0 && turnos < 8) { // El jugador tiene 10 turnos para derrotarlo
            int danio = furiaTwister.nextInt(20) + 1; // Genera un daño entre 1 y 20
            if (razaUsu.equalsIgnoreCase("Humano") && armeriaUsu.equalsIgnoreCase("Espada") || razaUsu.equalsIgnoreCase("Orco") && armeriaUsu.equalsIgnoreCase("Hacha") || razaUsu.equalsIgnoreCase("Enano") && armeriaUsu.equalsIgnoreCase("Martillo") || razaUsu.equalsIgnoreCase("Elfo") && armeriaUsu.equalsIgnoreCase("Arco y Flecha") || razaUsu.equalsIgnoreCase("Druida") && armeriaUsu.equalsIgnoreCase("Cetro Magico")) {
                danio *= 1.3;
            }
            vidaTwister -= danio;
            JOptionPane.showMessageDialog(null,
                    "Has infligido " + danio + " puntos de daño.\n"
                    + "El Twister parece perder fuerza, pero sus vientos furiosos aún desgarran el cielo.\n"
                    + "Vida restante del Twister: " + vidaTwister,
                    "Ataque al Twister",
                    JOptionPane.INFORMATION_MESSAGE,
                    peleaTwister);

            turnos++;
        }

        return vidaTwister <= 0; // Si la vida del twister llega a 0 o menos, el jugador gana
    }*/
    public static void mostrarAfinidadArma(String razaUsu, String armeriaUsu) {
        ImageIcon afinidadArma = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/afinidadarma.png"));
        ImageIcon noCompatible = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/armanocompatible.png"));

        if (razaUsu.equalsIgnoreCase("Humano") && armeriaUsu.equalsIgnoreCase("Espada") || razaUsu.equalsIgnoreCase("Orco") && armeriaUsu.equalsIgnoreCase("Hacha") || razaUsu.equalsIgnoreCase("Enano") && armeriaUsu.equalsIgnoreCase("Martillo") || razaUsu.equalsIgnoreCase("Elfo") && armeriaUsu.equalsIgnoreCase("Arco y Flecha") || razaUsu.equalsIgnoreCase("Druida") && armeriaUsu.equalsIgnoreCase("Cetro Magico")) {
            JOptionPane.showMessageDialog(null,
                    "Tu elección ha sido sabia. El arma que has escogido resuena con la esencia de tu raza, fortaleciendo tu poder.\n"
                    + "Con esta afinidad, infligirás un daño devastador al Twister. El destino parece estar de tu lado.",
                    "Afinidad de Arma",
                    JOptionPane.INFORMATION_MESSAGE,
                    afinidadArma);

        } else {
            JOptionPane.showMessageDialog(null,
                    "Aunque no has elegido el arma más adecuada para tu raza, no todo está perdido.\n"
                    + "Tu habilidad y coraje aún pueden inclinar la balanza. La batalla será más difícil, pero la victoria aún es posible.",
                    "Arma No Compatible",
                    JOptionPane.INFORMATION_MESSAGE,
                    noCompatible);

        }
    }

    public static void mostrarRefugio(String refugio) {
        // Cargar imagen del refugio
        ImageIcon refugioIcon = new ImageIcon(MetodosTwisterFinal.class.getResource("/images/" + refugio.toLowerCase() + ".png"));

        JOptionPane.showMessageDialog(
                null,
                "Te has resguardado en " + refugio + ".\n"
                + "Este lugar será tu última línea de defensa contra la furia del Twister.",
                "Refugio Seleccionado",
                JOptionPane.INFORMATION_MESSAGE,
                refugioIcon);
    }

    public static ImageIcon obtenerAvatarPorRaza(String razaUsu) {
        ImageIcon avatarSeleccionado = null;

        switch (razaUsu) {
            case "Humano":
                avatarSeleccionado = new ImageIcon(FuriaTwisterFinal.class.getResource("/images/humano.png"));
                break;
            case "Orco":
                avatarSeleccionado = new ImageIcon(FuriaTwisterFinal.class.getResource("/images/orco.png"));
                break;
            case "Enano":
                avatarSeleccionado = new ImageIcon(FuriaTwisterFinal.class.getResource("/images/enano.png"));
                break;
            case "Elfo":
                avatarSeleccionado = new ImageIcon(FuriaTwisterFinal.class.getResource("/images/elfo.png"));
                break;
            case "Druida":
                avatarSeleccionado = new ImageIcon(FuriaTwisterFinal.class.getResource("/images/druida.png"));
                break;
        }

        return avatarSeleccionado;
    }

    public static int calcularDañoJugador() {
        Random random = new Random();
        return random.nextInt(20) + 1;  // Daño aleatorio entre 1 y 20
    }

}