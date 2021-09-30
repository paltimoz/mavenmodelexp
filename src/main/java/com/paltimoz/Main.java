package com.paltimoz;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("C:/Users/TCIZOZTURK/Desktop/JavaExp/mavenmodelexp/pom.xml");
        try {
            MavenXpp3Reader xpp3Reader = new MavenXpp3Reader();
            Model model = xpp3Reader.read(reader);
            List<String> objects = model.getBuild().getPlugins().stream()
                    .map(plugin -> (Xpp3Dom) plugin.getConfiguration())
                            .map(xpp3Dom -> Arrays.stream(xpp3Dom.getChildren())
                                    .filter(item -> item.getName().equals("packageName")).findFirst().get().getValue())
                                    .collect(Collectors.toList());

            System.out.println(objects.get(0));
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }
}
