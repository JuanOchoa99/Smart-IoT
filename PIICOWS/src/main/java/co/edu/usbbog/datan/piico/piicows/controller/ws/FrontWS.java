/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.piico.piicows.controller.ws;

import co.edu.usbbog.datan.piico.piicows.controller.persistence.DatoFacade;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

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
    private DatoFacade datoFacade;

    /**
     * Creates a new instance of FrontWS
     */
    public FrontWS() {
    }

    /**
     * Retrieves representation of an instance of co.edu.usbbog.datan.piico.piicows.controller.ws.FrontWS
     * @return an instance of java.lang.String
     */
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
}
