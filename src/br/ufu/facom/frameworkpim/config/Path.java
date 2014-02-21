package br.ufu.facom.frameworkpim.config;

/*
 * Este gerador de caminhos eh um singleton;
 */

public class Path {
    
    private static Path instance;
    private String imagePath;
    
    private Path() {
        String udir = System.getProperty("user.dir");       //diretorio da app.
        String fsep = System.getProperty("file.separator"); //separador de diretorios do SO de uso
        
        this.imagePath = udir + fsep + "images" + fsep;
    }
    
    private static Path getInstance() {
        if (instance == null) {
            instance = new Path();
        }
        return instance;
    }
    
    public static String getImagePath(String filename) {
        return Path.getInstance().imagePath + filename;
    }
    
}
