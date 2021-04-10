
package co.edu.unipiloto.services;

import co.edu.unipiloto.Person.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("services")
public class Service {

    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();

    static {

        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            int id = i + 1;
            int age = new Random().nextInt(40) + 1;
            double salary = (980.657 * age) / 3;
            person.setId(id);
            person.setFullName("Persona " + id);
            person.setAge(age);
            person.setSalary(salary);
            persons.put(id, person);
        }
    }

    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByIdXML(@PathParam("id") int id) {

        return persons.get(id);
    }

    @GET
    @Path("/getPersonByIdJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJSON(@PathParam("id") int id) {
        return persons.get(id);
    }

    @GET
    @Path("/getAllPersonsInXML/")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonsInXML() {

        return new ArrayList<>(persons.values());
    }

    @GET
    @Path("/getSalaryAverageInXML/")
    @Produces(MediaType.APPLICATION_XML)
    public double getSalaryAverageInXLM() {
        double salarioTotal = 0;
        int contador = 0;
        ArrayList<Person> sumTotal = new ArrayList<>(persons.values());
        for (Person persons : sumTotal) {
            salarioTotal += persons.getSalary();
            contador++;
        }
        return salarioTotal/contador;
    }

    @GET
    @Path("/getAllSalaryInJSON/")
    @Produces(MediaType.APPLICATION_JSON)
    public double getAllSalaryInJSON() {
        double salarioTotal = 0;
        ArrayList<Person> sumTotal = new ArrayList<>(persons.values());
        for (Person persons : sumTotal) {
            salarioTotal += persons.getSalary();
        }
        return salarioTotal;
    }
    
}
