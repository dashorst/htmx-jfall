package com.martijndashorst;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class IndexPage {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance page();
    }
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance page() {
        return Templates.page();
    }
}
