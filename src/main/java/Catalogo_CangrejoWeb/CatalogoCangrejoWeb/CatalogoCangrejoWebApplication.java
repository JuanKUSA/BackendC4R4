//modelo
//interface  trae find updates deletes ... etc
//repositorio
//servicio
//controllador
package Catalogo_CangrejoWeb.CatalogoCangrejoWeb;

import Catalogo_CangrejoWeb.CatalogoCangrejoWeb.interfaces.InterfaceOrder;
import Catalogo_CangrejoWeb.CatalogoCangrejoWeb.interfaces.InterfaceSupplement;
import Catalogo_CangrejoWeb.CatalogoCangrejoWeb.interfaces.InterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class CatalogoCangrejoWebApplication implements CommandLineRunner {

    @Autowired
    private InterfaceSupplement interfaceSupplement;
    @Autowired
    private InterfaceUser interfaceUser;
     @Autowired
    private InterfaceOrder interfaceOrder;

    public static void main(String[] args) {
        SpringApplication.run(CatalogoCangrejoWebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        interfaceSupplement.deleteAll();
        interfaceUser.deleteAll();
        interfaceOrder.deleteAll();
    }

}
