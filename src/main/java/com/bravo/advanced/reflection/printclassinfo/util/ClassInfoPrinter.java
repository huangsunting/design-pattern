package com.bravo.advanced.reflection.printclassinfo.util;

import java.lang.reflect.Executable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class ClassInfoPrinter {

    private ClassInfoPrinter() {
    }

    /**
     * 打印泛型信息
     */
    public static void print(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedTypeSuperclass = (ParameterizedType) type;

            // 强转后可用的方法变多了，比如getActualTypeArguments()可以获取Class BaseDao<User>的泛型的实际类型参数User
            Type[] actualTypeArguments = parameterizedTypeSuperclass.getActualTypeArguments();

            // 由于A类只有一个泛型，这里可以直接通过actualTypeArguments[0]得到子类传递的实际类型参数
            List<String> genericTypeNames = new ArrayList<>();
            for (Type actualTypeArgument : actualTypeArguments) {
                Class<?> actualTypeClass = (Class<?>) actualTypeArgument;
                genericTypeNames.add(actualTypeClass.getName());
            }
            System.out.println(type.getTypeName() + "\n\t\t- " + genericTypeNames);
        } else {
            System.out.println(type.getTypeName() + "： " + "\n\t\t- 没有泛型信息");
        }
    }

    /**
     * 打印Class/Method信息
     */
    public static void print(Executable[] targets) {
        for (Executable target : targets) {
            // 修饰符
            StringBuilder sb = new StringBuilder(getModifierDesc(target.getModifiers()) + " ");
            // 方法名
            sb.append(target.getName());
            // 参数列表
            sb.append('(');
            Class<?>[] clazzParams = target.getParameterTypes();
            for (Class<?> clazzParam : clazzParams) {
                sb.append(clazzParam.getName()).append(", ");
            }
            if (clazzParams.length != 0) {
                sb.delete(sb.length() - 2, sb.length());
            }
            sb.append(')');
            // 打印
            System.out.println(sb);
        }
    }

    /**
     * 打印Class/Method信息
     */
    public static void print(Executable target) {
        print(new Executable[]{target});
    }

    private static String getModifierDesc(int modifier) {
        if (Modifier.isPublic(modifier)) {
            return "public";
        }
        if (Modifier.isPrivate(modifier)) {
            return "private";
        }
        if (Modifier.isProtected(modifier)) {
            return "protected";
        }
        if (Modifier.isStatic(modifier)) {
            return "static";
        }
        if (Modifier.isFinal(modifier)) {
            return "final";
        }
        return "";
    }
}
