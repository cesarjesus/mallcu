package org.mallcu.api;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * A List of Class serializer.
 * 
 * @author Cesar Flores
 */
public class ListClassSerializer extends StdSerializer<List<Class>>{

    public ListClassSerializer() {
        this(null);
    }
    
    public ListClassSerializer(java.lang.Class<List<Class>> list){
        super(list);
    }
    
    @Override
    public void serialize(List<Class> clasz, JsonGenerator jsonGen,
            SerializerProvider sp) throws IOException {
        List<String> ids = new ArrayList<>();
        clasz.stream().forEach((student) -> {
            ids.add(student.getCode());
        });
        
        jsonGen.writeObject(ids);
    }
    
}
