/* This class was largely adapted from Lars Vogel's tutorial
 * at http://www.vogella.com/tutorials/JavaXML/article.html
 * https://github.com/vogella
 */

package tracker.include;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLWriter
{
  private File file;

  public void setFile(File file)
  {
      this.file = file;
  }

  public void saveConfig(List<CharacterModel> model) throws Exception
  {
      // create an XMLOutputFactory
      XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
      // create XMLEventWriter
      XMLEventWriter eventWriter = outputFactory
              .createXMLEventWriter(new FileOutputStream(file));
      // create an EventFactory
      XMLEventFactory eventFactory = XMLEventFactory.newInstance();
      XMLEvent end = eventFactory.createDTD("\n");
      XMLEvent tab = eventFactory.createDTD("\t");
      XMLEvent tabs = eventFactory.createDTD("\t\t");
      // create and write Start Tag
      StartDocument startDocument = eventFactory.createStartDocument();
      eventWriter.add(startDocument);

      // create config open tag
      eventWriter.add(end);
      StartElement partyStartElement = eventFactory.createStartElement("",
              "", "characters");
      eventWriter.add(partyStartElement);
      eventWriter.add(end);
      
      for(CharacterModel character : model)
      {
      	eventWriter.add(tab);
      	StartElement characterStartElement = eventFactory.createStartElement("",
      			"", "character");
      	eventWriter.add(characterStartElement);
      	eventWriter.add(eventFactory.createAttribute("index", String.valueOf(character.getIndex())));
      	eventWriter.add(end);
      	
      	createNode(eventWriter, "name", character.getName(), 2);
      	
      	eventWriter.add(tabs);
      	StartElement infoStartElement = eventFactory.createStartElement("",
      			"", "info");
      	eventWriter.add(infoStartElement);
      	eventWriter.add(end);
      	
      	createNode(eventWriter, "background", character.getBackground(), 3);
      	createNode(eventWriter, "class", character.getCl(), 3);
      	createNode(eventWriter, "race", character.getRace(), 3);
      	createNode(eventWriter, "alignment", character.getAlign(), 3);
      	createNode(eventWriter, "exp", String.valueOf(character.getExp()), 3);
      	
      	eventWriter.add(tabs);
      	eventWriter.add(eventFactory.createEndElement("", "", "info"));
        eventWriter.add(end);
        
        eventWriter.add(tabs);
      	StartElement healthStartElement = eventFactory.createStartElement("",
      			"", "health");
      	eventWriter.add(healthStartElement);
      	eventWriter.add(end);
      	
      	createNode(eventWriter, "ac", String.valueOf(character.getAC()), 3);
      	createNode(eventWriter, "sp", String.valueOf(character.getSpeed()), 3);
      	createNode(eventWriter, "hp", String.valueOf(character.getHP()), 3);
      	createNode(eventWriter, "maxhp", String.valueOf(character.getMaxHP()), 3);
      	
      	eventWriter.add(tabs);
      	eventWriter.add(eventFactory.createEndElement("", "", "health"));
        eventWriter.add(end);
        
        eventWriter.add(tabs);
        StartElement statsStartElement = eventFactory.createStartElement("",
        		"", "stats");
      	eventWriter.add(statsStartElement);
      	eventWriter.add(end);		
      	
      	createNode(eventWriter, "str", String.valueOf(character.getStr()), 3);
      	createNode(eventWriter, "dex", String.valueOf(character.getDex()), 3);
      	createNode(eventWriter, "con", String.valueOf(character.getCon()), 3);
      	createNode(eventWriter, "int", String.valueOf(character.getInt()), 3);
      	createNode(eventWriter, "wis", String.valueOf(character.getWis()), 3);
      	createNode(eventWriter, "cha", String.valueOf(character.getCha()), 3);
      	
      	eventWriter.add(tabs);
      	eventWriter.add(eventFactory.createEndElement("", "", "stats"));
        eventWriter.add(end);
        
        eventWriter.add(tab);
      	eventWriter.add(eventFactory.createEndElement("", "", "character"));
        eventWriter.add(end);
      }
      eventWriter.add(eventFactory.createEndElement("", "", "characters"));
      eventWriter.add(end);
      eventWriter.add(eventFactory.createEndDocument());
      eventWriter.close();
  }

  private void createNode(XMLEventWriter eventWriter, String name,
          String value, int tabs) throws XMLStreamException
  {

      XMLEventFactory eventFactory = XMLEventFactory.newInstance();
      XMLEvent end = eventFactory.createDTD("\n");
      XMLEvent tab = eventFactory.createDTD("\t");
      // create Start node
      StartElement sElement = eventFactory.createStartElement("", "", name);
      while(tabs-- != 0)
      {
      	eventWriter.add(tab);
      }
      eventWriter.add(sElement);
      // create Content
      Characters characters = eventFactory.createCharacters(value);
      eventWriter.add(characters);
      // create End node
      EndElement eElement = eventFactory.createEndElement("", "", name);
      eventWriter.add(eElement);
      eventWriter.add(end);

  }

}