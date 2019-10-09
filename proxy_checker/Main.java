import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C://java/ip.txt")); //Ваш путь к файлу
        String line;
        String ip;
        int port;
        while ((line = reader.readLine()) != null) {
            ip = line.split(":")[0];
            port = Integer.parseInt(line.split(":")[1]);
            try {
                checkProxy(ip, port);
            }catch (Exception e) {
                System.out.println("Ip: " + ip + " недоступен");
            }
        }


    }
    public static void checkProxy(String ip, int port) throws IOException {
        String url = "http://q99102ir.beget.tech/";
        Proxy paroxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip,port));
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection(paroxy);
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");


        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println("Your ip: "+response.toString());
    }
}
