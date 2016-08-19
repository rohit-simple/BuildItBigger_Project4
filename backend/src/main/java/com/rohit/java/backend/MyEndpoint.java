/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.rohit.java.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.rohit.java.supplier.joke.JokeCommunicator;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.java.rohit.com",
                ownerName = "backend.java.rohit.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    @ApiMethod(name = "getOneJoke")
    public MyBean getOneJoke(){
        MyBean response = new MyBean();
        response.setData(JokeCommunicator.getAJoke());
        return response;
    }

}
