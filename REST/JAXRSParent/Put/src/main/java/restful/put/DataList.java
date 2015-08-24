package restful.put;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("datalist")
public class DataList {

    static List<String> container = new ArrayList<>();

    @PUT
    public int putDate(String date) {
        container.add(date);
        return container.size();
    }
}
