import java.util.Random;

public class Habitacion {
    private String tipoHabitacion;
    private float precioHabitacion;
    private int capacidadHabitacion;
    private int cantidadDisponibles;


    public Habitacion(String tipoHabitacion, float precioHabitacion, int capacidadHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
        this.precioHabitacion = precioHabitacion;
        this.capacidadHabitacion = capacidadHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public float getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(float precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public int getCapacidadHabitacion() {
        return capacidadHabitacion;
    }
    
    public void setCapacidadHabitacion(int capacidadHabitacion) {
        this.capacidadHabitacion = capacidadHabitacion;
    }

    public int getCantidadDisponibles() {
        return cantidadDisponibles;
    }

    public void setCantidaDisponibles(int cantidaDisponibles) {
        this.cantidadDisponibles = cantidaDisponibles;
    }

    public int crearHabitacionesDisponibles(String tipoHabitacion) {
        Random disponibles = new Random();

        if (tipoHabitacion.equals("Estandar")) {
            cantidadDisponibles = disponibles.nextInt(40) + 1;
        }
        if (tipoHabitacion.equals("Deluxe")) {
            cantidadDisponibles = disponibles.nextInt(25) + 1;
        }
        if (tipoHabitacion.equals("VIP")) {
            cantidadDisponibles = disponibles.nextInt(10) + 1;
        }

        return cantidadDisponibles;
    }

    
}