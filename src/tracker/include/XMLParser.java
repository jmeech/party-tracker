/* This class was largely adapted from Lars Vogel's tutorial
 * at http://www.vogella.com/tutorials/JavaXML/article.html
 * https://github.com/vogella
 */

package tracker.include;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLParser
{
	static final String CHARACTER = "character";
	static final String INDEX = "index";
	static final String NAME = "name";
	static final String INFO = "info";
	static final String HEALTH = "health";
	static final String STATS = "stats";
	static final String BACKGROUND = "background";
	static final String CLASS = "class";
	static final String RACE = "race";
	static final String ALIGNMENT = "alignment";
	static final String EXP = "exp";
	static final String AC = "ac";
	static final String SP = "sp";
	static final String HP = "hp";
	static final String MAXHP = "maxhp";
	static final String STR = "str";
	static final String DEX = "dex";
	static final String CON = "con";
	static final String INT = "int";
	static final String WIS = "wis";
	static final String CHA = "cha";

	public List<CharacterModel> readFile(File file)
	{
		List<CharacterModel> items = new ArrayList<CharacterModel>();
		try
		{
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream in = new FileInputStream(file);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			// read the XML document
			CharacterModel newChar = null;

			while (eventReader.hasNext()) 
			{
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement())
				{
					StartElement startElement = event.asStartElement();
					// If we have an item element, we create a new item
					if (startElement.getName().getLocalPart().equals(CHARACTER))
					{
						newChar = new CharacterModel();
						// We read the attributes from this tag and add the date
						// attribute to our object
						Iterator<Attribute> attributes = startElement
								.getAttributes();
						while (attributes.hasNext())
						{
							Attribute attribute = attributes.next();
							if (attribute.getName().toString().equals(INDEX))
							{
								newChar.setIndex(Integer.parseInt(attribute.getValue()));  
							}
						}
					}
					
					// Check for nested elements
					if (event.isStartElement())
					{
						if (event.asStartElement().getName().getLocalPart()
								.equals(BACKGROUND)) 
						{
							event = eventReader.nextEvent();
							newChar.setBackground(event.asCharacters().getData());
							continue;
						}
						
						if (event.asStartElement().getName().getLocalPart()
								.equals(AC)) 
						{
							event = eventReader.nextEvent();
							newChar.setAC(Integer.parseInt(event.asCharacters().getData()));
							continue;
						}
						
						if (event.asStartElement().getName().getLocalPart()
								.equals(STR)) 
						{
							event = eventReader.nextEvent();
							newChar.setStr(Integer.parseInt(event.asCharacters().getData()));
							continue;
						}
					}
					
					// Populate the rest of the elements
					if (event.asStartElement().getName().getLocalPart()
							.equals(NAME)) 
					{
						event = eventReader.nextEvent();
						newChar.setName(event.asCharacters().getData());
						continue;
					}
					
					if (event.asStartElement().getName().getLocalPart()
							.equals(CLASS)) 
					{
						event = eventReader.nextEvent();
						newChar.setCl(event.asCharacters().getData());
						continue;
					}
					
					if (event.asStartElement().getName().getLocalPart()
							.equals(RACE)) 
					{
						event = eventReader.nextEvent();
						newChar.setRace(event.asCharacters().getData());
						continue;
					}
					
					if (event.asStartElement().getName().getLocalPart()
							.equals(ALIGNMENT)) 
					{
						event = eventReader.nextEvent();
						newChar.setAlign(event.asCharacters().getData());
						continue;
					}
					
					if (event.asStartElement().getName().getLocalPart()
							.equals(SP)) 
					{
						event = eventReader.nextEvent();
						newChar.setSpeed(Integer.parseInt(event.asCharacters().getData()));
						continue;
					}
					
					if (event.asStartElement().getName().getLocalPart()
							.equals(HP)) 
					{
						event = eventReader.nextEvent();
						newChar.setHP(Integer.parseInt(event.asCharacters().getData()));
						continue;
					}
					
					if (event.asStartElement().getName().getLocalPart()
							.equals(MAXHP)) 
					{
						event = eventReader.nextEvent();
						newChar.setMaxHP(Integer.parseInt(event.asCharacters().getData()));
						continue;
					}
					
					if (event.asStartElement().getName().getLocalPart()
							.equals(DEX)) 
					{
						event = eventReader.nextEvent();
						newChar.setDex(Integer.parseInt(event.asCharacters().getData()));
						continue;
					}
					
					if (event.asStartElement().getName().getLocalPart()
							.equals(CON)) 
					{
						event = eventReader.nextEvent();
						newChar.setCon(Integer.parseInt(event.asCharacters().getData()));
						continue;
					}
					
					if (event.asStartElement().getName().getLocalPart()
							.equals(INT)) 
					{
						event = eventReader.nextEvent();
						newChar.setInt(Integer.parseInt(event.asCharacters().getData()));
						continue;
					}
					
					if (event.asStartElement().getName().getLocalPart()
							.equals(WIS)) 
					{
						event = eventReader.nextEvent();
						newChar.setWis(Integer.parseInt(event.asCharacters().getData()));
						continue;
					}
					
					if (event.asStartElement().getName().getLocalPart()
							.equals(CHA)) 
					{
						event = eventReader.nextEvent();
						newChar.setCha(Integer.parseInt(event.asCharacters().getData()));
						continue;
					}
				}
				
				// If we reach the end of an item element, we add it to the list
				if (event.isEndElement()) 
				{
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart().equals(CHARACTER))
					{
						items.add(newChar);
					}
				}
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (XMLStreamException e)
		{
			e.printStackTrace();
		}
		return items;
	}
}