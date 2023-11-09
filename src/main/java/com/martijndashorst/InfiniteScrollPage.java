package com.martijndashorst;

import java.util.List;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/infinitescroll")
public class InfiniteScrollPage {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance page(List<String> speakers);
        public static native TemplateInstance page$speakers(List<String> speakers);
    }

    @Inject
    Conference conference;

    @GET
    public TemplateInstance page() {
        return Templates.page(conference.randomSpeakers(3));
    }
    @GET
    @Path("/speakers")
    public TemplateInstance speakers(@QueryParam("page") int pagenr) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        return Templates.page$speakers(conference.randomSpeakers(3));
    }
}
