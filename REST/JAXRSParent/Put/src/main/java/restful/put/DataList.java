package restful.put;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("datalist")
@Singleton
public class DataList {

    List<String> container = new ArrayList<>();

    @PUT
    public synchronized int putDate(String date) {
        container.add(date);
        return container.size();
    }
}
