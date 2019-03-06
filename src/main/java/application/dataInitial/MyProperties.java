package application.dataInitial;


import application.MainSpringBootApplicaton;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


@Getter
@Data
public class MyProperties {

    private Properties prop;
    private String nameFileProperties = "application.properties";

   private InputStream inputStream;





    public MyProperties(String nameFileProperties)
    {
        this.nameFileProperties = nameFileProperties;

        inputStream = MainSpringBootApplicaton.class.getClassLoader().getResourceAsStream(nameFileProperties);
    }


    public String getPropertiesParam(String nameProp)
    {

        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


        return prop.getProperty(nameProp);
    }




}
