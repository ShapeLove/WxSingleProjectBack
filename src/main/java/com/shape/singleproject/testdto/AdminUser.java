package com.shape.singleproject.testdto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
*
*  @author author
*/
public class AdminUser implements Serializable {

    private static final long serialVersionUID = 1560160125905L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Integer id;

    /**
    * 管理员名字
    * isNullAble:0
    */
    private String name;

    /**
    * 管理员级别
    * isNullAble:0
    */
    private Integer level;

    /**
    * 创建时间
    * isNullAble:0,defaultVal:CURRENT_TIMESTAMP
    */
    private java.time.LocalDateTime create;

    /**
    * 管理员密码
    * isNullAble:0
    */
    private String passwd;


    public void setId(Integer id){this.id = id;}

    public Integer getId(){return this.id;}

    public void setName(String name){this.name = name;}

    public String getName(){return this.name;}

    public void setLevel(Integer level){this.level = level;}

    public Integer getLevel(){return this.level;}

    public void setCreate(java.time.LocalDateTime create){this.create = create;}

    public java.time.LocalDateTime getCreate(){return this.create;}

    public void setPasswd(String passwd){this.passwd = passwd;}

    public String getPasswd(){return this.passwd;}
    @Override
    public String toString() {
        return "AdminUser{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                "level='" + level + '\'' +
                "create='" + create + '\'' +
                "passwd='" + passwd + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private AdminUser set;

        private ConditionBuilder where;

        public UpdateBuilder set(AdminUser set){
            this.set = set;
            return this;
        }

        public AdminUser getSet(){
            return this.set;
        }

        public UpdateBuilder where(ConditionBuilder where){
            this.where = where;
            return this;
        }

        public ConditionBuilder getWhere(){
            return this.where;
        }

        public UpdateBuilder build(){
            return this;
        }
    }

    public static class QueryBuilder extends AdminUser{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<String> nameList;

        public List<String> getNameList(){return this.nameList;}


        private List<String> fuzzyName;

        public List<String> getFuzzyName(){return this.fuzzyName;}

        private List<String> rightFuzzyName;

        public List<String> getRightFuzzyName(){return this.rightFuzzyName;}
        private List<Integer> levelList;

        public List<Integer> getLevelList(){return this.levelList;}

        private Integer levelSt;

        private Integer levelEd;

        public Integer getLevelSt(){return this.levelSt;}

        public Integer getLevelEd(){return this.levelEd;}

        private List<java.time.LocalDateTime> createList;

        public List<java.time.LocalDateTime> getCreateList(){return this.createList;}

        private java.time.LocalDateTime createSt;

        private java.time.LocalDateTime createEd;

        public java.time.LocalDateTime getCreateSt(){return this.createSt;}

        public java.time.LocalDateTime getCreateEd(){return this.createEd;}

        private List<String> passwdList;

        public List<String> getPasswdList(){return this.passwdList;}


        private List<String> fuzzyPasswd;

        public List<String> getFuzzyPasswd(){return this.fuzzyPasswd;}

        private List<String> rightFuzzyPasswd;

