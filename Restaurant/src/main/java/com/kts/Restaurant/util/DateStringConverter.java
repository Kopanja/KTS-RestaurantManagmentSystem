package com.kts.Restaurant.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.neo4j.core.convert.Neo4jPersistentPropertyConverter;
import org.neo4j.driver.Value;

public class DateStringConverter implements Neo4jPersistentPropertyConverter<Date> {

    @Override
    public Value write(Date source) {
        System.out.println("WRITE");
        System.out.println(source);
        return (Value) source;
    }

    @Override
    public Date read(Value source) {
        System.out.println(source.asString());
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(source.asString());
            System.out.println("Uspeo da parsiram");
            return date;
        } catch (ParseException e) {
            System.out.println("Nisam uspeo da parsiram");
            return null;
        }
    }

    public LocZalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

}
