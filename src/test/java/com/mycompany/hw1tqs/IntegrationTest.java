/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw1tqs;

import javax.json.JsonObject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Carlos Soares
 */
public class IntegrationTest {
    private javax.ws.rs.client.Client client;
    private javax.ws.rs.client.WebTarget target;
    public IntegrationTest(){}
    @Before
       public void initClient() {
       this.client = ClientBuilder.newClient();
       this.target = client.target("http://www.apilayer.net/api/live?access_key=1e53ee3ddd8c07ab8068ea95519d054b");
       }

        @Test
        public void fetchSingleTodo() {
        Response response = target.path("101").request( MediaType.APPLICATION_JSON).get();
        assertThat( response.getStatus(), CoreMatchers.is(200) );

        JsonObject todo = response.readEntity( JsonObject.class);   	 
        assertFalse( todo.isEmpty());   	 

        }
        @After
	public void cleanup() {
            client.close();
	}
    
}
