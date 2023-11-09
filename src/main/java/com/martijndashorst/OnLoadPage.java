package com.martijndashorst;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/onload")
public class OnLoadPage {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance page(int count);
        public static native TemplateInstance page$count(int count);
    }

    @GET
    public TemplateInstance page() {
        return Templates.page(12);
    }

    @GET
    @Path("/count/{count}")
    public TemplateInstance load(@PathParam("count") int count) throws InterruptedException {
        Thread.sleep(100 * Math.max(1, count));
        return Templates.page$count(count - 1);
    }
}
