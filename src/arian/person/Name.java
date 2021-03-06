package arian.person;

import arian.lib.Texts;

import java.util.*;

interface SimpleName {
    public String changeName(String firstName, String lastName);
    public String getName(String type);
}

public class Name implements SimpleName {

    private String firstName;
    private String lastName;
    private List<Character> initials;

    public Name(){
        this( "John", "Doe" );
    }
    public Name(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        this.initials = Texts.getAcronymList(this.firstName);
    }

    public String changeName(String firstName, String lastName){
        if( firstName != null ){
            this.firstName = firstName;

            this.initials = Texts.getAcronymList(this.firstName);
        }
        if( lastName != null ){
            this.lastName = lastName;
        }

        return this.toString();
    }

    public String getName(String type){
        switch(type){
            case "first": 
                return this.firstName;
            case "last":
                return this.lastName;
            case "initials":
                return Texts.parseAcronyms( this.initials );
            case "full":
            default:
                return this.toString();
        }
    }
    


    @Override
    public String toString(){
        return this.firstName + " " + this.lastName;
    }
}