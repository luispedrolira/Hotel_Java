import java.util.concurrent.TimeUnit;

public class Hotel{
    public static void main(String[] args) {
        boolean isRunning = true;
        Habitacion habitacionEstandar = new Habitacion("Estandar", 50, 2);
        Habitacion habitacionDeluxe = new Habitacion("Deluxe", 120, 5);
        Habitacion habitacionVIP = new Habitacion("VIP", 200, 8);
        habitacionesDisponibles(habitacionEstandar, habitacionDeluxe, habitacionVIP);
        

        while(isRunning){
            System.out.println("\n============ BIENVENIDO A HOTEL JAVA ============");
            System.out.println("1. Reservar una habitación\n2. Ver lista de espera\n3. Ver habitaciones disponibles\n4. Salir");
            System.out.println("¿Qué desea hacer?");
            int opcion = Integer.parseInt(System.console().readLine());

            switch (opcion){
                case 1:
                    reservarHabitacion(habitacionEstandar, habitacionDeluxe, habitacionVIP);
                    break;

                case 2:
                    consultarListaDeEspera();
                    break;

                case 3:
                    consultarHabitacionesDisponibles(habitacionEstandar, habitacionDeluxe, habitacionVIP);
                    break;
                
                case 4:
                    isRunning = false;
                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }

    }
    /**
     * Este metodo permite reservar una habitación.
     * @param habitacionEstandar
     * @param habitacionDeluxe
     * @param habitacionVIP
     */
    private static void reservarHabitacion(Habitacion habitacionEstandar, Habitacion habitacionDeluxe, Habitacion habitacionVIP){
        Administracion admin = new Administracion();
        Usuario usuario = new Usuario();

        System.out.println("¿Cual es su nombre?");
        usuario.setNombreUsuario(System.console().readLine());
        System.out.println("¿Cuantas veces no ha visitado en el Hotel Java?");
        int vecesVisitado = Integer.parseInt(System.console().readLine());

        if ((vecesVisitado == 1) || (vecesVisitado < 5)){
            usuario.setTipoCliente("Regular");
            System.out.println(" ** "+usuario.getNombreUsuario()+", usted solo puede reservar habitaciónes Estandar ** ");
            System.out.println("Consultando habitaciones disponibles del día...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(admin.toString(usuario, habitacionEstandar, habitacionDeluxe, habitacionVIP));
            System.out.println("¿Cuantas habitaciones desea reservar?");
            usuario.setCantidadHabitaciones(Integer.parseInt(System.console().readLine()));
            System.out.println("¿Cuantos huespedes se hospedaran?");
            usuario.setCantidadHuespedes(Integer.parseInt(System.console().readLine()));
            System.out.println("¿Cual es su presupuesto?");
            usuario.setPresupuesto(Float.parseFloat(System.console().readLine()));

            verificarReservacionHuesped(usuario, habitacionEstandar, admin);
            

        }
        if ((vecesVisitado >= 5) && (vecesVisitado < 10)){
            usuario.setTipoCliente("Frecuentes");
            System.out.println(" ** "+usuario.getNombreUsuario()+", usted puede reservar habitaciónes Deluxe y Estandar ** ");
            System.out.println("Consultando habitaciones disponibles del día...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(admin.toString(usuario, habitacionEstandar, habitacionDeluxe, habitacionVIP));
            System.out.println("¿Qué tipo de habitación desea reservar? (Deluxe/Estandar)");
            String usuarioHabitación = System.console().readLine();
            System.out.println("¿Cuantas habitaciones desea reservar?");
            usuario.setCantidadHabitaciones(Integer.parseInt(System.console().readLine()));
            System.out.println("¿Cuantos huespedes se hospedaran?");
            usuario.setCantidadHuespedes(Integer.parseInt(System.console().readLine()));
            System.out.println("¿Cual es su presupuesto?");
            usuario.setPresupuesto(Float.parseFloat(System.console().readLine()));


            switch (usuarioHabitación){
                case "Estandar":
                    verificarReservacionHuesped(usuario, habitacionDeluxe, admin);
                    break;
                case "Deluxe":
                    verificarReservacionHuesped(usuario, habitacionDeluxe, admin);
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
            
        }
        if (vecesVisitado >= 10){
            usuario.setTipoCliente("VIP");
            System.out.println(" ** "+usuario.getNombreUsuario()+", usted puede reservar habitaciónes VIP, Deluxe y Estandar ** ");
            System.out.println("Consultando habitaciones disponibles del día...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(admin.toString(usuario, habitacionEstandar, habitacionDeluxe, habitacionVIP));
            System.out.println("¿Qué tipo de habitación desea reservar? (VIP/Deluxe/Estandar)");
            String usuarioHabitación = System.console().readLine();
            System.out.println("¿Cuantas habitaciones desea reservar?");
            usuario.setCantidadHabitaciones(Integer.parseInt(System.console().readLine()));
            System.out.println("¿Cuantos huespedes se hospedaran?");
            usuario.setCantidadHuespedes(Integer.parseInt(System.console().readLine()));
            System.out.println("¿Cual es su presupuesto?");
            usuario.setPresupuesto(Float.parseFloat(System.console().readLine()));


            switch (usuarioHabitación){
                case "Estandar":
                    verificarReservacionHuesped(usuario, habitacionEstandar, admin);
                    break;
                case "Deluxe":
                    verificarReservacionHuesped(usuario, habitacionDeluxe, admin);
                    break;
                case "VIP":
                    verificarReservacionHuesped(usuario, habitacionVIP, admin);
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }
    /**
     * Este metodo consulta la lista de espera.
     * 
     */
    private static void consultarListaDeEspera(){
        Administracion admin = new Administracion();
        System.out.println("Lista de espera: "+admin.getListaDeEspera());
    }
    /**
     * Este metodo consulta las habitaciones disponibles del día.
     * @param habitacionEstandar
     * @param habitacionDeluxe
     * @param habitacionVIP
     * 
     */
    private static void consultarHabitacionesDisponibles(Habitacion habitacionEstandar, Habitacion habitacionDeluxe, Habitacion habitacionVIP){
        System.out.println("Consultando habitaciones disponibles del día...");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Habitaciones Estandar: "+habitacionEstandar.getCantidadDisponibles()+"\nHabitaciones Deluxe: "+habitacionDeluxe.getCantidadDisponibles()+"\nHabitaciones VIP: "+habitacionVIP.getCantidadDisponibles());
    }


    /**
     * Este metodo crea las habitaciones disponibles del día.
     * @param habitacionEstandar
     * @param habitacionDeluxe
     * @param habitacionVIP
     */
    private static void habitacionesDisponibles(Habitacion habitacionEstandar, Habitacion habitacionDeluxe, Habitacion habitacionVIP){
        habitacionEstandar.crearHabitacionesDisponibles("Estandar");
        habitacionDeluxe.crearHabitacionesDisponibles("Deluxe");
        habitacionVIP.crearHabitacionesDisponibles("VIP");
    }
    /**
     * Este metodo verifica si el usuario puede reservar una habitación.
     * @param usuario
     * @param habitacionUsuario
     * @param admin
     */
    private static void verificarReservacionHuesped(Usuario usuario, Habitacion habitacionUsuario, Administracion admin){        
        if (habitacionUsuario.getCantidadDisponibles() > 0){
            /**
             * Este if verifica si existen habitaciones disponibles en el día.
             */
            if (habitacionUsuario.getCantidadDisponibles() >= usuario.getCantidadHabitaciones()){
                /**
                 * Este if verifica si la cantidad que el usuario quiere reservar están disponibles en el día.
                 */
                if ((habitacionUsuario.getCapacidadHabitacion() * usuario.getCantidadHabitaciones()) % usuario.getCantidadHuespedes() == 0){
                    /**
                     * Este if verifica si la cantidad de huespedes coincide con la capacidad de la habitación.
                     *  -> El usuario puede tener varias habitaciones, y varios huespedes en diferentes habitaciones.
                     *  -> es por eso que se evalua si el numero de huespedes es equivalente a la cantidad de habitaciones que el usuario quiere reservar.
                     */
                    if (habitacionUsuario.getPrecioHabitacion() <= usuario.getPresupuesto()){
                        /**
                         * Este ultimo if verifica si el presupuesto del usuario es suficiente para reservar la habitación.
                         */

                        habitacionUsuario.setCantidaDisponibles(habitacionUsuario.getCantidadDisponibles() - usuario.getCantidadHabitaciones());
                        System.out.println("Reservando habitación...");
                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Habitación reservada con exito!");

                    } else {
                        System.out.println("Lo sentimos "+usuario.getNombreUsuario()+", su presupuesto no es suficiente para reservar esta habitación");
                    }

                } else {
                    System.out.println("Lo sentimos "+usuario.getNombreUsuario()+", la habitación que desea reservar no cuenta con la capacidad suficiente para "+usuario.getCantidadHuespedes()+" huespedes");
                }
            } else {
                System.out.println("Lo sentimos "+usuario.getNombreUsuario()+", la habitación que desea reservar no cuenta con la cantidad suficiente de habitaciones");
            }
        }
        else {
            System.out.println("Lo sentimos "+usuario.getNombreUsuario()+", ya no hay habitaciones disponibles, ¿Desea ser agregado a la lista de espera? (S/N)");
            String respuesta = System.console().readLine();

            if (respuesta.equals("S")){
                admin.agregarListaDeEspera(usuario);
            } else{
                System.out.println("Gracias por visitar Hotel Java");
            }
        }
    }
}