package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
class Validator {
    public static List<String> validate(Object object) {
        ArrayList<String> validList = new ArrayList<>();
        try {
            Class<?> aClass = object.getClass();
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(NotNull.class)) {
                    // TODO не до конца понял использования setAccessible(true) если мы пользуемся методом getDeclaredFields()
                    field.setAccessible(true);
                    Object value = field.get(object);
                    if (value == null) {
                        validList.add(field.getName());
                    }
                }
            }
            // TODO не уверен правильно ли обрабатывается ошибка при работе с рефлекшен. нужно ли нам делать кастомную ошибку?
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return validList;
    }

    public static Map<String, List<String>> advancedValidate(Object object) {
        Map<String, List<String>> validList = new HashMap<>();
        try {
            Class<?> aClass = object.getClass();
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(NotNull.class)) {
                    field.setAccessible(true);
                    Object value = field.get(object);
                    if (value == null) {
                        // TODO не уверен что правильно реализовал работу с Map<List> но как иначе делать проверку создан ли лист уже?
                        addRecordToMap(field.getName(), "can not be null", validList);
                    }
                }
                if (field.isAnnotationPresent(MinLength.class)) {
                    MinLength annotation = field.getAnnotation(MinLength.class);
                    field.setAccessible(true);
                    int minLength = annotation.minLength();
                    Object value = field.get(object);
                    // TODO получилось не красивое решение проверки null второй раз. может как то принято по другому это проверять?
                    if (value != null) {
                        int currentLength = field.get(object).toString().length();
                        if (currentLength < minLength) {
                            addRecordToMap(field.getName(), "length less than " + minLength, validList);
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return validList;
    }

    private static Map<String, List<String>> addRecordToMap(String key, String error, Map<String, List<String>> validList) {
        if (validList.containsKey(key)) {
            validList.get(key).add(error);
        } else {
            validList.put(key, List.of(error));
        }
        return validList;
    }
}

// END
