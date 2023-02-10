package de.f4bii.commandlib.parser;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Date: 02.08.2021
 * <br/>@author FabiHBBBT
 * <br/>
 **/
@Slf4j
public class AdapterWrapper {

    private static final HashMap<Type, CommandParser<?>> adapters = new HashMap<>();

    private AdapterWrapper() {
    }

    public static CommandParser<?> getParser(Class<?> clazz) {
        CommandParser<?> adapter = adapters.get(clazz);
        if (adapter == null) {
            log.warn(clazz.getName() + " has no Adapter registered! Default Adapter will be used! (" + String.class.getName() + ")");
            log.info("§cThis could result in an ClassCastException. Please create a new Adapter for " + clazz.getName());
            adapter = adapters.get(String.class);
        }
        return adapter;
    }


    public static void register(Class<?> type, CommandParser<?> adapter) {
        if (adapters.containsKey(type))
            return;
        adapters.put(type, adapter);
    }

    // Lambdas not working
    public static void register(CommandParser<?> adapter) {
        Type[] genericInterfaces = adapter.getClass().getGenericInterfaces();
        for (Type genericInterface : genericInterfaces) {
            if (genericInterface instanceof ParameterizedType) {
                Type[] genericTypes = ((ParameterizedType) genericInterface).getActualTypeArguments();
                for (Type genericType : genericTypes) {
                    if (((ParameterizedType) genericInterface).getRawType().equals(CommandParser.class)) {
                        log.info("[CommandAPI] Registering: '" + genericType.getTypeName() + "' as an CommandParser");
                        register(genericType.getClass(), adapter);
                    }
                }
            }
        }
    }

}
