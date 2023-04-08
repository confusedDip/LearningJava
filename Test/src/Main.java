import org.ow2.authzforce.core.pdp.impl.PdpEngineConfiguration;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final PdpEngineConfiguration pdpEngineConf = PdpEngineConfiguration.getInstance("pdp.xml");
    }
}
