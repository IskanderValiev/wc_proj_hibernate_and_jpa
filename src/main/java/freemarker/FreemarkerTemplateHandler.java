package freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreemarkerTemplateHandler {

    public static void addObject(String name, Object value, String templateName) {

        //freemarker configuration object
        Configuration cfg = new Configuration();

        try {
            //loading template from source folder
            Template template = cfg.getTemplate("/worldcup/freemarker/" + templateName + ".ftl");

            //build the data-model
            Map<String, Object> data = new HashMap<>();
            data.put(name, value);

            //list parsing
//            List<String> countries = new ArrayList<>();
//            countries.add("Russia");
//            countries.add("Germany");
//            countries.add("Portugal");
//            data.put("countries", countries);

            //console output
            Writer out = new OutputStreamWriter(System.out);
            template.process(data, out);

            //file output
            Writer fileWriter = new FileWriter(new File(template.getName()));
            template.process(data, fileWriter);
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException ex) {
            ex.printStackTrace();
        }
    }

    public void showUsersData(String login,
                              String name,
                              String gender,
                              String bday,
                              String city,
                              String telephone,
                              String email,
                              String image,
                              String templateName)  throws IOException, TemplateException{
        Configuration cfg = new Configuration();

        Template template = cfg.getTemplate("/webapp/worldcup/freemarker/" + templateName + ".ftl");

        Map<String, Object> data = new HashMap<>();
        data.put("name", name);
        data.put("gender", gender);
        data.put("bday", bday);
        data.put("city", city);
        data.put("telephone", telephone);
        data.put("email", email);
        data.put("image", image);

        //console output
        Writer out = new OutputStreamWriter(System.out);
        template.process(data, out);

        //file output
        Writer fileWriter = new FileWriter(new File("/webapp/worldcup/freemarker/" + templateName + ".ftl"));
        template.process(data, fileWriter);
        fileWriter.flush();
        fileWriter.close();
    }
}
