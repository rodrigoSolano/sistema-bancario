// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com
package Model.cuentas;

import java.util.ArrayList;

public class Propietario {
    private final String nombre;
    private final String apellidoPaterno;
    private final String apellidoMaterno;
    private final String rfc;
    private String direccion;
    private String telefono;
    private ArrayList<Cuenta> cuentas;

    public Propietario(String nombre, String apellidoPaterno, String apellidoMaterno, String direccion, String telefono, String rfc) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccion = direccion;
        this.telefono = telefono;
        this.rfc = rfc;
    }

    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return 	"Nombre: " + nombre +
    			"\nApellido paterno: " + apellidoPaterno +
    			"\nApellido materno: " + apellidoMaterno +
    			"\nTelefono: " + telefono +
    			"\nDireccion: "+ direccion +
    			"\nRFC: "+ rfc;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getRfc() {
        return rfc;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }
}
