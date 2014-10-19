package jaxb.xjc;

import generated.ObjectFactory;
import generated.PersonListType;
import generated.PersonType;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Marshalling {

    public static void main(String[] args) throws JAXBException {
        ObjectFactory of = new ObjectFactory();
        PersonListType personList = of.createPersonListType();
        List<JAXBElement<PersonType>> personListElement = personList.getMaleOrFemale();
        PersonType person = of.createPersonType();
        person.setName("Jane");
        JAXBElement<PersonType> personElem = of.createPersonListTypeFemale(person);
        personListElement.add(personElem);
        person = of.createPersonType();
        person.setName("John");
        personElem = of.createPersonListTypeMale(person);
        personListElement.add(personElem);
        JAXBElement<PersonListType> root = of.createPersonList(personList);
        JAXBContext context = JAXBContext.newInstance("generated");
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(root, System.out);

    }
}
