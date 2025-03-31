package utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class FuncionesFechas {
    /**
     * Comprueba que la fecha es de una longitud de 10 caracteres y que sigue el formato fecha con barras.
     * @author davidrn06
     * @param fecha se refiere a la fecha del proyecto.
     * @return devuelve true si el formato de la fecha es correcto.
     */
    private static boolean comprobacionFormatoFecha(String fecha){

        if (fecha.length()==10 && (fecha.charAt(2)=='/'&&fecha.charAt(5)=='/')){
            return true;
        }
        return false;
    }

    /**
     * Comprueba si la fecha de cierre de un proyecto es posterior a la fecha de apertura.
     * @author AnaOrCam
     * @param fecha1 se refiere a la fecha de apertura del proyecto.
     * @param fecha2 se refiere a la fecha de cierre del proyecto.
     * @return devuelve true si la fecha de cierre del proyecto es posterior a la fecha de apertura.
     */
    public static boolean fechaPosterior(LocalDate fecha1, LocalDate fecha2){

        if (fecha2.isAfter(fecha1)){
            return true;
        }
        return false;
    }

    /**
     * Transforma la fecha en de formato String a LocalDate.
     * @author AnaOrCam
     * @param fecha se refiere a la fecha introducida en formato String.
     * @return devuelve la fecha en formato LocalDate.
     */
    public static LocalDate parsearStringALocalDate (String fecha){
        if (comprobacionFormatoFecha(fecha)){
            DateTimeFormatter formatoFechaApp=DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(fecha,formatoFechaApp);
        }
        return null;
    }

    /**
     * Transforma la fecha de formato LocalDate a String.
     * @author AnaOrCam
     * @param fecha se refiere a la fecha introducida en formato LocalDate.
     * @return devuelve la fecha en formato String.
     */
    public static String parsearLocalDateAString (LocalDate fecha){
        return fecha.toString();
    }

    /**
     * Informa de los dias, horas, minutos y segundos restantes entre dos fechas.
     * @author AnaOrCam
     * @param fecha se refiere a la fecha de apertura del proyecto.
     * @param fecha2 se refiere a la fecha de cierre del proyecto.
     * @return devuelve el tiempo de diferencia en formato String.
     */
    public static String tiempoRestanteParaInvertir (LocalDate fecha, LocalDate fecha2){
        long diferenciaDias= ChronoUnit.DAYS.between(fecha,fecha2);
        long diferenciaHoras= ChronoUnit.HOURS.between(fecha,fecha2);
        long diferenciaMinutos= ChronoUnit.MINUTES.between(fecha,fecha2);
        long diferenciaSegundos= ChronoUnit.SECONDS.between(fecha,fecha2);

        return "Quedan "+diferenciaDias+", "+diferenciaHoras+", "+diferenciaMinutos+" y "+diferenciaSegundos+
                " para invertir en este proyecto";
    }
}
