package com.martijndashorst;

import java.util.List;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/viewtransition")
public class ViewTransitionPage {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance page(List<String> speakers);
        public static native TemplateInstance page$speakers(List<String> speakers);
        public static native TemplateInstance edit(String oldName);
    }

    @Inject
    Conference conference;

    @GET
    public TemplateInstance page() {
        return Templates.page(conference.speakers().subList(0, 5));
    }

    @GET
    @Path("/{speakername}/edit")
    public TemplateInstance edit(@PathParam("speakername") String speakername) {
        return Templates.edit(speakername);
    }

    @POST
    @Path("/{speakername}/save")
    public TemplateInstance save(@PathParam("speakername") String oldName, @FormParam("newName") String newName) {
        conference.update(oldName, newName);
        return Templates.page$speakers(conference.speakers().subList(0, 5));
    }
}
