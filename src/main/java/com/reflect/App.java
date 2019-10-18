package com.reflect;

import com.reflect.model.User;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IntrospectionException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Field[] fields = User.class.getDeclaredFields();
        fields[0].getType().getName();
        fields[0].getName();
        Method[] methods = User.class.getDeclaredMethods();
        Arrays.asList(fields).stream().forEach(field -> {

            System.out.println(field.getType().getName());
            System.out.println(field.getType());
            System.out.println(field.getDeclaringClass().getTypeName()+"."+field.getName());
        });
        System.out.println("==========================================");
        Arrays.asList(methods).stream().forEach(method -> {
            System.out.println(method.getName());
            System.out.println(method.getGenericExceptionTypes());
            System.out.println(method.getParameterCount());
            System.out.println(method.getParameterTypes());
            System.out.println(method.getReturnType());

        });
        System.out.println("==========================================");
       Constructor[] constructors= User.class.getConstructors();
       Arrays.asList(constructors).stream().forEach(constructor -> {
           try {
               User user=(User)constructor.newInstance();

               user.setName("test");
               System.out.println(methods[0].invoke(user));
           } catch (InstantiationException e) {
               e.printStackTrace();
           } catch (IllegalAccessException e) {
               e.printStackTrace();
           } catch (InvocationTargetException e) {
               e.printStackTrace();
           }
       });
        User user=(User)User.class.getConstructors()[0].newInstance();
        PropertyDescriptor pd = new PropertyDescriptor(fields[0].getName(), User.class);
        Method method=pd.getWriteMethod();
        method.invoke(user,"hello");
        Method method1=pd.getReadMethod();
       System.out.println(method1.invoke(user));
    }
}
