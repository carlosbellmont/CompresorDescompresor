import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        comprimir("C:\\Users\\cbell\\OneDrive\\Desktop\\Test", "d.7z", "*.txt");
        descomprimir("C:\\Users\\cbell\\OneDrive\\Desktop\\Test\\d.7z", "C:\\Users\\cbell\\OneDrive\\Desktop\\Test");
    }


    /**
     * @param pathArchivoComprimido es la ruta a la carpeta donde están todos los ficheros que quieres descomprimir
     * @param pathDescompresion es la ruta a la carpeta donde están todos los ficheros que quieres descomprimir
     * @return true si ha habido éxito, false si ha habido alguna excepción
     */
    private static boolean descomprimir(String pathArchivoComprimido, String pathDescompresion) {
        try {
            new ProcessBuilder()
                    .command("C:\\Program Files\\7-Zip\\7z.exe", "x", pathArchivoComprimido, "-o" + pathDescompresion)
                    .redirectError(ProcessBuilder.Redirect.INHERIT)
                    .redirectOutput(ProcessBuilder.Redirect.INHERIT)
                    .start()
                    .waitFor();
            return true;
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param path es la ruta a la carpeta donde están todos los ficheros que quieres comprimir
     * @return true si ha habido éxito, false si ha habido alguna excepción
     */
    private static boolean comprimir(String path, String nombreFicheroComprimido, String ficherosAComprimir) {
        try {
            new ProcessBuilder()
                    .command("C:\\Program Files\\7-Zip\\7z.exe", "a", path + "\\" + nombreFicheroComprimido, path + "\\" + ficherosAComprimir)
                    .redirectError(ProcessBuilder.Redirect.INHERIT)
                    .redirectOutput(ProcessBuilder.Redirect.INHERIT)
                    .start()
                    .waitFor();
            return true;
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
