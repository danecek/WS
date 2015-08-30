/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.wadlexample;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author danecek
 */
@Path("countries")
public class CountryResource {

    private final CountryService countryService = new CountryService();

    @GET
    @Produces(MediaType.APPLICATION_XML)
  //  public List<Country> countries() {         
    public List countries() {
        return new ArrayList(countryService.countries());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Country getCountry(
            @PathParam("countryId") int countryId
    ) {
        return countryService.getCountry(countryId);
    }
}
