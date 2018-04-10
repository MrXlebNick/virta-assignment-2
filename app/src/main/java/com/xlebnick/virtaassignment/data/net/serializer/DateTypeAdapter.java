package com.xlebnick.virtaassignment.data.net.serializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by XlebNick for VirtaAssignment.
 */

public class DateTypeAdapter implements JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        try {
            String dateString = json.getAsString();
            if (dateString.length() > 19) {
                dateString = dateString.substring(0, 19);
            }
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}