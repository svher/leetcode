package others.reflection_1;

import lombok.AllArgsConstructor;
import lru_cache.LRUCache_2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {
    @AllArgsConstructor
    static class Test {
        private int val;

        @TestAnnotation("hello world")
        void insert(int arg0, @Deprecated Test arg1) {

        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface TestAnnotation {
        String value();
    }

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        Method method = Test.class.getDeclaredMethod("insert", int.class, Test.class);
        TestAnnotation annotation = method.getAnnotation(TestAnnotation.class);
        System.out.println(annotation.value());
        Annotation[][] annotations = method.getParameterAnnotations();

        int idx = -1;
        for (int i = 0; i < annotations.length; i++) {
            for (Annotation annotation1 : annotations[i]) {
                if (annotation1 instanceof Deprecated) {
                    idx = i;
                    break;
                }
            }
        }
        Parameter parameter = method.getParameters()[idx];
        Field field = parameter.getType().getDeclaredField("val");
        field.setAccessible(true);
        Integer val = (Integer) field.get(new Test(1));
        System.out.println(val);
    }
}
