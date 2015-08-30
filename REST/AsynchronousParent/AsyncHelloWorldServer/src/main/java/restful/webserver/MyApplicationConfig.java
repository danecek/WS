package restful.webserver;

import java.util.Set;
import javax.ws.rs.core.*;
import javax.ws.rs.*;

@ApplicationPath("webresources")
public class MyApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(restful.tools.MyExceptionMapper.class);
        resources.add(restful.webserver.AsyncResource.class);
    }

}
