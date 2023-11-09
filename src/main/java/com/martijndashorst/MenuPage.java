package com.martijndashorst;

import java.util.Arrays;
import java.util.List;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/menu")
public class MenuPage {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance page(List<String> menu, String selected);
        public static native TemplateInstance page$content(List<String> menu, String selected);
    }

    List<String> menu = Arrays.asList("Documents", "Projects", "Members", "Admin");

    @GET
    public TemplateInstance page() {
        return Templates.page(menu, "Projects");
    }

    @GET
    @Path("/{item}")
    public TemplateInstance menu(@PathParam("item") String selected) {
        return Templates.page$content(menu, selected);
    }
}
