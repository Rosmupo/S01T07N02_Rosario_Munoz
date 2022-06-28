package EX1;

/*Crea una anotació personalitzada que ha de permetre
serialitzar un objecte Java en un fitxer JSON. L’anotació
ha de rebre el directori on es col·locarà el fitxer
resultant.*/

import com.google.gson.Gson;

import java.io.*;

public class App {

    public static void main(String[] args) {

        Client client = new Client("Rosario");
        writeFile(client);


    }
    @AnnotationJson(nameFile = "client.json")
    private static void writeFile(Client client) {

        Gson gson = new Gson();
        String json = gson.toJson(client);
        System.out.println(json);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("client.json"))) {
            bw.write(json);
            System.out.println("Fichero creado");
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}

