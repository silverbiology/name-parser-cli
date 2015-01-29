package org.impl;
import org.gbif.nameparser.NameParser;
import org.gbif.nameparser.UnparsableException;
import org.json.simple.JSONObject;
import org.gbif.api.model.checklistbank.ParsedName;
import org.gbif.api.vocabulary.NameType;
import org.gbif.api.vocabulary.Rank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
class NameParserImpl
{
private static NameParser parser;
//Entry point to nameparser
public static void main(String[] args) {
JSONObject obj=new JSONObject();
String name; 
//Handles if there is not argument
 if (args.length == 0) {
        System.err.println("No arguments");
    } else if (args.length == 1) {
			name=args[0];
			NameParser myInstance = new NameParser(); 
 
   try {
      parser = new NameParser(50);
	  ParsedName n = parser.parse(name);
	  //Binding values to JSON object
	 		obj.put("scientificName",n.getScientificName());
			obj.put("type",String.valueOf(n.getType()));
			obj.put("genusOrAbove",n.getGenusOrAbove());
			obj.put("cultivarEpithet",n.getCultivarEpithet());
			obj.put("canonicalName",n.canonicalName());
			obj.put("canonicalNameComplete",n.canonicalNameComplete());
			obj.put("rankMarker",n.getRankMarker());
			obj.put("specificEpithet",n.getSpecificEpithet());
			obj.put("infraSpecificEpithet",n.getInfraSpecificEpithet());
			obj.put("bracketAuthorship",n.getBracketAuthorship()); 
			obj.put("AuthorsParsed", n.isAuthorsParsed());
			obj.put("authorship", n.getAuthorship());
			obj.put("canonicalNameWithMarker", n.canonicalNameWithMarker());
      
    } catch (UnparsableException e) {
      	  obj.put("type","DOUBTFUL");
    }
	System.out.print(obj);
	}
	else {
        System.err.println("Will not use the arguments");
        for (String arg: args) {
            System.err.println(arg);
        }
    }
	
System.exit(0);
}
}