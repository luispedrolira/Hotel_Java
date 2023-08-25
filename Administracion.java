public class Administracion{
    private String[] listaDeEspera;



    public String[] getListaDeEspera() {
        return listaDeEspera;
    }

    public String[] agregarListaDeEspera(Usuario usuario) {
        return listaDeEspera;
    }

    public String toString(Usuario usuario, Habitacion habitacionEstandar, Habitacion habitacionDeluxe, Habitacion habitacionVIP ){
        String mensaje = "";
        if (usuario.getTipoCliente().equals("Regular")){
            mensaje = "--------- HABITACIONES DISPONIBLES ---------\nHabitaciones Estandar: "+ habitacionEstandar.getCantidadDisponibles();
        }
        if (usuario.getTipoCliente().equals("Frecuentes")){
            mensaje = "--------- HABITACIONES DISPONIBLES ---------\nHabitaciones Estandar: "+ habitacionEstandar.getCantidadDisponibles()+"\nHabitaciones Deluxe: "+ habitacionDeluxe.getCantidadDisponibles();
        }
        if (usuario.getTipoCliente().equals("VIP")){
            mensaje = "--------- HABITACIONES DISPONIBLES ---------\nHabitaciones Estandar: "+ habitacionEstandar.getCantidadDisponibles()+"\nHabitaciones Deluxe: "+ habitacionDeluxe.getCantidadDisponibles()+"\nHabitaciones VIP: "+ habitacionVIP.getCantidadDisponibles();
        }

        return mensaje;
    }
}