        public List<String> getRightFuzzyPasswd(){return this.rightFuzzyPasswd;}
        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder idBetWeen(Integer idSt,Integer idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public QueryBuilder idGreaterEqThan(Integer idSt){
            this.idSt = idSt;
            return this;
        }
        public QueryBuilder idLessEqThan(Integer idEd){
            this.idEd = idEd;
            return this;
        }


        public QueryBuilder id(Integer id){
            setId(id);
            return this;
        }

        public QueryBuilder idList(Integer ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public QueryBuilder idList(List<Integer> id){
            this.idList = id;
            return this;
        }

        public QueryBuilder fetchId(){
            setFetchFields("fetchFields","id");
            return this;
        }

        public QueryBuilder excludeId(){
            setFetchFields("excludeFields","id");
            return this;
        }

        public QueryBuilder fuzzyName (List<String> fuzzyName){
            this.fuzzyName = fuzzyName;
            return this;
        }

        public QueryBuilder fuzzyName (String ... fuzzyName){
            this.fuzzyName = solveNullList(fuzzyName);
            return this;
        }

        public QueryBuilder rightFuzzyName (List<String> rightFuzzyName){
            this.rightFuzzyName = rightFuzzyName;
            return this;
        }

        public QueryBuilder rightFuzzyName (String ... rightFuzzyName){
            this.rightFuzzyName = solveNullList(rightFuzzyName);
            return this;
        }

        public QueryBuilder name(String name){
            setName(name);
            return this;
        }

        public QueryBuilder nameList(String ... name){
            this.nameList = solveNullList(name);
            return this;
        }

        public QueryBuilder nameList(List<String> name){
            this.nameList = name;
            return this;
        }

        public QueryBuilder fetchName(){
            setFetchFields("fetchFields","name");
            return this;
        }

        public QueryBuilder excludeName(){
            setFetchFields("excludeFields","name");
            return this;
        }

        public QueryBuilder levelBetWeen(Integer levelSt,Integer levelEd){
            this.levelSt = levelSt;
            this.levelEd = levelEd;
            return this;
        }

        public QueryBuilder levelGreaterEqThan(Integer levelSt){
            this.levelSt = levelSt;
            return this;
        }
        public QueryBuilder levelLessEqThan(Integer levelEd){
            this.levelEd = levelEd;
            return this;
        }


        public QueryBuilder level(Integer level){
            setLevel(level);
            return this;
        }

        public QueryBuilder levelList(Integer ... level){
            this.levelList = solveNullList(level);
            return this;
        }

        public QueryBuilder levelList(List<Integer> level){
            this.levelList = level;
            return this;
        }

        public QueryBuilder fetchLevel(){
            setFetchFields("fetchFields","level");
            return this;
        }

        public QueryBuilder excludeLevel(){
            setFetchFields("excludeFields","level");
            return this;
        }

        public QueryBuilder createBetWeen(java.time.LocalDateTime createSt,java.time.LocalDateTime createEd){
            this.createSt = createSt;
            this.createEd = createEd;
            return this;
        }

        public QueryBuilder createGreaterEqThan(java.time.LocalDateTime createSt){
            this.createSt = createSt;
            return this;
        }
        public QueryBuilder createLessEqThan(java.time.LocalDateTime createEd){
            this.createEd = createEd;
            return this;
        }


        public QueryBuilder create(java.time.LocalDateTime create){
            setCreate(create);
            return this;
        }

        public QueryBuilder createList(java.time.LocalDateTime ... create){
            this.createList = solveNullList(create);
            return this;
        }

        public QueryBuilder createList(List<java.time.LocalDateTime> create){
            this.createList = create;
            return this;
        }

        public QueryBuilder fetchCreate(){
            setFetchFields("fetchFields","create");
            return this;
        }

        public QueryBuilder excludeCreate(){
            setFetchFields("excludeFields","create");
            return this;
        }

        public QueryBuilder fuzzyPasswd (List<String> fuzzyPasswd){
            this.fuzzyPasswd = fuzzyPasswd;
            return this;
        }

        public QueryBuilder fuzzyPasswd (String ... fuzzyPasswd){
            this.fuzzyPasswd = solveNullList(fuzzyPasswd);
            return this;
        }

        public QueryBuilder rightFuzzyPasswd (List<String> rightFuzzyPasswd){
            this.rightFuzzyPasswd = rightFuzzyPasswd;
            return this;
        }

        public QueryBuilder rightFuzzyPasswd (String ... rightFuzzyPasswd){
            this.rightFuzzyPasswd = solveNullList(rightFuzzyPasswd);
            return this;
        }

        public QueryBuilder passwd(String passwd){
            setPasswd(passwd);
            return this;
        }

        public QueryBuilder passwdList(String ... passwd){
            this.passwdList = solveNullList(passwd);
            return this;
        }

        public QueryBuilder passwdList(List<String> passwd){
            this.passwdList = passwd;
            return this;
        }

        public QueryBuilder fetchPasswd(){
            setFetchFields("fetchFields","passwd");
            return this;
        }

        public QueryBuilder excludePasswd(){
            setFetchFields("excludeFields","passwd");
            return this;
        }
        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public QueryBuilder fetchAll(){
            this.fetchFields.put("AllFields",true);
            return this;
        }

        public QueryBuilder addField(String ... fields){
            List<String> list = new ArrayList<>();
            if (fields != null){
                for (String field : fields){
                    list.add(field);
                }
            }
            this.fetchFields.put("otherFields",list);
            return this;
        }
        @SuppressWarnings("unchecked")
        private void setFetchFields(String key,String val){
            Map<String,Boolean> fields= (Map<String, Boolean>) this.fetchFields.get(key);
            if (fields == null){
                fields = new HashMap<>();
            }
            fields.put(val,true);
            this.fetchFields.put(key,fields);
        }

        public AdminUser build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<String> nameList;

        public List<String> getNameList(){return this.nameList;}


        private List<String> fuzzyName;

        public List<String> getFuzzyName(){return this.fuzzyName;}

        private List<String> rightFuzzyName;

        public List<String> getRightFuzzyName(){return this.rightFuzzyName;}
        private List<Integer> levelList;

        public List<Integer> getLevelList(){return this.levelList;}

        private Integer levelSt;

        private Integer levelEd;

        public Integer getLevelSt(){return this.levelSt;}

        public Integer getLevelEd(){return this.levelEd;}

        private List<java.time.LocalDateTime> createList;

        public List<java.time.LocalDateTime> getCreateList(){return this.createList;}

        private java.time.LocalDateTime createSt;

        private java.time.LocalDateTime createEd;

        public java.time.LocalDateTime getCreateSt(){return this.createSt;}

        public java.time.LocalDateTime getCreateEd(){return this.createEd;}

        private List<String> passwdList;

        public List<String> getPasswdList(){return this.passwdList;}


        private List<String> fuzzyPasswd;

        public List<String> getFuzzyPasswd(){return this.fuzzyPasswd;}

        private List<String> rightFuzzyPasswd;

        public List<String> getRightFuzzyPasswd(){return this.rightFuzzyPasswd;}

        public ConditionBuilder idBetWeen(Integer idSt,Integer idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public ConditionBuilder idGreaterEqThan(Integer idSt){
            this.idSt = idSt;
            return this;
        }
        public ConditionBuilder idLessEqThan(Integer idEd){
            this.idEd = idEd;
            return this;
        }


        public ConditionBuilder idList(Integer ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public ConditionBuilder idList(List<Integer> id){
            this.idList = id;
            return this;
        }

        public ConditionBuilder fuzzyName (List<String> fuzzyName){
            this.fuzzyName = fuzzyName;
            return this;
        }

        public ConditionBuilder fuzzyName (String ... fuzzyName){
            this.fuzzyName = solveNullList(fuzzyName);
            return this;
        }

        public ConditionBuilder rightFuzzyName (List<String> rightFuzzyName){
            this.rightFuzzyName = rightFuzzyName;
            return this;
        }

        public ConditionBuilder rightFuzzyName (String ... rightFuzzyName){
            this.rightFuzzyName = solveNullList(rightFuzzyName);
            return this;
        }

        public ConditionBuilder nameList(String ... name){
            this.nameList = solveNullList(name);
            return this;
        }

        public ConditionBuilder nameList(List<String> name){
            this.nameList = name;
            return this;
        }

        public ConditionBuilder levelBetWeen(Integer levelSt,Integer levelEd){
            this.levelSt = levelSt;
            this.levelEd = levelEd;
            return this;
        }

        public ConditionBuilder levelGreaterEqThan(Integer levelSt){
            this.levelSt = levelSt;
            return this;
        }
        public ConditionBuilder levelLessEqThan(Integer levelEd){
            this.levelEd = levelEd;
            return this;
        }


        public ConditionBuilder levelList(Integer ... level){
            this.levelList = solveNullList(level);
            return this;
        }

        public ConditionBuilder levelList(List<Integer> level){
            this.levelList = level;
            return this;
        }

        public ConditionBuilder createBetWeen(java.time.LocalDateTime createSt,java.time.LocalDateTime createEd){
            this.createSt = createSt;
            this.createEd = createEd;
            return this;
        }

        public ConditionBuilder createGreaterEqThan(java.time.LocalDateTime createSt){
            this.createSt = createSt;
            return this;
        }
        public ConditionBuilder createLessEqThan(java.time.LocalDateTime createEd){
            this.createEd = createEd;
            return this;
        }


        public ConditionBuilder createList(java.time.LocalDateTime ... create){
            this.createList = solveNullList(create);
            return this;
        }

        public ConditionBuilder createList(List<java.time.LocalDateTime> create){
            this.createList = create;
            return this;
        }

        public ConditionBuilder fuzzyPasswd (List<String> fuzzyPasswd){
            this.fuzzyPasswd = fuzzyPasswd;
            return this;
        }

        public ConditionBuilder fuzzyPasswd (String ... fuzzyPasswd){
            this.fuzzyPasswd = solveNullList(fuzzyPasswd);
            return this;
        }

        public ConditionBuilder rightFuzzyPasswd (List<String> rightFuzzyPasswd){
            this.rightFuzzyPasswd = rightFuzzyPasswd;
            return this;
        }

        public ConditionBuilder rightFuzzyPasswd (String ... rightFuzzyPasswd){
            this.rightFuzzyPasswd = solveNullList(rightFuzzyPasswd);
            return this;
        }

        public ConditionBuilder passwdList(String ... passwd){
            this.passwdList = solveNullList(passwd);
            return this;
        }

        public ConditionBuilder passwdList(List<String> passwd){
            this.passwdList = passwd;
            return this;
        }

        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public ConditionBuilder build(){return this;}
    }

    public static class Builder {

        private AdminUser obj;

        public Builder(){
            this.obj = new AdminUser();
        }

        public Builder id(Integer id){
            this.obj.setId(id);
            return this;
        }
        public Builder name(String name){
            this.obj.setName(name);
            return this;
        }
        public Builder level(Integer level){
            this.obj.setLevel(level);
            return this;
        }
        public Builder create(java.time.LocalDateTime create){
            this.obj.setCreate(create);
            return this;
        }
        public Builder passwd(String passwd){
            this.obj.setPasswd(passwd);
            return this;
        }
        public AdminUser build(){return obj;}
    }

}
