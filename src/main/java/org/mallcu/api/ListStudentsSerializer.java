package org.mallcu.api;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * A List of Students serializer.
 * 
 * @author Cesar Flores
 */
public class ListStudentsSerializer extends StdSerializer<List<Student>>{

    public ListStudentsSerializer() {
        this(null);
    }
    
    public ListStudentsSerializer(java.lang.Class<List<Student>> list){
        super(list);
    }
    
    @Override
    public void serialize(List<Student> students, JsonGenerator jsonGen,
            SerializerProvider sp) throws IOException {
        List<Integer> ids = new ArrayList<>();
        students.stream().forEach((student) -> {
            ids.add(student.getId());
        });
        
        jsonGen.writeObject(ids);
    }
    
}
