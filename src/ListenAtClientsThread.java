import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class ListenAtClientsThread extends Thread {

    private List<Socket> clientSockets = null;
    private byte[] buffer = new byte[1];

    ListenAtClientsThread(List<Socket> list){
        this.clientSockets = list;
    }

    @Override
    public void run() {

        super.run();
        while(true){
            for (Socket socket : clientSockets) {
                try {
                    if(socket.getInputStream().read(buffer) > 0){
                        System.out.println("Received command number: " + buffer[0]);
                        //TODO: Handle commands
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
