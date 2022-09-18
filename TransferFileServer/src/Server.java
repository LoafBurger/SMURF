import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    public static void main(String[] args) throws IOException {
        //File name but it changes depending
        //on the client so don't worry bout it
        String[] filename = new String[1];

        //Example GUI to know that server is running
        //but it's actually unnecessary
        JFrame jFrame = new JFrame("Server GUI");
        jFrame.setSize(500,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.Y_AXIS));


        jFrame.setVisible(true);

        ServerSocket serverSocket = new ServerSocket(1234);
        //Keep hearing for submit requests
        while(true){
            try {
                Socket socket = serverSocket.accept();
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                int fileNameLength = dataInputStream.readInt();

                if(fileNameLength > 0){
                    byte[] fileNameBytes = new byte[fileNameLength];
                    dataInputStream.readFully(fileNameBytes, 0, fileNameBytes.length);
                    filename[0] = new String(fileNameBytes);

                    int fileContentLength = dataInputStream.readInt();
                    byte[] fileContentBytes = new byte[fileContentLength];
                    dataInputStream.readFully(fileContentBytes, 0, fileContentLength);
                    File fileToDownload = new File(filename[0]);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream("src/Input/"+fileToDownload);
                        fileOutputStream.write(fileContentBytes, 0, fileContentLength);
                    } catch(IOException error) {
                        error.printStackTrace();
                    }
                }
            } catch (IOException error) {
                error.printStackTrace();
            }
        }

    }

}
