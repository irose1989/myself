package copybean;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;


public class BeanCompare {

    public static <A, B> B convertCopyAToB(A armory, B idcm, String[]... params) {
        int index = 0;
        int k = 0;
        int times = 0;
        copy: while (times++ < params[1].length) {
            String propertiesArmory = params[k++][index];
            String propertiesIdcm = params[k][index++];
            try {
                Method getArmory = armory.getClass().getMethod("get" + propertiesArmory, null);
                if (getArmory.invoke(armory, null) != null
                    && StringUtils.isNotBlank((String) getArmory.invoke(armory, null))) {
                    if ("Integer".equals(params[k][index]) || "Int".equals(params[k][index])) {
                        Method setIdcm = idcm.getClass().getMethod("set" + propertiesIdcm, Integer.class);
                        setIdcm.invoke(idcm, Integer.parseInt((String) getArmory.invoke(armory, null)));
                    } else if ("Long".equals(params[k][index])) {
                        Method setIdcm = idcm.getClass().getMethod("set" + propertiesIdcm, Long.class);
                        setIdcm.invoke(idcm, Long.parseLong((String) getArmory.invoke(armory, null)));
                    } else if ("Character".equals(params[k][index]) || "char".equals(params[k][index])) {
                        Method setIdcm = idcm.getClass().getMethod("set" + propertiesIdcm, Character.class);
                        setIdcm.invoke(idcm, ((String) getArmory.invoke(armory, null)).charAt(0));
                    } else if ("Boolean".equals(params[k][index])) {
                        Method setIdcm = idcm.getClass().getMethod("set" + propertiesIdcm, Boolean.class);
                        setIdcm.invoke(idcm,
                                       "true".equalsIgnoreCase(((String) getArmory.invoke(armory, null))) ? true : false);
                    } else if ("Date".equals(params[k][index])) {
                        Method setIdcm = idcm.getClass().getMethod("set" + propertiesIdcm, Date.class);
                        setIdcm.invoke(idcm, new Date(Long.parseLong((String) getArmory.invoke(armory, null))));
                    } else {
                        Method setIdcm = idcm.getClass().getMethod("set" + propertiesIdcm, String.class);
                        setIdcm.invoke(idcm, (String) getArmory.invoke(armory, null));
                    }
                }
            } catch (Exception e) {
                if (times++ < params[0].length) {
                    continue copy;
                }
            }
            index++;
            k = 0;
            times++;
        }

        return idcm;
    }

   

    /**
     * 切割
     * 
     * @param param
     * @return
     */
    public static String[] splitParams(String param) {
        String[] params = param.split(",");
        return params;
    }

    public static <T> String[] getPropertiesAndType(Class<T> t, Integer end) {
        String className = t.getCanonicalName();
        StringBuffer sb = new StringBuffer("");
        StringBuffer temp;
        try {
            Class clazz = Class.forName(className);
            Field[] fields = clazz.getDeclaredFields();
            int i = 1;
            for (Field f : fields) {
                if (i > end) {
                    break;
                }
                StringBuffer type = new StringBuffer(f.getType().toString());
                if (type.lastIndexOf(".") > 0) {
                    type = new StringBuffer(type.substring(type.lastIndexOf(".") + 1, type.length()));
                } else {
                    type = type.replace(0, 1, (char) (type.charAt(0) - 32) + "");
                }
                temp = new StringBuffer(f.getName());
                sb.append((temp.replace(0, 1, (char) (f.getName().charAt(0) - 32) + "") + ","));
                sb.append(type + ",");
                i++;
            }
            sb.replace(sb.length() - 1, sb.length(), "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString().split(",");
    }

    public static <T> Class[] getPropertiesType(Class<T> t, Integer end) {
        String className = t.getCanonicalName();
        Class[] types = new Class[end];
        try {
            Class clazz = Class.forName(className);
            Field[] fields = clazz.getDeclaredFields();
            int i = 0;
            for (Field f : fields) {
                if (i > end) {
                    break;
                }
                types[i] = f.getType();
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return types;
    }

    public static <T> String[] getProperties(Class<T> t, Integer end) {
        String className = t.getCanonicalName();
        StringBuffer sb = new StringBuffer("");
        StringBuffer temp;
        try {
            Class clazz = Class.forName(className);
            Field[] fields = clazz.getDeclaredFields();
            int i = 1;
            for (Field f : fields) {
                if (i > end) {
                    break;
                }
                temp = new StringBuffer(f.getName());
                sb.append((temp.replace(0, 1, (char) (f.getName().charAt(0) - 32) + "") + ","));
                i++;
            }
            sb.replace(sb.length() - 1, sb.length(), "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString().split(",");
    }

}
