package com.tencent.dao;

import com.tencent.utils.StringUtils;
import com.tencent.vo.BaseEntity;
import com.tencent.vo.Line;

import javax.swing.*;
import java.lang.reflect.*;
import java.sql.*;
import java.util.*;

public class BaseDao <T extends  BaseEntity> {

    private Class <T> entityClass = initEntityClass();

    private BaseEntity entity;

    private Class<T> initEntityClass(){
        Class<T> entityClass = null;
        Class clazz = getClass();
        // 获取当前类名
        String curClassName = getCurrentClassName();
        if(!curClassName.equals(clazz.getName())){
            // 实例化BaseDao的子类对象
            /*
             * 这里实际就是使用子类对象调用getClass().getGenericSuperclass() 方法
             * 就能够拿到这样的Type对象
             * com.tencent.dao.BaseDao<com.tencent.entity.UserEntity>
             *     原理跟 ReflectionUtil 类的getParameterizedTypes方法是一样的
             */
            entityClass =  (Class <T>) ((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return entityClass;
    }

    private Map<Field, Method> fields = new HashMap<Field, Method>();

    public BaseDao(Class<T> entityClass) {
        if(entityClass != null){
            this.entityClass = entityClass;
        }
        /*
         * 实例化实体对象
         */
        try {
            Object object = this.entityClass.newInstance();
            entity = (T) object;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        /*
        * 获取实体字段
         */
        loadFields();
    }

    private void loadFields() {
        Field fields[] = entityClass.getDeclaredFields();
        Method methods[] = entityClass.getMethods();

        // 给字段设置值
        for (int i = 0; i < fields.length; i++) {
            // 用字段的名字构建set方法的名字
            String fieldName = fields[i].getName();

            String methodName = "get" + fieldName.substring(0, 1).toUpperCase()
                    + fieldName.substring(1);

            // 查找对应的方法
            Method method = null;
            for (int j = 0; j < methods.length; j++) {
                if (methods[j].getName().equals(methodName)) {
                    method = methods[j];
                    break;
                }
            }

            // 如果存在这个方法
            if (method != null) {
                // 讲字段，以及它对应的get方法放到容器里面
                this.fields.put(fields[i],method);
            }
        }
    }

    private String getCurrentClassName(){
        return new Object() {
            public String getClassName() {
                String clazzName = this.getClass().getName();
                return clazzName.substring(0, clazzName.lastIndexOf('$'));
            }
        }.getClassName();
    }

    //---------------------------------查询部分--------------------------------------------------------------------------
    /**
     * 查询所有记录
     * @param obj	表对应的JavaBean对象
     * @return		所有记录构成的list
     * @throws Exception
     */
    public List<Object> findAll(Object obj) throws Exception {

        List<Object> list = new ArrayList<Object>();
        ResultSet rs = null;
        try {
            // 获取数据库连接
            Statement stmt = DBConnectionManager.getConnection()
                    .createStatement();
            // 构建sql语句
            String tableName = obj.getClass().getName();
            tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
            tableName = StringUtils.lcfirst(tableName);
            String sql = "select * from " + tableName;

            // 执行sql语句
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(createObj(rs, obj));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        } finally {
            // 关闭连接
            if (rs != null) {
                rs.close();
            }
            DBConnectionManager.closeConnection();
        }

        return list;
    }

    /**
     * 对指定的表执行指定的sql查询语句
     * @param obj
     * 			以该表对应的JavaBean对象决定表
     * @param query
     * 			要对该表执行的sql语句
     * @return
     * @throws Exception
     */
    public List<Object> findByNameQuery(Object obj, String query) throws Exception {
        // TODO Auto-generated method stub
        List<Object> list = null;
        try {
            Statement sql_statement = DBConnectionManager.getConnection()
                    .createStatement();
            //执行传递的sql语句
            ResultSet rs = sql_statement.executeQuery(query);
            list = new ArrayList<Object>();
            if (rs != null) {
                while (rs.next()) {
                    list.add(createObj(rs, obj));
                }
            }
            return list;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        } finally {
            DBConnectionManager.closeConnection();
        }

    }

    /**
     * 按条件对指定表进行查询
     * @param obj
     * 		以该表对应的JavaBean对象决定表
     * @param condition
     * 		查询的条件，key：条件		value：值
     * @param isFuzzy
     *		是否支持模糊查询
     * @return
     * @throws Exception
     */
    public List<Object> findByNameQuery(Object obj, Map<Object,Object> condition,boolean isFuzzy) throws Exception {
        List<Object> list = new ArrayList<Object>();
        try {

            String tablename = getTableName(obj);
            StringBuilder sb = new StringBuilder("select * from " + tablename);
            PreparedStatement state = null;
            if(isFuzzy){
                addFuzzyConditionString(sb, condition);
            }
            else{
                addConditionString(sb, condition);
            }
            state = DBConnectionManager.getConnection().prepareStatement(sb.toString());
            state = setSqlValue(state, condition, isFuzzy);
            ResultSet rs = state.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    list.add(createObj(rs, obj));
                }
            }
            return list;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        } finally {
            DBConnectionManager.closeConnection();
        }
    }



    //-------------------------------------创建部分--------------------------------------------------------------------------
    /**
     * 在数据库里新建一条记录
     * @param obj
     * 		描述记录的对象,必须是数据库中某张表对应的JavaBean对象
     * @return
     * 		新建成功返回真，否则返回假
     * @throws Exception
     */
    public boolean create(Object obj) throws Exception{
        // 获取数据库连接
        try {
            // 构建sql语句
            Map<Object, Object> map = getObjectFieldValue(obj);
            String tableName = getTableName(obj);
            StringBuilder sb = new StringBuilder("insert into " + tableName);
            addCreateString(sb, map);
            PreparedStatement  stmt = DBConnectionManager.getConnection()
                    .prepareStatement(sb.toString());
            setSqlValue(stmt, map,false);
            int count = stmt.executeUpdate();
            if(count>0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            DBConnectionManager.closeConnection();
        }
    }

    //-------------------------------------删除部分----------------------------------------------------------------------------
    /**
     * 删除表中所有记录
     * @param obj
     * 			JavaBean对象，决定要删除的是哪张表
     * @return
     * 			删除成功返回真，否则返回假
     */
    public boolean deleteAll(Object obj) throws Exception{
        String delete_sql = "delete from "+getTableName(obj);
        PreparedStatement pstmt;
        try {
            pstmt = DBConnectionManager.getConnection().prepareStatement(delete_sql);
            int count = pstmt.executeUpdate();
            if(count>0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }
        finally{
            DBConnectionManager.closeConnection();
        }

    }

    /**
     * 在指定表中删除给定ID的记录
     * @param obj
     * 		表示要删除的表
     * @param condition
     * 		删除的条件 key:字段(一般为字符串) value:值
     * @return
     */
    public boolean delete(Object obj,Map<Object,Object> condition) throws Exception{
        //构建sql语句
        StringBuilder sb = new StringBuilder("delete from "+getTableName(obj));
        addConditionString(sb, condition);
        try {
            PreparedStatement pstmt = DBConnectionManager.getConnection().prepareStatement(sb.toString());
            setSqlValue(pstmt, condition,false);
            int count = pstmt.executeUpdate();
            if(count > 0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }
        finally{
            DBConnectionManager.closeConnection();
        }
    }

    //-------------------------------------更新部分----------------------------------------------------------------------------
    /**
     * 更新指定表的记录
     * @param obj
     * 		用来确定表的Java对象
     * @param map
     * 		要设置的字段值，key：字段（字符串）,value：值
     * @param condition
     * 		筛选条件
     * @return
     */
    public boolean update(Object obj,Map<Object,Object> map,Map<Object, Object>condition) throws Exception {
        StringBuilder sb = new StringBuilder("update "+getTableName(obj));
        addSetString(sb,map);
        addConditionString(sb, condition);
        try {
            PreparedStatement pstmt = DBConnectionManager.getConnection().prepareStatement(sb.toString());
            List<Object> values =  new ArrayList<Object>();
            getValuesToList(values,map);
            getValuesToList(values, condition);
            setSqlValue(pstmt, values);

            int count = pstmt.executeUpdate();
            if(count > 0){
                return true;
            }
            else{
                return false;
            }
        } catch ( Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }
        finally{
            DBConnectionManager.closeConnection();
        }
    }

    private List<Object> getValuesToList(List<Object> values,Map<Object, Object> map) {

        for (Iterator<Object> it = map.keySet().iterator(); it.hasNext();) {
            Object value =  map.get(it.next());
            values.add(value);
        }
        return values;
    }




    /**
     * 获取JavaBean对象的字段值放到容器中
     * @param obj
     * 			JavaBean对象
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private Map<Object, Object> getObjectFieldValue(Object obj)
            throws IllegalAccessException, InvocationTargetException {
        Map<Object, Object> map = new HashMap<Object,Object>();

        Field fields[] = obj.getClass().getDeclaredFields();
        Method methods[] = obj.getClass().getMethods();

        // 给字段设置值
        for (int i = 0; i < fields.length; i++) {
            // 用字段的名字构建set方法的名字
            String fieldName = fields[i].getName();

            String methodName = "get" + fieldName.substring(0, 1).toUpperCase()
                    + fieldName.substring(1);

            // 查找对应的方法
            Method method = null;
            for (int j = 0; j < methods.length; j++) {
                if (methods[j].getName().equals(methodName)) {
                    method = methods[j];
                    break;
                }
            }
            // 如果存在这个方法
            if (method != null) {
                // 开始执行方法，获取当前的JavaBean对象字段值
                Object value = method.invoke(obj, new Object[] { });
                map.put(fieldName, value);
            }
        }
        return map;
    }

    private void addSetString(StringBuilder sb, Map<Object, Object> map) {
        // TODO Auto-generated method stub
        if (!map.isEmpty()) {
            sb.append(" set ");
            for (Iterator<Object> it = map.keySet().iterator(); it.hasNext();) {
                String key = (String) it.next();
                if (null == key) {
                    continue;
                }
                sb.append(key+"=?,");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            System.out.println(sb.toString());
        }
    }

    /**
     * 在现有sql创建语句后面追加字段名和占位符
     * @param sb
     * @param map
     */
    private void addCreateString(StringBuilder sb,Map<Object, Object> map) {
        // TODO Auto-generated method stub
        sb.append("(");
        int count = 0;
        for (Iterator<Object> it = map.keySet().iterator(); it.hasNext();) {
            String key = (String) it.next();
            if (null == key) {
                continue;
            }
            sb.append(key + ",");
            count++;
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(") values(");
        for (int i = 0; i < count; i++) {
            sb.append("?,");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(")");
        System.out.println(sb.toString());
    }

    /**
     * 在现有sql查询语句后面追加判断条件
     * @param sb  			where之前的sql
     * @param condition 	条件(key:字段名；value:值)
     * @return	使用占位符的sql语句
     */
    private String addConditionString(StringBuilder sb, Map<Object,Object> condition) {
        if (!condition.isEmpty()) {
            sb.append(" where ");
            int i = 0;

            for (Iterator<Object> it = condition.keySet().iterator(); it.hasNext();) {
                String key = (String) it.next();
                if (null == key) {
                    continue;
                }
                if (i != 0) {
                    sb.append(" and ");
                }
                if (key.indexOf("<") != -1 || key.indexOf(">") != -1
                        || key.indexOf("=") != -1) {
                    sb.append(key + "?");
                } else {
                    sb.append(key + "=" + "?");
                }

                i++;

            }

        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    private String addFuzzyConditionString(StringBuilder sb,Map<Object,Object>condition) {
        if (!condition.isEmpty()) {
            sb.append(" where ");
            int i = 0;

            for (Iterator<Object> it = condition.keySet().iterator(); it.hasNext();) {
                String key = (String) it.next();
                if (null == key) {
                    continue;
                }
                if (i != 0) {
                    sb.append(" or ");
                }
                sb.append(key + " like " +"?");
                i++;
            }

        }
        System.out.println(sb.toString());
        return sb.toString();
    }


    /**
     * 设置现有sql语句的占位符的值
     * @param state
     * @param map
     * @return
     * @throws SQLException
     */
    private PreparedStatement setSqlValue(PreparedStatement state, Map<Object,Object> map,boolean isFuzzy)
            throws SQLException {
        if (!map.isEmpty()) {
            int i = 1;
            for (Iterator<Object> it = map.keySet().iterator(); it.hasNext();) {
                Object value = map.get(it.next());
                if(isFuzzy){
                    state.setObject(i++, "%"+value+"%");
                }else{
                    state.setObject(i++, value);
                }
            }

        }
        return state;
    }
    private PreparedStatement setSqlValue(PreparedStatement state, List<Object> values)
            throws SQLException {
        if (!values.isEmpty()) {
            int i = 1;
            for (Iterator<Object> it = values.iterator(); it.hasNext();) {
                Object value = it.next();
                state.setObject(i++, value);
            }

        }
        return state;
    }

    private String getTableName(Object obj) {
        String tablename = obj.getClass().getName();
        tablename = tablename.substring(tablename.lastIndexOf(".") + 1);
        return StringUtils.lcfirst(tablename);
    }

    /**
     * 使用LinkedHashMap 是为了保证顺序与entitys保持一致
     * 而且LinkedHashMap比HashMap跌打更快
     */
    private  Map<Object,List<Object>> values = new LinkedHashMap<Object, List<Object>>();

    protected String buildInsert(List<T> entitys){
        values.clear();
        StringBuilder sqlSb = new StringBuilder("insert into "+ getTableName());
        StringBuilder fieldsSb = new StringBuilder("(");
        StringBuilder valuesSb = new StringBuilder();
        StringBuilder valueSb = new StringBuilder("(");
        for(Iterator<Map.Entry<Field,Method>> it = fields.entrySet().iterator();it.hasNext();){
            Map.Entry<Field,Method> item = it.next();
            Field field = item.getKey();
            fieldsSb.append(field.getName());
            fieldsSb.append(",");
            Method method = item.getValue();

            for (BaseEntity en : entitys){
                try {
                    if(values.get(en) == null){
                        values.put(en,new ArrayList<Object>());
                    }
                    values.get(en).add(method.invoke(en, new Object[]{}));

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            valueSb.append("?,");
        }
        valueSb.deleteCharAt(valueSb.length()-1).append(")");
        for(int i = 0 ;i< entitys.size();i++) {
            valuesSb.append(valueSb.toString());
            valuesSb.append(",");
        }
        fieldsSb.deleteCharAt(fieldsSb.length()-1).append(")");
        valuesSb.deleteCharAt(valuesSb.length()-1);
        sqlSb.append(fieldsSb.toString());
        sqlSb.append(" values ");
        sqlSb.append(valuesSb.toString());
        return sqlSb.toString();
    }



    /**
     *     利用反射构建对象
     */
    private Object createObj(ResultSet rs, Object obj)
            throws  Exception {
        // TODO Auto-generated method stub
        Object object = obj.getClass().newInstance();
        // 获取字段
        Field fields[] = obj.getClass().getDeclaredFields();
        // 获取方法
        Method methods[] = obj.getClass().getMethods();

        // 给字段设置值
        for (int i = 0; i < fields.length; i++) {
            // 用字段的名字构建set方法的名字
            String fieldName = fields[i].getName();
            String methodName = "set" + fieldName.substring(0, 1).toUpperCase()
                    + fieldName.substring(1);

            // 查找对应的方法
            Method method = null;
            for (int j = 0; j < methods.length; j++) {
                if (methods[j].getName().equals(methodName)) {
                    method = methods[j];
                    break;
                }
            }

            // 如果存在这个方法
            if (method != null) {
                // 开始执行方法，为当前的JavaBean对象字段设置值
                Object value = rs.getObject(fieldName);
                method.invoke(object, new Object[] { value });
            }
        }
        return object;
    }

    public String getTableName()
    {
        String tableName = entity.getTableName();
        if(tableName == null || tableName.trim().equals("")){
            tableName = entityClass.getName();
            tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
            tableName = StringUtils.lcfirst(tableName);
        }
        return tableName;
    }

    public void addAll(List<T> entits) {
        String sql = buildInsert(entits);
        try {
            PreparedStatement  stmt = DBConnectionManager.getConnection()
                    .prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);//  获取返回的主键值
            int i = 1;
            for (Iterator<Map.Entry<Object,List<Object>>> it = values.entrySet().iterator();it.hasNext();){
                Map.Entry<Object,List<Object>> item = it.next();
                List<Object> val = item.getValue();
                for (Object object : val){
                    stmt.setObject(i,object);
                    i++;
                }
            }
            System.out.println(stmt);
            stmt.executeUpdate();
            /*
            * 设置数据库返回的ID,与插入时的顺序保持一致
             */
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs != null){
                for (i = 0;rs.next();i++){
                    entits.get(i).setId(rs.getInt(1));
                    System.out.println(rs.getObject(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnectionManager.closeConnection();
        }

    }

    public static void main(String[] args) {
        BaseDao<Line> baseDao = new BaseDao<Line>(Line.class);
        System.out.println(baseDao.getTableName());
        List<Line> lines = new ArrayList<Line>();
        Line line = new Line();
        line.setUin("00000");
        line.setLineContent("poippoio/sdfsdfsdf/werewr");
        line.setLineKey("00000/3432/4545");
        lines.add(line);
        line = new Line();
        line.setUin("32432432");
        line.setLineContent("sdfdsf/sdfsdfsdf/werewr");
        line.setLineKey("34324/3432/4545");
        lines.add(line);
        baseDao.addAll(lines);
    }


}