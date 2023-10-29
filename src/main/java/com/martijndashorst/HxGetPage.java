package com.martijndashorst;

import java.util.Collections;
import java.util.List;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hxget")
public class HxGetPage {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance page();
        public static native TemplateInstance speakers(List<String> speakers);
    }

    @Inject
    Conference conference;

    @GET
    public TemplateInstance page() {
        return Templates.page();
    }

    @GET
    @Path("/speakers")
    public TemplateInstance speakers() {
        var tmp = conference.speakers();
        Collections.shuffle(tmp);
        return Templates.speakers(tmp.subList(0, 7));
    }
}
