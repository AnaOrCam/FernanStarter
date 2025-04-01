package utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class FuncionesFechas {

    /**
     * Comprueba si la fecha de cierre de un proyecto es posterior a la fecha de apertura.
     * @author AnaOrCam
     * @param fecha1 se refiere a la fecha de apertura del proyecto.
     * @param fecha2 se refiere a la fecha de cierre del proyecto.
     * @return devuelve true si la fecha de cierre del proyecto es posterior a la fecha de apertura.
     */
    public static boolean fechaPosterior(LocalDate fecha1, LocalDate fecha2){
        return fecha2.isAfter(fecha1);
    }

    /**
     * Transforma la fecha en de formato String a LocalDateTime.
     * @author AnaOrCam
     * @param fecha se refiere a la fecha introducida en formato String.
     * @return devuelve la fecha en formato LocalDate.
     */
    public static LocalDate parsearStringALocalDate(String fecha){
        DateTimeFormatter formatoFechaApp=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fecha,formatoFechaApp);

    }

    /**
     * Transforma la fecha de formato LocalDateTime a String.
     * @author AnaOrCam
     * @param fecha se refiere a la fecha introducida en formato LocalDate.
     * @return devuelve la fecha en formato String.
     */
    public static String parsearLocalDateAString(LocalDate fecha){
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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
     //   long diferenciaHoras= ChronoUnit.HOURS.between(fecha2,fecha);
     //   long diferenciaMinutos= ChronoUnit.MINUTES.between(fecha2,fecha);
     //   long diferenciaSegundos= ChronoUnit.SECONDS.between(fecha2,fecha);

        return "Quedan "+diferenciaDias+" dias para invertir en este proyecto";
    }
    /**
     * Devuelve el numero de dias restantes , aplicable posteriormente a operador ternario
     * @author davidrn06
     * @param fecha se refiere a la fecha actual.
     * @param fecha2 se refiere a la fecha de cierre del proyecto.
     * @return devuelve el tiempo de diferencia en formato String.
     */
    public static long getTiempoRestanteParaInvertir(LocalDate fecha, LocalDate fecha2){
        long diferenciaDias= ChronoUnit.DAYS.between(fecha,fecha2);
        return  diferenciaDias;

    }
}
