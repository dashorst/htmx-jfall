package com.martijndashorst;

import java.util.List;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/hxdelete")
public class HxDeletePage {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance page(List<String> speakers);
        public static native TemplateInstance speakers(List<String> speakers);
    }

    @Inject
    Conference conference;

    @GET
    public TemplateInstance page() {
        return Templates.page(conference.speakers().subList(0, 7));
    }

    @GET
    @Path("/reset")
    public TemplateInstance reset() {
        conference.reset();
        return Templates.speakers(conference.speakers().subList(0, 7));
    }

    @DELETE
    @Path("/delete/{name}")
    public Response delete(@PathParam("name") String name) {
        if (!conference.delete(name)) {
            return Response.status(Status.NOT_FOUND).entity(name).build();
        }
        return Response.ok().build();
    }
}
