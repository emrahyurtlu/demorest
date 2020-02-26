package com.company.converter;

import com.company.model.MyDate;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

@Provider
public class MyDateParamConverter implements ParamConverterProvider {
    /*
    * MyDateParamConverter @PathParam ile yakaladığımız değeri
    * istediğimiz tipe çevirmemizi sağladı.
    * */
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if (rawType.getName().equals(MyDate.class.getName())){
            return new ParamConverter<T>() {
                @Override
                public T fromString(String value) {
                    Calendar requestedData = Calendar.getInstance();
                    if (value.equals("tomorrow"))
                        requestedData.add(Calendar.DATE, 1);
                    if (value.equals("yesterday"))
                        requestedData.add(Calendar.DATE, -1);
                    MyDate myDate = new MyDate();
                    myDate.setDay(requestedData.get(Calendar.DATE));
                    myDate.setMonth(requestedData.get(Calendar.MONTH));
                    myDate.setYear(requestedData.get(Calendar.YEAR));
                    return rawType.cast(myDate);
                }

                @Override
                public String toString(T value) {
                    return value.toString();
                }
            };
        }
        return null;
    }
}
