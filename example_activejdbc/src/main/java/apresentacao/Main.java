package apresentacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import negocio.Person;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.javalite.common.Util;

/**
 *
 * @author iapereira
 */
public class Main {

    public static void main(String[] args) {
        Base.open("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/activejdbc", "postgres", "postgres");
//        objeto se auto-inserindo
        Person p = new Person();
        p.set("first_name", "Marilyn");
        p.set("last_name", "Monroe");
        p.saveIt();
//        listar
        List<Map> vetRaiz = Base.findAll("select * from people;");
        for (int i = 0; i < vetRaiz.size(); i++) {
            Map map = vetRaiz.get(i);
            System.out.println(map.get("first_name"));
        }

//          Person.findFirst("first_name = ?", "Marilyn");
//        
        LazyList<Person> vetNutella = Person.findAll();
//         System.out.println(vetNutella.get(0).get("first_name"));
        for (int i = 0; i < vetNutella.size(); i++) {
            Person p1 = vetNutella.get(i);
            System.out.println(p1);

        }
//         
//        conta qtos people tem
        System.out.println(Base.count("people"));
        Base.close();

    }
}
