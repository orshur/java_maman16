import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by or on 11/06/17.
 */
public class GameServer
{
    private ServerSocket _server;
    private ExecutorService _gameRunner;

    public GameServer()
    {

        _gameRunner = Executors.newCachedThreadPool();
        try
        {
            _server = new ServerSocket(35715); // set up ServerSocket
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
            System.exit(1);
        }

    }

    public void run()
    {
        while (true)
        {
            try
            {
                MemoryGame game = new MemoryGame(_server.accept(), _server.accept());
                _gameRunner.execute(game);
            }
            catch (IOException ioException)
            {
                ioException.printStackTrace();
                System.exit(1);
            }
        }
    }

    private class MemoryGame implements Runnable
    {

        public MemoryGame(Socket p1Socket, Socket p2Socket)
        {

        }
        @Override
        public void run()
        {

        }
    }
}
