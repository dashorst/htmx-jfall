package com.martijndashorst;

import java.util.List;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/changetoedit")
@Produces(MediaType.TEXT_HTML)
public class ChangeToEditPage {
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
        return Templates.page(conference.speakers().subList(0, 7));
    }

    @GET
    @Path("/{speaker}/edit")
    public TemplateInstance edit(String speaker) {
        return Templates.edit(speaker);
    }

    @POST
    @Path("/{speaker}/edit")
    public TemplateInstance update(@PathParam("speaker") String oldSpeaker, @FormParam("newName") String newSpeaker) {
        conference.update(oldSpeaker, newSpeaker);
        return Templates.page$speakers(conference.speakers().subList(0, 7));
    }
}
