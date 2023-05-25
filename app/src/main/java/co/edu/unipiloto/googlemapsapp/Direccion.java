package co.edu.unipiloto.googlemapsapp;

public class Direccion {

    public static double getLatitud(String paciente){

        double latitud = 0;

        switch(paciente){
            case "Juan":
                latitud = 4.632339710;
                break;
            case "David":
                latitud = 4.705125091923207;
                break;
            case "Andres":
                latitud = 4.664654054665957;
        }

        return latitud;
    }

    public static double getLongitud(String paciente){

        double longitud = 0;

        switch(paciente){
            case "Juan":
                longitud = -74.065350;
                break;
            case "David":
                longitud = -74.04218431241196;
                break;
            case "Andres":
                longitud = -74.13000055429187;
        }

        return longitud;
    }
}
