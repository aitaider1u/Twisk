package twisk.outils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class KitC {
    public KitC() {
    }

    public void creerEnvironnement() {
       try{
           // création du répertoire twisk sous /tmp. Ne déclenchepas d’erreur si le répertoire existe déjà
           Path directories = Files.createDirectories(Paths.get("/tmp/twisk"));
           // copie des deux fichiers programmeC.o et def.h depuis le projet sous /tmp/twisk
           String[] liste = {"programmeC.o","def.h","codeNatif.o"};
           for(String nom : liste){
                InputStream source = getClass().getResource("/codeC/"+ nom).openStream();
                File destination = new File("/tmp/twisk/"+nom);
                copier(source, destination);
                //Path source = Paths.get(getClass().getResource("/codeC/"+ nom).getPath());
                //Path newdir = Paths.get("/tmp/twisk/");
                //Files.copy(source, newdir.resolve(source.getFileName()),REPLACE_EXISTING);
           }
       }catch(IOException e) {
           e.printStackTrace();
       }
    }

    private void copier(InputStream source,File dest) throws FileNotFoundException {
        InputStream sourceFile = source;
        OutputStream destinationFile = new FileOutputStream(dest);
        //lecture  de segment
        byte buffer[] = new byte[512 * 1024];
        int nbLecture;
        try {
            while ((nbLecture = sourceFile.read(buffer)) != -1) {
                destinationFile.write(buffer, 0, nbLecture);
            }
            destinationFile.close();
            sourceFile.close();
        }catch (Exception e)
        {
            e.getMessage();
        }
    }

    /**
     * Methode creant le fichier client.c en y copiant le code C relatif au monde crée
     * @param codeC String : le code C du Monde
     */
    public void creerFichier(String codeC){
        try
        {
            File code = new File("/tmp/twisk/client.c");
            //if(! code.exists())
            code.createNewFile();
            FileWriter fw = new FileWriter(code.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(codeC);
            bw.close();
        }
        catch (Exception e )
        {
            e.getMessage();
        }
    }


    /**
     * Methode compilant le code de client.c et affichant les messages inérant à la
     * compilation sur la sortie standard
     */
    public void compiler(){
        try{
            Runtime runtime = Runtime.getRuntime();
            Process p = runtime.exec("gcc   -Wall   -fPIC  -c /tmp/twisk/client.c   -o   /tmp/twisk/client.o");
            p.waitFor();
            // récupération des messages sur la sortie standardet la sortie d’erreur de la commande exécutée
            //à reprendre éventuellement et à adapter à votrecode
            BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String ligne ;
            while((ligne = output.readLine()) !=null)
            {
                System.out.println(ligne);
            }
            while((ligne = error.readLine()) !=null)
            {
                System.out.println(ligne);
            }

        }catch(IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Methode de construction de la librairie C
     */
    public void construireLaLibrairie()
    {
        try{
            Runtime runtime = Runtime.getRuntime();
            Process p = runtime.exec("gcc   -shared   /tmp/twisk/programmeC.o   /tmp/twisk/codeNatif.o   /tmp/twisk/client.o   -o   /tmp/twisk/libTwisk.so");
            p.waitFor();
             // récupération des messages sur la sortie standardet la sortie d’erreur de la commande exécutée
            //à reprendre éventuellement et à adapter à votrecode
            BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String ligne ;
            while((ligne = output.readLine()) !=null)
            {
                System.out.println(ligne);
            }
            while((ligne = error.readLine()) !=null)
            {
                System.out.println(ligne);
            }

        }catch(IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }


}
