package thread;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @description TODO
 * @createTime 2021年03月04日 10:44:00
 */
public class NioTest {

    public static void main(String[] args) throws IOException {

        Selector selector=SelectorProvider.provider().openSelector();
    }
}
