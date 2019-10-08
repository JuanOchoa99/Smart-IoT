/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.piico.piicows.controller.ws;

import co.edu.usbbog.datan.piico.piicows.controller.persistence.ActuadorFacade;
import co.edu.usbbog.datan.piico.piicows.controller.persistence.DatoFacade;
import co.edu.usbbog.datan.piico.piicows.controller.persistence.SensorFacade;
import co.edu.usbbog.datan.piico.piicows.model.Actuador;
import co.edu.usbbog.datan.piico.piicows.model.Sensor;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.jws.WebParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;

/**
 * REST Web Service
 *
 * @author 305
 */
@Path("frontws")
public class FrontWS {

    @Context
    private UriInfo context;
    
    @EJB
    ActuadorFacade actuadorFacade;
    SensorFacade sensorFacade;

    //Actuador
    
    /**
     * Metodo para insertar un nuevo actuador
     * @param id identificador del actuador
     * @return Datos del nuevo actuador
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertarActuador")
    public String insertarActuador(@WebParam(name = "id") String id) {
        Actuador a = new Gson().fromJson(id, Actuador.class);
        actuadorFacade.create(a);
        return new Gson().toJson(a);    
    }
    
    /**
     * Metodo para editar actuador
     * @param id identificador del actuador
     * @return Datos modificados del actuador
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/modificarActuador")
    public String modificarActuador(@WebParam(name = "id") String id) {
        Actuador a = new Gson().fromJson(id, Actuador.class);
        actuadorFacade.edit(a);
        return new Gson().toJson(a);
    }
    
    /**
     * Metodo para eliminar actuador
     * @param id identificador del actuador
     * @return Si el actuador se elimina devuelve "Actuador eliminado", de lo contrario "No existe el actuador"
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/eliminarActuador")
    public String eliminarActuador(@WebParam(name = "id") String id) {
        
        try{
        Actuador a = new Gson().fromJson(id, Actuador.class);
        actuadorFacade.remove(a);
        return "{\"mensaje\": \"Actuador eliminado\"}";
        } catch (EJBException e) {
            return "{\"error\": \"No existe el actuador\"}";
        }
    }
    
    /**
     * Metodo para mostrar todos los actuadores existentes
     * @return Actuadores existentes
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscarTodosLosActuadores")
    public String buscarTodosLosActuadores() {
        List<Actuador> usuarios = actuadorFacade.findAll();
        String salida = "[";
        for (Actuador a : usuarios) {
            salida += new Gson().toJson(a)+",";
        }
        salida=quitarComa(salida);
        salida += "]";
        return salida;
    }
    
    /**
     * Metodo para buscar actuador
     * @param id identificador del actuador
     * @return Datos del actuador
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscarActuador")
    public String buscarActuador(@WebParam(name = "id") String id) {
        Actuador a = new Gson().fromJson(id, Actuador.class);
        a=actuadorFacade.find(a.getId());
        return new Gson().toJson(a);
    }
    
     /**
     * Metodo para contar todos los actuadores existentes
     * @return Numero deActuadores existentes
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/contarTodosLosActuadores")
    public String contarTodosLosActuadores() {
        return "El numero de actuadores ecistentes es: "+actuadorFacade.count();
    }
    
    //Actuador
    
    /**
     * Metodo para insertar un nuevo sensor
     * @param id identificador del sensor
     * @return Datos del nuevo sensor
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertarSensor")
    public String insertarSensor(@WebParam(name = "id") String id) {
        Sensor s = new Gson().fromJson(id, Sensor.class);
        sensorFacade.create(s);
        return new Gson().toJson(s);    
    }
    
    /**
     * Metodo para editar sensor
     * @param id identificador del sensor
     * @return Datos modificados del sensor
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/modificarSensor")
    public String modificarSensor(@WebParam(name = "id") String id) {
        Sensor s = new Gson().fromJson(id, Sensor.class);
        sensorFacade.edit(s);
        return new Gson().toJson(s);
    }
    
    /**
     * Metodo para eliminar sensor
     * @param id identificador del sensor
     * @return Si el sensor se elimina devuelve "Sensor eliminado", de lo contrario "No existe el sensor"
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/eliminarSensor")
    public String eliminarSensor(@WebParam(name = "id") String id) {
        
        try{
        Sensor s = new Gson().fromJson(id, Sensor.class);
        sensorFacade.remove(s);
        return "{\"mensaje\": \"Sensor eliminado\"}";
        } catch (EJBException e) {
            return "{\"error\": \"No existe el sensor\"}";
        }
    }
    
    /**
     * Metodo para mostrar todos los sensores existentes
     * @return Sensores existentes
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscarTodosLosSensores")
    public String buscarTodosLosSensores() {
        List<Sensor> sensores = sensorFacade.findAll();
        String salida = "[";
        for (Sensor s : sensores) {
            salida += new Gson().toJson(s)+",";
        }
        salida=quitarComa(salida);
        salida += "]";
        return salida;
    }
    
    /**
     * Metodo para buscar sensor
     * @param id identificador del sensor
     * @return Datos del sensor
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscarSensor")
    public String buscarSensor(@WebParam(name = "id") String id) {
        Sensor s = new Gson().fromJson(id, Sensor.class);
        s=sensorFacade.find(s.getId());
        return new Gson().toJson(s);
    }
    
     /**
     * Metodo para contar todos los sensores existentes
     * @return Numero de Sensores existentes
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/contarTodosLosSensores")
    public String contarTodosLosSensores() {
        return "El numero de sensores existentes es: "+sensorFacade.count();
    }
    
    
    @POST  
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        
        return "{valor:\"HOLA\"}";
    }

    /**
     * PUT method for updating or creating an instance of FrontWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    public String quitarComa(String str) {
        if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == ',') {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}
